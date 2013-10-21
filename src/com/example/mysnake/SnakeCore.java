package com.example.mysnake;

import java.util.ArrayList;
import java.util.Random;


public class SnakeCore implements GameCoreInterface {

	SnakeDisplayAdapter m_dispAd;
	int m_iMax;
	int m_jMax;
	
	ArrayList<SnakeNode> m_nodeList;
	
	public SnakeCore(SnakeDisplayAdapter dispAd, int i, int j)
	{
		m_dispAd = dispAd;
		m_iMax = i;
		m_jMax = j;
		
		m_nodeList = new ArrayList<SnakeNode>();
	}
		
	@Override
	public void OnKeyDown(SnakeCmd cmd) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void run()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m_dispAd.Init(m_iMax, m_jMax);
		m_dispAd.UpdateDisplay();
		
	}

	
	private void RandomGenerateFood()
	{
		Random rand = new Random();
		
		int i = rand.nextInt()%m_iMax;
		int j = rand.nextInt()%m_jMax;
		
		
		
		
	}
	
	private void GameStart()
	{

		
		
		
		return;
	}

}

