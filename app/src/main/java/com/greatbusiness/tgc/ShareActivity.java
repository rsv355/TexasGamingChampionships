package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareActivity extends Activity {

    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	Button btShare;
	TextView tvLink1;
	TextView tvLink2;
	TextView tvLink3;
	TextView tvLink4;
	TextView tvLink5;
	TextView tvLink6;
	TextView tvLink7;
	TextView tvLink8;
	TextView tvLink9;
	TextView tvLink10;
	TextView tvLink11;
	TextView tvLink12;
	ImageView ivLinkLogo1;
	TextView tvLinkLogo1;
	ImageView ivLinkLogo2;
	TextView tvLinkLogo2;
	ImageView ivLinkLogo3;
	TextView tvLinkLogo3;
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		setContentView(R.layout.activity_share);
		
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------
		btShare = (Button) findViewById(R.id.btShare);
		tvLink1 = (TextView) findViewById(R.id.tvLink1);
		tvLink2 = (TextView) findViewById(R.id.tvLink2);
		tvLink3 = (TextView) findViewById(R.id.tvLink3);
		tvLink4 = (TextView) findViewById(R.id.tvLink4);
		tvLink5 = (TextView) findViewById(R.id.tvLink5);
		tvLink6 = (TextView) findViewById(R.id.tvLink6);
		tvLink7 = (TextView) findViewById(R.id.tvLink7);
		tvLink8 = (TextView) findViewById(R.id.tvLink8);
		tvLink9 = (TextView) findViewById(R.id.tvLink9);
		tvLink10 = (TextView) findViewById(R.id.tvLink10);
		tvLink11 = (TextView) findViewById(R.id.tvLink11);
		tvLink12 = (TextView) findViewById(R.id.tvLink12);
		ivLinkLogo1 = (ImageView) findViewById(R.id.ivLinkLogo1);
		tvLinkLogo1 = (TextView) findViewById(R.id.tvLinkLogo1);
		ivLinkLogo2 = (ImageView) findViewById(R.id.ivLinkLogo2);
		tvLinkLogo2 = (TextView) findViewById(R.id.tvLinkLogo2);
		ivLinkLogo3 = (ImageView) findViewById(R.id.ivLinkLogo3);
		tvLinkLogo3 = (TextView) findViewById(R.id.tvLinkLogo3);
		
		btShare.setOnClickListener(eClick);
		tvLink1.setOnClickListener(eClick);
		tvLink2.setOnClickListener(eClick);
		tvLink3.setOnClickListener(eClick);
		tvLink4.setOnClickListener(eClick);
		tvLink5.setOnClickListener(eClick);
		tvLink6.setOnClickListener(eClick);
		tvLink7.setOnClickListener(eClick);
		tvLink8.setOnClickListener(eClick);
		tvLink9.setOnClickListener(eClick);
		tvLink10.setOnClickListener(eClick);
		tvLink11.setOnClickListener(eClick);
		tvLink12.setOnClickListener(eClick);
		ivLinkLogo1.setOnClickListener(eClick);
		tvLinkLogo1.setOnClickListener(eClick);
		ivLinkLogo2.setOnClickListener(eClick);
		tvLinkLogo2.setOnClickListener(eClick);
		ivLinkLogo3.setOnClickListener(eClick);
		tvLinkLogo3.setOnClickListener(eClick);
		
		
	
		
		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN)
        {
        	
        	
        }
        
        return super.onKeyDown(keyCode, event);
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
				case R.id.btShare:
					String sTitle = getString(R.string.app_name);
					String sMessage = getString(R.string.s_share_message);
					
					Intent iShare = new Intent(Intent.ACTION_SEND);
					iShare.setType("text/plain");
					iShare.putExtra(Intent.EXTRA_SUBJECT, sTitle);
					iShare.putExtra(Intent.EXTRA_TEXT, sMessage);
					startActivity(Intent.createChooser(iShare, getString(R.string.s_button_share)));
					break;
					
				//----------
				case R.id.tvLink1:
					Global.mShowLinkInWebView(Global.SHARE_SHOP);
					break;
					
				//----------
				case R.id.tvLink2:
					Global.mShowLinkInWebView(Global.SHARE_GALLERY);
					break;
					
				//----------
				case R.id.tvLink3:
					Global.mShowLinkInWebView(Global.SHARE_SERVICES);
					break;
					
				//----------
				case R.id.tvLink4:
					Global.mShowLinkInWebView(Global.SHARE_SPECIALS);
					break;
					
				//----------
				case R.id.tvLink5:
					Global.mShowLinkInWebView(Global.SHARE_PRESS);
					break;
					
				//----------
				case R.id.tvLink6:
					Global.mShowLinkInWebView(Global.SHARE_EVENTS);
					break;
					
				//----------
				case R.id.tvLink7:
					Global.mShowLinkInWebView(Global.SHARE_CONSULTING);
					break;

				//----------
				case R.id.tvLink8:
					Global.mShowLinkInWebView(Global.SHARE_TESTIMONIALS);
					break;
					
				//----------
				case R.id.tvLink9:
					Global.mShowLinkInWebView(Global.SHARE_PACKAGES);
					break;	
					
				//----------
					
				case R.id.tvLink10:
					Global.mShowLinkInWebView(Global.SHARE_CUSTOM_APPS);
					break;	
					
				//----------
					
				case R.id.tvLink11:
					Global.mShowLinkInWebView(Global.SHARE_VIDEOS);
					break;	
					
				//----------
					
				case R.id.tvLink12:
					Global.mShowLinkInWebView(Global.SHARE_WEDDINGS);
					break;	
					
				//----------
					
					
				case R.id.ivLinkLogo1:
				case R.id.tvLinkLogo1:
					Global.mShowLinkInWebView(Global.SHARE_PROMO_TEAM);
					break;

				//----------
				case R.id.ivLinkLogo2:
				case R.id.tvLinkLogo2:
					Global.mShowLinkInWebView(Global.SHARE_BUSINESS);
					break;	
					
					//----------
				case R.id.ivLinkLogo3:
				case R.id.tvLinkLogo3:
					Global.mShowLinkInWebView(Global.SHARE_MODELS);
					break;							
			}
		}
	};	
	
	
	
}
