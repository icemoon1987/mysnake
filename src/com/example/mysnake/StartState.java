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
		m_core.SetState(m_core.m_playState);
	}

	@Override
	public void run() {
		// We do nothing in Start state
	}

}
