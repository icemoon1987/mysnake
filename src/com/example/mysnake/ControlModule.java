package com.example.mysnake;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ControlModule implements OnClickListener {

	Activity m_activity;
	
	Button m_buttonUp; 
	Button m_buttonDown; 
	Button m_buttonLeft; 
	Button m_buttonRight;
	
	GameCoreInterface m_coreIf;
	
	public ControlModule(Activity activity, GameCoreInterface coreIf)
	{
		m_activity = activity;
		m_buttonUp = (Button)m_activity.findViewById(R.id.ButtonUp);
		m_buttonDown = (Button)m_activity.findViewById(R.id.ButtonDown);
		m_buttonLeft = (Button)m_activity.findViewById(R.id.ButtonLeft);
		m_buttonRight = (Button)m_activity.findViewById(R.id.ButtonRight);
		
		m_buttonUp.setOnClickListener(this);
		m_buttonDown.setOnClickListener(this);
		m_buttonLeft.setOnClickListener(this);
		m_buttonRight.setOnClickListener(this);
		
		m_coreIf = coreIf;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v == m_buttonUp)
		{
			m_coreIf.OnKeyDown(SnakeCmd.CMD_UP);
		}
		else if(v == m_buttonDown)
		{
			m_coreIf.OnKeyDown(SnakeCmd.CMD_DOWN);
		}
		else if(v == m_buttonLeft)
		{
			m_coreIf.OnKeyDown(SnakeCmd.CMD_LEFT);
		}
		else if(v == m_buttonRight)
		{
			m_coreIf.OnKeyDown(SnakeCmd.CMD_RIGHT);
		}
		else
		{
			
		}
	}

}
