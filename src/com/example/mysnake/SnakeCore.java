package com.example.mysnake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class SnakeCore implements GameCoreInterface {

	SnakeDisplayAdapter m_dispAd;
	int m_iMax;
	int m_jMax;
	
	boolean m_isPause;
	
	SnakeDir m_dir;
	SnakeCmd m_lastCmd;
		
	ArrayList<SnakeNode> m_nodeList;
	SnakeNode m_food;
	
	int m_foodNum;
	int m_cycleTime;
	
	public SnakeCore(SnakeDisplayAdapter dispAd, int i, int j)
	{
		m_dispAd = dispAd;
		m_iMax = i;
		m_jMax = j;
		
		m_nodeList = new ArrayList<SnakeNode>();
		
		m_foodNum = 0;
		m_cycleTime = 500;
	}
		
	@Override
	public void OnKeyDown(SnakeCmd cmd) {
		
		switch(cmd)
		{
			case CMD_UP:
			{
				if( m_dir != SnakeDir.DIR_DOWN)
				{
					m_dir = SnakeDir.DIR_UP;
				}
				break;
			}
			case CMD_DOWN:
			{
				if( m_dir != SnakeDir.DIR_UP)
				m_dir = SnakeDir.DIR_DOWN;
				break;
			}
			case CMD_LEFT:
			{
				if( m_dir != SnakeDir.DIR_RIGHT)
				{
					m_dir = SnakeDir.DIR_LEFT;
				}
				break;
			}
			case CMD_PAUSE:
				break;
			case CMD_RIGHT:
			{
				if( m_dir != SnakeDir.DIR_LEFT)
				{
					m_dir = SnakeDir.DIR_RIGHT;
				}
				break;
			}
			case CMD_START:
				break;
			default:
				break;
				
			
		}
		
		m_lastCmd = cmd;
		m_isPause = false;

	}
	
	
	private boolean moveSnake(ArrayList<SnakeNode> nodes, SnakeDir dir)
	{
		/** Move the Snake to a direction */
	
		/** TODO: Parameter test*/
		
		/** Decide the next Snake Head Position */
		SnakeNode nextHead = new SnakeNode(nodes.get(0).i, nodes.get(0).j, nodes.get(0).s);
		
		switch(dir)
		{
		case DIR_DOWN:
		{
			nextHead.j++;
			break;
		}
		case DIR_LEFT:
		{
			nextHead.i--;
			break;
		}
		case DIR_RIGHT:
		{
			nextHead.i++;
			break;
		}
		case DIR_UP:
		{
			nextHead.j--;
			break;
		}
		default:
			break;
		
		}
		
		/** If the head hit the border, game over */
		if(nextHead.i >= m_iMax || nextHead.j >= m_jMax || nextHead.i < 0 || nextHead.j < 0)
		{
			return false;
		}
				
		/** If the head hit itself, game over */
		if(isInSankeNodeList(nextHead))
		{
			return false;
		}
		
		/** If the head hit a food, elongate the Snake */
		if(nextHead.equ(m_food))
		{
			nodes.get(0).s = SnakeNodeStatus.SNAKE_BODY;
			nodes.add(0, nextHead);
			m_food = null;
			m_foodNum++;
			return true;
		}
		
		/** If the head hit nothing, move the Snake */
		int i;
		
		for( i = nodes.size()-1 ; i > 0 ; --i)
		{
			nodes.get(i).i = nodes.get(i-1).i;
			nodes.get(i).j = nodes.get(i-1).j;
		}
		
		nodes.get(0).i = nextHead.i;
		nodes.get(0).j = nextHead.j;
		
		return true;
	}
	
	
	
	@Override
	public void run()
	{
		/** Initialize the display module */
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m_dispAd.Init(m_iMax, m_jMax);
		GameStart();
		
		/** Main Loop for game */
		while(true)
		{
			if(m_isPause == false)
			{
				/** Move the snake to a direction and decide if game is over */
				if(false == moveSnake(m_nodeList, m_dir))
				{
					GameOver();
				}
				
				/** If there are no food, Generate a food in a random position */
				if(m_food == null)
				{
					m_food = generateRandomeFood(m_iMax ,m_jMax);
				}
				
				/** Decide whether we should speed up */
				if( m_foodNum == 5)
				{
					m_foodNum = 0;
					m_cycleTime = m_cycleTime - 50;
				}
				
				/** Fill the display buffer and update view */
				m_dispAd.ClearDispBuf();
				m_dispAd.FillDispBuf(m_nodeList, m_food);
				m_dispAd.UpdateDisplay();
			}
			
			/** Wait for next cycle */
			try {
				Thread.sleep(m_cycleTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
	private boolean isInSankeNodeList(SnakeNode node)
	{
		Iterator<SnakeNode> i = m_nodeList.iterator();
		
		while(i.hasNext())
		{
			if(i.next().equ(node))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	private SnakeNode generateRandomeFood(int maxI, int maxJ)
	{
		Random rand = new Random();
		
		int i = rand.nextInt(maxI);
		int j = rand.nextInt(maxJ);
		
		SnakeNode foodNode = new SnakeNode(i, j, SnakeNodeStatus.SNAKE_FOOD);
		
		while(isInSankeNodeList(foodNode))
		{
			i = rand.nextInt(maxI);
			j = rand.nextInt(maxJ);
			
			foodNode = new SnakeNode(i, j, SnakeNodeStatus.SNAKE_FOOD);
		}
		
		return foodNode;
	}
	
	
	
	private void GameStart()
	{
		/** Generate the Snake in a fixed position, generate a random position food and pause the game */
		
		m_nodeList.add(new SnakeNode(m_iMax/2, m_jMax/2, SnakeNodeStatus.SNAKE_HEAD));
		m_nodeList.add(new SnakeNode(m_iMax/2-1, m_jMax/2, SnakeNodeStatus.SNAKE_BODY));
		m_nodeList.add(new SnakeNode(m_iMax/2-2, m_jMax/2, SnakeNodeStatus.SNAKE_BODY));
		m_food = generateRandomeFood(m_iMax, m_jMax);
		
		m_isPause = true;
	
		m_dispAd.FillDispBuf(m_nodeList, m_food);
		m_dispAd.UpdateDisplay();
		
		return;
	}
	
	
	private void GameOver()
	{
		/** Game Over, pause the game */
		
		m_isPause = false;
		return;
	}

}

