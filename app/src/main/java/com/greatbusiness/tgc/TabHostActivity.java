package com.greatbusiness.tgc;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class TabHostActivity extends TabActivity {
	
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
		
		setContentView(R.layout.activity_tab_host);

	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------	
		//Show the splash screen
		Intent iSplashScreen = new Intent(this, SplashScreenActivity.class);
    	startActivity(iSplashScreen);
		
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------
		Global.tabHost = getTabHost();
		
		//Add phone tab
		String sPhone = getString(R.string.th_tab_1);
		Global.tabHost.addTab(Global.tabHost.newTabSpec(sPhone).setContent(new Intent(this, HomeActivity.class)).setIndicator(mPrepareCustomTabView(R.drawable.img_tab_1_selector)));
		//Add email tab
		String sEmail = getString(R.string.th_tab_2);
		Global.tabHost.addTab(Global.tabHost.newTabSpec(sEmail).setContent(new Intent(this, HomeActivity.class)).setIndicator(mPrepareCustomTabView(R.drawable.img_tab_2_selector)));
		//Add home tab
		String sHome = getString(R.string.th_tab_3);
		Global.tabHost.addTab(Global.tabHost.newTabSpec(sHome).setContent(new Intent(this, HomeActivity.class)).setIndicator(mPrepareCustomTabView(R.drawable.img_tab_3_selector)));
		//Add share tab
		String sShare = getString(R.string.th_tab_4);
		Global.tabHost.addTab(Global.tabHost.newTabSpec(sShare).setContent(new Intent(this, ShareActivity.class)).setIndicator(mPrepareCustomTabView(R.drawable.img_tab_4_selector)));
		//Add social tab		
		String sSocial = getString(R.string.th_tab_5);
		Global.tabHost.addTab(Global.tabHost.newTabSpec(sSocial).setContent(new Intent(this, SocialMediaActivity.class)).setIndicator(mPrepareCustomTabView(R.drawable.img_tab_5_selector)));
		//Add web view tab 	
		String sWebView = getString(R.string.th_tab_6);
		Global.tabHost.addTab(Global.tabHost.newTabSpec(sWebView).setContent(new Intent(this, WebViewActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).setIndicator(mPrepareCustomTabView(R.drawable.img_tab_5_selector)));
	
		//Hide the tabs dividers
		Global.tabHost.getTabWidget().setDividerDrawable(null);
	
		//Set the default tab
		Global.tabHost.setCurrentTab(2);
		
		//Set tabs color (first time)
		mSetBackgroundColor(Global.tabHost);
		
		//Set view tags
		Global.tabHost.getTabWidget().getChildAt(0).setTag(getString(R.string.th_tab_1));
		Global.tabHost.getTabWidget().getChildAt(1).setTag(getString(R.string.th_tab_2));
		Global.tabHost.getTabWidget().getChildAt(2).setTag(getString(R.string.th_tab_3));
		Global.tabHost.getTabWidget().getChildAt(3).setTag(getString(R.string.th_tab_4));
		Global.tabHost.getTabWidget().getChildAt(4).setTag(getString(R.string.th_tab_5));
		Global.tabHost.getTabWidget().getChildAt(5).setTag(getString(R.string.th_tab_6));
		
		//Hide the web view tab
		Global.tabHost.getTabWidget().getChildAt(5).setVisibility(View.GONE);
		
		//Set the default tab
		Global.tabHost.setCurrentTab(2);
		
		//Set tabs color (first time)
		mSetBackgroundColor(Global.tabHost);
		
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------		
		Global.tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
	        public void onTabChanged(String arg0) {
				//Set tab colors (when click in some tab)
				mSetBackgroundColor(Global.tabHost);
	        }
	    });
		
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------
		for (int i = 0; i < Global.tabHost.getTabWidget().getTabCount(); i++) 
		{
			Global.tabHost.getTabWidget().getChildAt(i).setOnTouchListener(new OnTouchListener() {
				@Override
	            public boolean onTouch(View v, MotionEvent event) {
	                int action = event.getAction();
	                
	                if (action == MotionEvent.ACTION_UP)
	                {
	            		String sCurrentTabTag = (String) Global.tabHost.getCurrentTabTag();
	            		String sClickedTabTag = (String) v.getTag();
	            		
	            		if (sClickedTabTag.equals(getString(R.string.th_tab_1))) 
	            		{
							Global.mShowLinkInWebView(Global.WEBSITE_TICKET);
	            			return true; //doesn't allow tab change
	            		}
	            		
	            		if (sClickedTabTag.equals(getString(R.string.th_tab_2))) 
	            		{
							Global.mShowLinkInWebView(Global.WEBSITE_SHOPPING);
	            			return true; //doesn't allow tab change
	            		}
	            		
	            		if (sClickedTabTag.equals(getString(R.string.th_tab_3))) 
	            		{
	            			//Not handled
	            		}
	            		
	            		if (sClickedTabTag.equals(getString(R.string.th_tab_4))) 
	            		{
							Global.mShowLinkInWebView(Global.WEBSITE_S);
	            			//Not handled
	            		}
	            		
	            		if (sClickedTabTag.equals(getString(R.string.th_tab_5))) 
	            		{
	            			//Not handled
	            		}
	            		
	            		if (sClickedTabTag.equals(getString(R.string.th_tab_6))) 
	            		{
	            			//Not handled
	            		}
	                }
	                
	                return false; //allows tab change
	            }               
	        });
		}
		
		
		
	}
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    private View mPrepareCustomTabView(int iPicture)
    {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_host_item, null);
        ImageView iv = (ImageView) view.findViewById(R.id.thiImage);
        
        iv.setImageResource(iPicture);
        
        return view;
	}
    
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    private void mSetBackgroundColor(TabHost tabHost)
    {
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) 
        {
        	tabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.AirbrushKing));
        }
        
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.AirbrushKing));
	}
    
    
}