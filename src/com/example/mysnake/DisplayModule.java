package com.example.mysnake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


public class DisplayModule extends View implements DisplayInterface {

	Paint m_paint;
	
	char[][] m_dispBuf;
	
	boolean m_gameOver;
	
	private int m_blockLen;
	private int m_rightBorder;
	private int m_bottomBorder;
	private int m_iMax;
	private int m_jMax;
	
	public DisplayModule(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		m_paint = new Paint();
		m_gameOver = false;
	}
	
	public void setGameOver(boolean isGameOver)
	{
		m_gameOver = isGameOver;
	}

	private void DrawGameOver(Canvas canvas)
	{
		m_paint.setColor(Color.RED);
		canvas.drawText("Game Over", 0, 0, m_paint);
	}

	
	private Rect GetRect(int i, int j)
	{
		int x1, x2;
		int y1, y2;
		
		x1 = m_blockLen * i;
		x2 = x1 + m_blockLen;
		
		y1 = m_blockLen * j;
		y2 = y1 + m_blockLen;
		
		Rect r = new Rect(x1, y1, x2, y2);
		
		return r;
	}
	
	private void DrawBlocks(char [][] dispBuf, Canvas canvas)
	{
		int i = 0;
		int j = 0;
		
		for (i = 0; i < m_iMax; ++i) {
			for (j = 0; j < m_jMax; ++j) {
				switch (dispBuf[i][j]) {
				case 0: {
					break;
				}

				case 1: {
					m_paint.setColor(Color.GREEN);
					canvas.drawRect(GetRect(i, j), m_paint);
					break;
				}

				case 2: {
					m_paint.setColor(Color.RED);
					canvas.drawRect(GetRect(i, j), m_paint);
					break;
				}

				case 3: {
					m_paint.setColor(Color.YELLOW);
					canvas.drawRect(GetRect(i, j), m_paint);
				}

				default:
					break;
				}
			}
		}
		
	}
	
	private void DrawBorder(Canvas canvas)
	{
		m_paint.setColor(Color.BLACK);
		canvas.drawLine(0, 0, m_rightBorder, 0, m_paint);
		canvas.drawLine(m_rightBorder, 0, m_rightBorder, m_bottomBorder - 1, m_paint);
		canvas.drawLine(m_rightBorder, m_bottomBorder, 0, m_bottomBorder - 1, m_paint);
		canvas.drawLine(0, m_bottomBorder - 1, 0, 0, m_paint);
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		DrawBorder(canvas);
		DrawBlocks(m_dispBuf, canvas);
		
		if(m_gameOver)
		{
			DrawGameOver(canvas);
		}
	}
	
	@Override
	public char[][] GetDispBuf() {
		// TODO Auto-generated method stub
		return m_dispBuf;
	}


	@Override
	public void UpdateDisplay() 
	{
		// TODO Auto-generated method stub
		this.invalidate();

	}
	
	@Override
	public void Init(int i, int j)
	{
		m_iMax = i;
		m_jMax = j;
		
		if(m_dispBuf == null)
		{
			m_dispBuf = new char[i][j];
		}
		else
		{
			
		}
		
		m_blockLen = this.getHeight() / j;
		m_rightBorder = m_blockLen * i;
		m_bottomBorder = m_blockLen * j;
		
	}

	@Override
	public void ClearDispBuf() {
		for(int i = 0 ; i < m_iMax; ++i)
		{
			for(int j = 0 ; j < m_jMax; ++j)
			{
				m_dispBuf[i][j] = 0;
			}
		}
	}
}
