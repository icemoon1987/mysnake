package com.example.mysnake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class DisplayModule extends View implements DisplayInterface {

	Canvas m_canvas;
	Paint m_paint;
	
	public DisplayModule(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		m_canvas = new Canvas();
		m_paint = new Paint();
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
		canvas.drawColor(Color.BLACK);
		
		m_paint.setColor(Color.RED);
		
		canvas.drawRect(10,  10, 110, 110, m_paint);
		
	}
	
	@Override
	public char[] GetDispBuf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SetDispBuf(char[] disp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateDisplay() 
	{
		// TODO Auto-generated method stub
		//this.draw(m_canvas);

	}

}
