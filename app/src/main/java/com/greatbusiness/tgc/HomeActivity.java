package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class HomeActivity extends Activity {
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    ImageView ivButton00;
    ImageView ivButton01;
    ImageView ivButton02;
    ImageView ivButton03;
    ImageView ivButton04;
    ImageView ivButton05;
    ImageView ivButton06;
    ImageView ivButton07;
    ImageView ivButton08;
    
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		setContentView(R.layout.activity_home);		
		
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------	
		ivButton00 = (ImageView) findViewById(R.id.ivButton00);
		ivButton01 = (ImageView) findViewById(R.id.ivButton01);
		ivButton02 = (ImageView) findViewById(R.id.ivButton02);
		ivButton03 = (ImageView) findViewById(R.id.ivButton03);
		ivButton04 = (ImageView) findViewById(R.id.ivButton04);
		ivButton05 = (ImageView) findViewById(R.id.ivButton05);
		ivButton06 = (ImageView) findViewById(R.id.ivButton06);
		ivButton07 = (ImageView) findViewById(R.id.ivButton07);
		ivButton08 = (ImageView) findViewById(R.id.ivButton08);
	    
		ivButton00.setOnClickListener(eClick);
		ivButton01.setOnClickListener(eClick);
		ivButton02.setOnClickListener(eClick);
		ivButton03.setOnClickListener(eClick);
		ivButton04.setOnClickListener(eClick);
		ivButton05.setOnClickListener(eClick);
		ivButton06.setOnClickListener(eClick);
		ivButton07.setOnClickListener(eClick);
		ivButton08.setOnClickListener(eClick);
	}
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	View.OnClickListener eClick = new View.OnClickListener() {
		public void onClick(View v) {
			Global.WEBVIEW_OPEN_FROM_THIS_TAB = Global.tabHost.getCurrentTab();
			
			switch (v.getId())
			{
				//----------
				case R.id.ivButton00:
					Global.mShowLinkInWebView(Global.WEBSITE);
					break;
			
				//----------
				case R.id.ivButton01:
					Global.mShowLinkInWebView(Global.CUSTOM_AIRBRUSH);
					break;
					
				//----------
				case R.id.ivButton02:
					Global.mShowLinkInWebView(Global.GRAPHIC_DESIGN);
					break;
					
				//----------
				case R.id.ivButton03:
					Global.mShowLinkInWebView(Global.PHOTOGRAPHY);
					break;
					
				//----------
				case R.id.ivButton04:
					Global.mShowLinkInWebView(Global.WEBSITE_DESIGN);
					break;
					
				//----------
				case R.id.ivButton05:
					Global.mShowLinkInWebView(Global.NEW_CLIENT_ACCOUNT);
					break;
	
				//----------
				case R.id.ivButton06:
					Global.mDialPhoneNumber(HomeActivity.this);
					break;
					
				//----------
				case R.id.ivButton07:				
					Global.mEmailUs(HomeActivity.this);
					break;						
					
				//----------
				case R.id.ivButton08:
					Global.mShowLinkInWebView(Global.WEBSITE_SERVICES);
					break;
			}
		}
	};
}