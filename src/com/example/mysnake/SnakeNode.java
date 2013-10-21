package com.example.mysnake;

import android.R.bool;

public class SnakeNode {
	public int i;
	public int j;
	public SnakeNodeStatus s;
	
	public SnakeNode(int in_i, int in_j, SnakeNodeStatus in_s)
	{
		i = in_i;
		j = in_j;
		s = in_s;
	}
	
	
	public boolean SamePosition(SnakeNode dst, SnakeNode src)
	{
		if((dst.i == src.i) && (dst.j == src.j))
		{
			return true;
		}
		
		return false;
	}
}
