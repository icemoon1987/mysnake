package com.example.mysnake;

public class SnakeDisplayAdapter implements DisplayInterface{

	DisplayInterface m_dispIf;
	
	public SnakeDisplayAdapter(DisplayInterface dispIf)
	{
		m_dispIf = dispIf;
	}
	
	@Override
	public char[][] GetDispBuf() {
		// TODO Auto-generated method stub
		return m_dispIf.GetDispBuf();
	}

	@Override
	public void UpdateDisplay() {
		// TODO Auto-generated method stub
		m_dispIf.UpdateDisplay();
	}

	@Override
	public void InitDispBuffer(int i, int j) {
		// TODO Auto-generated method stub
		m_dispIf.InitDispBuffer(i, j);
	}
	
	
	
}
