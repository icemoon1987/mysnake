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
		
	ArrayList<SnakeNode> m_nodeList;
	SnakeNode m_food;
	
	int m_foodNum;
	int m_cycleTime;
	
	/** Game States */
	
	StartState m_startState;
	PauseState m_pauseState;
	PlayState m_playState;
	OverState m_overState;
	
	SnakeStateInterface m_state;
	
	public SnakeCore(SnakeDisplayAdapter dispAd, int i, int j)
	{
		m_dispAd = dispAd;
		m_iMax = i;
		m_jMax = j;
		
		m_nodeList = new ArrayList<SnakeNode>();
		
		m_foodNum = 0;
		m_cycleTime = 500;
		
		m_startState = new StartState(this);
		m_pauseState = new PauseState(this);
		m_playState = new PlayState(this);
		m_overState = new OverState(this);
		
		m_state = m_startState;
	}
	
	public void SetState(SnakeStateInterface state)
	{
		m_state = state;
	}
	
	public void SetDir(SnakeDir dir)
	{
		m_dir = dir;
	}
	
	public SnakeDir GetDir()
	{
		return m_dir;
	}
	
	
	@Override
	public void OnKeyDown(SnakeCmd cmd) {

		m_state.ProcessCmd(cmd);
		
	}
	
	
	public boolean moveSnake()
	{
		/** Move the Snake to a direction */
	
		/** Decide the next Snake Head Position */
		SnakeNode nextHead = new SnakeNode(m_nodeList.get(0).i, m_nodeList.get(0).j, m_nodeList.get(0).s);
		
		switch(m_dir)
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
			m_nodeList.get(0).s = SnakeNodeStatus.SNAKE_BODY;
			m_nodeList.add(0, nextHead);
			m_food = null;
			m_foodNum++;
			return true;
		}
		
		/** If the head hit nothing, move the Snake */
		int i;
		
		for( i = m_nodeList.size()-1 ; i > 0 ; --i)
		{
			m_nodeList.get(i).i = m_nodeList.get(i-1).i;
			m_nodeList.get(i).j = m_nodeList.get(i-1).j;
		}
		
		m_nodeList.get(0).i = nextHead.i;
		m_nodeList.get(0).j = nextHead.j;
		
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
		
		m_dispAd.ClearDispBuf();
		m_dispAd.FillDispBuf(m_nodeList, m_food);
		m_dispAd.UpdateDisplay();
		
		/** Main Loop for game */		
		while(true)
		{
			m_state.run();
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
	
	
	public SnakeNode generateRandomeFood(int maxI, int maxJ)
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
	
	
	
	public void GameStart()
	{
		/** Generate the Snake in a fixed position, generate a random position food and pause the game */
		
		m_nodeList.add(new SnakeNode(m_iMax/2, m_jMax/2, SnakeNodeStatus.SNAKE_HEAD));
		m_nodeList.add(new SnakeNode(m_iMax/2-1, m_jMax/2, SnakeNodeStatus.SNAKE_BODY));
		m_nodeList.add(new SnakeNode(m_iMax/2-2, m_jMax/2, SnakeNodeStatus.SNAKE_BODY));
		m_food = generateRandomeFood(m_iMax, m_jMax);

		m_dir = SnakeDir.DIR_RIGHT;
		
		m_dispAd.setGameOver(false);
		
		m_dispAd.FillDispBuf(m_nodeList, m_food);
		m_dispAd.UpdateDisplay();
		
		return;
	}
	
	
	public void GameOver()
	{
		/** Generate the Snake in a fixed position, generate a random position food and pause the game */
		
		m_dispAd.setGameOver(true);
		
		return;
	}
	
}

