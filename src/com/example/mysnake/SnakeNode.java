package com.example.mysnake;


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
	
	
	public boolean equ(SnakeNode dst)
	{
		if((dst.i == this.i) && (dst.j == this.j))
		{
			return true;
		}
		
		return false;
	}
}
