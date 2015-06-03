package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends Activity {

    //------------------------------------------------------------------
    //
    //------------------------------------------------------------------
    final int SPLASH_SCREEN_DURATION = 2000; //Milliseconds

    //------------------------------------------------------------------
    //
    //------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		setContentView(R.layout.activity_splash_screen);        
        
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------
        new Handler().postDelayed(new Runnable(){
            public void run(){       	
        	finish();
            };
        }, SPLASH_SCREEN_DURATION);           
	}
	
	//-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	@Override
	public void onBackPressed() {
	    //...
	}
}
