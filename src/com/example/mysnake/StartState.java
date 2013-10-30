package com.example.mysnake;

public class StartState implements SnakeStateInterface {

	SnakeCore m_core;
	
	public StartState(SnakeCore core)
	{
		m_core = core;
	}
	
	@Override
	public void ProcessCmd(SnakeCmd cmd) {
		// If player presses any key, start the game
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
		
		m_core.SetState(m_core.m_playState);
	}

	@Override
	public void run() {
		// We do nothing in Start state
	}

}
