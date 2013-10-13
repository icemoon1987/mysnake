package com.example.mysnake;

public class SnakeCore implements GameCoreInterface {

	SnakeDisplayAdapter m_dispAd;
	
	public SnakeCore(DisplayInterface dispIf)
	{
		m_dispAd = new SnakeDisplayAdapter(dispIf);
	}
		
	@Override
	public void OnKeyDown(SnakeCmd cmd) {
		// TODO Auto-generated method stub

		m_dispAd.UpdateDisplay();
		
	}

}

