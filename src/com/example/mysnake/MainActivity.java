package com.example.mysnake;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	SnakeCore m_snakeCore;
	DisplayModule m_dispModule;
	ControlModule m_ctrlModule;
	
	MessageHandler 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m_dispModule = (DisplayModule)this.findViewById(R.id.DisplayModule);
        m_snakeCore = new SnakeCore(m_dispModule);
        m_ctrlModule = new ControlModule(this, m_snakeCore);
        
        new Thread() 
        {
        	@Override
        	public void run()
        	{
                m_dispModule.InitDispBuffer(35, 20);
                char[][] p = m_dispModule.GetDispBuf();
                
                
                for(int i = 0 ; i < 20 ; ++i)
                {
                	for(int j = 0 ; j < 20 ; ++j)
                	{
                		p[i][j] = 0;
                	}
                }
                
                p[1][1] = 1;
                p[2][2] = 2;
                p[3][3] = 3;
                p[15][10] = 1;
                p[19][19] = 2;
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

class MessageHandler extends Handler
{
	
}

