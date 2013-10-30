package com.example.mysnake;

public class OverState implements SnakeStateInterface {

	SnakeCore m_core;
	
	public OverState(SnakeCore core)
	{
		m_core = core;
	}
	
	@Override
	public void ProcessCmd(SnakeCmd cmd) {
		// If player presses a key when Game Over, restart the game
		
		m_core.m_nodeList.clear();
		
		m_core.GameStart();
		
		m_core.m_dispAd.ClearDispBuf();
		m_core.m_dispAd.FillDispBuf(m_core.m_nodeList, m_core.m_food);
		m_core.m_dispAd.UpdateDisplay();
		
		
		m_core.SetState(m_core.m_startState);
		
		return;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		m_core.GameOver();
	}

}
