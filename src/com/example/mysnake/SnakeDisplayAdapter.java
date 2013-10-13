package com.example.mysnake;

public class SnakeDisplayAdapter implements DisplayInterface{

	DisplayInterface m_dispIf;
	
	public SnakeDisplayAdapter(DisplayInterface dispIf)
	{
		m_dispIf = dispIf;
	}

	@Override
	public char[] GetDispBuf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SetDispBuf(char[] disp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateDisplay() {
		// TODO Auto-generated method stub
		m_dispIf.UpdateDisplay();
	}
	
	
	
}
