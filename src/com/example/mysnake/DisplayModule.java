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
	
	private int m_blockLen;
	private int m_rightBorder;
	private int m_row;
	private int m_col;
	
	public DisplayModule(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		m_paint = new Paint();
	}
	
	public void InitDispBuffer(int i, int j)
	{
		m_row = j;
		m_col = i;
		m_dispBuf = new char[i][j];
		m_blockLen = this.getHeight() / j;
		m_rightBorder = this.getWidth() - m_blockLen * i;
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
		
		for (i = 0; i < m_col; ++i) {
			for (j = 0; j < m_row; ++j) {
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
		canvas.drawLine(m_rightBorder, 0, m_rightBorder, this.getHeight(), m_paint);
		canvas.drawLine(m_rightBorder, this.getHeight(), 0, this.getHeight(), m_paint);
		canvas.drawLine(0, this.getHeight(), 0, 0, m_paint);
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		DrawBorder(canvas);
		DrawBlocks(m_dispBuf, canvas);
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

}
