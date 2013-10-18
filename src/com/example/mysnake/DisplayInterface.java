package com.example.mysnake;

interface DisplayInterface {

	public abstract char[][] GetDispBuf();
	public abstract void ClearDispBuf();
	public abstract void Init(int i, int j);
	public abstract void UpdateDisplay();
	
}
