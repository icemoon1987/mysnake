package com.example.mysnake;

import java.util.ArrayList;
import android.os.Handler;


public class SnakeDisplayAdapter implements DisplayInterface{

	DisplayInterface m_dispIf;
	Handler m_msgHandler;
	
	int m_iMax;
	int m_jMax;
	
	public SnakeDisplayAdapter(DisplayInterface dispIf, Handler msgHandler)
	{
		m_dispIf = dispIf;
		m_msgHandler = msgHandler;
	}
	
	public void FillDispBuf(ArrayList<SnakeNode> nodeList, SnakeNode food)
	{
		int listLen = nodeList.size();
		SnakeNode node;
		
		if(listLen == 0)
		{
			return;
		}

		for( int i = 0 ; i < listLen ; ++i)
		{
			node= nodeList.get(i);
			m_dispIf.GetDispBuf()[node.i][node.j] = GetColor(node.s);
		}
		
		if(food != null)
		{
			m_dispIf.GetDispBuf()[food.i][food.j] = GetColor(food.s);
		}
	}
	
	
	@Override
	public char[][] GetDispBuf() {
		return m_dispIf.GetDispBuf();
	}

	@Override
	public void UpdateDisplay() {
		m_msgHandler.sendEmptyMessage(MsgTypes.UPDATE_DISPLAY.ordinal());
	}

	@Override
	public void Init(int i, int j) {
		m_dispIf.Init(i, j);
	}
	
	@Override
	public void ClearDispBuf()
	{
		m_dispIf.ClearDispBuf();
	}
	
	private char GetColor(SnakeNodeStatus s)
	{
		char color;
		
		switch(s)
		{
			case SNAKE_HEAD:
			{
				color = 2;
				break;
			}
			
			case SNAKE_BODY:
			{
				color = 1;
				break;
			}
			case SNAKE_BARRIER:
			{
				color = 1;
				break;
			}
			case SNAKE_FOOD:
			{
				color = 3;
				break;
			}
			default:
			{
				color = 0;
				break;
			}
		}
		
		return color;
	}

	@Override
	public void setGameOver(boolean isGameOver) {
		// TODO Auto-generated method stub
		m_dispIf.setGameOver(isGameOver);
		m_msgHandler.sendEmptyMessage(MsgTypes.UPDATE_DISPLAY.ordinal());
	}
	

}
