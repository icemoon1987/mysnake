package com.example.mysnake;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;


/**
* This class is the main Activity of this game.
* <p>
* This activity includes the Display Module and the Control Module with fore keys. 
*/
public class MainActivity extends Activity {

	GameCoreInterface m_gameCore;
	DisplayInterface m_dispIf;
	ControlModule m_ctrlModule;
	
	Handler m_msgHandler;

    @Override
	/**
	* The initialization function for the game.
	* <p>
	* This function will be called after the activity is created. It inits the SnakeCore module,  the ControlModule module and the DisplayModule module.
	* 
	* @param savedInstanceState The saved instance state when changing states.
	* @return void
	*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		/*	This handler receives two messages from SankeCore module.
		*	UPDATE_DISPLAY: update game display according to display buffer.
		*	GAME_OVER: display GAME OVER message */
        m_msgHandler = new Handler() {
        	
        	@Override
        	public void handleMessage(Message msg)
        	{
        		if(msg.what == MsgTypes.UPDATE_DISPLAY.ordinal())
        		{
        			m_dispIf.UpdateDisplay();
        		}
        		else if(msg.what == MsgTypes.GAME_OVER.ordinal())
        		{
        			m_dispIf.setGameOver(true);
        		}
        		
        	}
        };

		/* Get the reference of the DisplayModule */
        m_dispIf = (DisplayInterface)this.findViewById(R.id.DisplayModule);
		
		/* Create the SnakeCore with 30x20 blocks, the SnakeCore needs a display adapter for updating the display buffer of DisplayModule */
        m_gameCore = new SnakeCore(new SnakeDisplayAdapter(m_dispIf, m_msgHandler), 30, 20);
        
		/* Create the ControlModule. ControlModule needs the reference of this Activity for buttons and the reference of a GameCoreInterface*/
		m_ctrlModule = new ControlModule(this, m_gameCore);

		/* Start a new thread for the core logic */
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
