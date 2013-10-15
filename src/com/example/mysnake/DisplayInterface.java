package com.example.mysnake;

interface DisplayInterface {

	public abstract char[][] GetDispBuf();
	public void InitDispBuffer(int i, int j);
	public abstract void UpdateDisplay();
	
}
