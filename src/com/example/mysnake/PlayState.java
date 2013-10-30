package com.example.mysnake;

public class PlayState implements SnakeStateInterface {

	SnakeCore m_core;

	
	public PlayState(SnakeCore core)
	{
		m_core = core;
	}
	
	@Override
	public void ProcessCmd(SnakeCmd cmd) {
		
		switch(cmd)
		{
			case CMD_UP:
			{
				if( m_core.GetDir() != SnakeDir.DIR_DOWN)
				{
					m_core.SetDir(SnakeDir.DIR_UP);
				}
				break;
			}
			case CMD_DOWN:
			{
				if( m_core.GetDir() != SnakeDir.DIR_UP)
				{
					m_core.SetDir(SnakeDir.DIR_DOWN);
				}
				break;
			}
			case CMD_LEFT:
			{
				if( m_core.GetDir() != SnakeDir.DIR_RIGHT)
				{
					m_core.SetDir(SnakeDir.DIR_LEFT);
				}
				break;
			}
			case CMD_PAUSE:
				break;
			case CMD_RIGHT:
			{
				if( m_core.GetDir() != SnakeDir.DIR_LEFT)
				{
					m_core.SetDir(SnakeDir.DIR_RIGHT);
				}
				break;
			}
			case CMD_START:
				break;
			default:
				break;
		}
	}

	@Override
	public void run() {
		
		/** Move the snake to a direction and decide if game is over */
		if(false == m_core.moveSnake())
		{
			m_core.SetState(m_core.m_overState);
			return;
		}
		
		/** If there are no food, Generate a food in a random position */
		if(m_core.m_food == null)
		{
			m_core.m_food = m_core.generateRandomeFood(m_core.m_iMax ,m_core.m_jMax);
		}
		
		/** Decide whether we should speed up */
		if( m_core.m_foodNum == 5)
		{
			m_core.m_foodNum = 0;
			m_core.m_cycleTime = m_core.m_cycleTime - 50;
		}
		
		/** Fill the display buffer and update view */
		m_core.m_dispAd.ClearDispBuf();
		m_core.m_dispAd.FillDispBuf(m_core.m_nodeList, m_core.m_food);
		m_core.m_dispAd.UpdateDisplay();
	
		/** Wait for next cycle */
		try {
			Thread.sleep(m_core.m_cycleTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
