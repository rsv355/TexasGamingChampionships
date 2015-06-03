package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SocialMediaActivity extends Activity {

    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	ImageView ivFacebook;
	ImageView ivGooglePlus;
	ImageView ivLinkedIn;
	ImageView ivTwitter;
	ImageView ivInstagram;
	ImageView ivYoutube;
	ImageView ivNotifications;
	TextView tvFacebook;
	TextView tvGooglePlus;
	TextView tvLinkedIn;
	TextView tvTwitter;
	TextView tvInstagram;
	TextView tvYoutube;
	TextView tvNotifications;
	
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
		
		setContentView(R.layout.activity_social_media);
		
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------
		ivFacebook = (ImageView) findViewById(R.id.ivFacebook);
		ivGooglePlus = (ImageView) findViewById(R.id.ivGooglePlus);
		ivLinkedIn = (ImageView) findViewById(R.id.ivLinkedIn);
		ivTwitter = (ImageView) findViewById(R.id.ivTwitter);
		ivInstagram = (ImageView) findViewById(R.id.ivInstagram);
		ivYoutube = (ImageView) findViewById(R.id.ivYoutube);
		ivNotifications = (ImageView) findViewById(R.id.ivNotifications);
		tvFacebook = (TextView) findViewById(R.id.tvFacebook);
		tvGooglePlus = (TextView) findViewById(R.id.tvGooglePlus);
		tvLinkedIn = (TextView) findViewById(R.id.tvLinkedin);
		tvTwitter = (TextView) findViewById(R.id.tvTwitter);
		tvInstagram = (TextView) findViewById(R.id.tvInstagram);
		tvYoutube = (TextView) findViewById(R.id.tvYoutube);
		tvNotifications = (TextView) findViewById(R.id.tvNotifications);
		
		ivFacebook.setOnClickListener(eClick);
		ivGooglePlus.setOnClickListener(eClick);
		ivLinkedIn.setOnClickListener(eClick);
		ivTwitter.setOnClickListener(eClick);
		ivInstagram.setOnClickListener(eClick);
		ivYoutube.setOnClickListener(eClick);
		ivNotifications.setOnClickListener(eClick);
		tvFacebook.setOnClickListener(eClick);
		tvGooglePlus.setOnClickListener(eClick);
		tvLinkedIn.setOnClickListener(eClick);
		tvTwitter.setOnClickListener(eClick);
		tvInstagram.setOnClickListener(eClick);
		tvYoutube.setOnClickListener(eClick);
		tvNotifications.setOnClickListener(eClick);
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
				case R.id.ivFacebook:
				case R.id.tvFacebook:
					Global.mShowLinkInWebView(Global.SOCIAL_FACEBOOK);
					break;
					
				//----------
				case R.id.ivGooglePlus:
				case R.id.tvGooglePlus:
					Global.mShowLinkInWebView(Global.SOCIAL_GOOGLE_PLUS);
					break;
					
				//----------
				case R.id.ivLinkedIn:
				case R.id.tvLinkedin:
					Global.mShowLinkInWebView(Global.SOCIAL_LINKEDIN);
					break;
					
				//----------
				case R.id.ivTwitter:
				case R.id.tvTwitter:
					Global.mShowLinkInWebView(Global.SOCIAL_TWITTER);
					break;
					
				//----------
				case R.id.ivInstagram:
				case R.id.tvInstagram:
					Global.mShowLinkInWebView(Global.SOCIAL_INSTAGRAM);
					break;
					
				//----------
				case R.id.ivYoutube:
				case R.id.tvYoutube:
					Global.mShowLinkInWebView(Global.SOCIAL_YOUTUBE);
					break;
					
				case R.id.ivNotifications:
				case R.id.tvNotifications:
					startActivity(new Intent(getApplicationContext(), NotificationListActivity.class));
					break;	
			}
		}
	};	
}
