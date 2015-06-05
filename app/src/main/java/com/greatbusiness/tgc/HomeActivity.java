package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class HomeActivity extends Activity {
	

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




		/*final Animation animation = new AlphaAnimation(1, 0);
		animation.setDuration(1000);
		animation.setInterpolator(new LinearInterpolator());
		animation.setRepeatCount(Animation.INFINITE);
		animation.setRepeatMode(Animation.REVERSE);
		ivButton05.startAnimation(animation);
		ivButton08.startAnimation(animation);



		Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
		ivButton00.startAnimation(fadeInAnimation);*/
	}
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	View.OnClickListener eClick = new View.OnClickListener() {
		public void onClick(View v) {
			Global.WEBVIEW_OPEN_FROM_THIS_TAB = Global.tabHost.getCurrentTab();
			
			/*switch (v.getId())
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
			}*/
		}
	};
}