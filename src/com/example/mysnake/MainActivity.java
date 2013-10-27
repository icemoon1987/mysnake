package com.example.mysnake;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

public class MainActivity extends Activity {

	GameCoreInterface m_gameCore;
	DisplayInterface m_dispIf;
	ControlModule m_ctrlModule;
	
	Handler m_msgHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m_msgHandler = new Handler() {
        	
        	@Override
        	public void handleMessage(Message msg)
        	{
        		if(msg.what == MsgTypes.UPDATE_DISPLAY.ordinal())
        		{
        			m_dispIf.UpdateDisplay();
        		}
        		
        	}
        };

        m_dispIf = (DisplayInterface)this.findViewById(R.id.DisplayModule);
        m_gameCore = new SnakeCore(new SnakeDisplayAdapter(m_dispIf, m_msgHandler), 30, 20);
        m_ctrlModule = new ControlModule(this, m_gameCore);

        new Thread() 
        {
        	@Override
        	public void run()
        	{
        		m_gameCore.run();
        	}
        }.start();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
