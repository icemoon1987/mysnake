package com.example.mysnake;

import java.util.ArrayList;

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
		
		m_nodeList.add(new SnakeNode(1, 1, SnakeNodeStatus.SNAKE_HEAD));
		m_nodeList.add(new SnakeNode(2, 2, SnakeNodeStatus.SNAKE_BODY));
		m_nodeList.add(new SnakeNode(3, 3, SnakeNodeStatus.SNAKE_FOOD));
		m_nodeList.add(new SnakeNode(4, 4, SnakeNodeStatus.SNAKE_BARRIER));
		
		m_dispAd.FillDispBuf(m_nodeList);
		m_dispAd.UpdateDisplay();

	}

}

