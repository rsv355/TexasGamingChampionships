package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WebViewActivity extends Activity {
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	WebView wvWeb;
	ProgressBar progressBar;
	TextView tvProgressBar;

    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	boolean bLoadingPageFinished = false;
	boolean bRedirect = false;
	
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
		
		setContentView(R.layout.activity_web_view);

	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------        
	    wvWeb = (WebView) findViewById(R.id.wvWeb);
	    progressBar = (ProgressBar) findViewById(R.id.progressBar);
	    tvProgressBar = (TextView) findViewById(R.id.tvProgressBar);
	    
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------
        //Set the activity title with the url 
        //setTitle(sLink); 
        
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------		    
	    WebSettings ws = wvWeb.getSettings();
	    ws.setBuiltInZoomControls(true);
	    ws.setLoadsImagesAutomatically(true);
	    ws.setJavaScriptEnabled(true);	    
	    ws.setUseWideViewPort(true);
	    ws.setLoadWithOverviewMode(true);
	    
	    wvWeb.setWebViewClient(new myWebClient());	    
	    wvWeb.loadUrl(Global.OPEN_THIS_LINK);
	    
	   
	}
	
	
	
	
	
	//--------------------------------------------------NEW
	
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
            case KeyEvent.KEYCODE_BACK:
                if(wvWeb.canGoBack()){
                    wvWeb.goBack();
                }else{
                    
                    onBackPressed();
                }
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

	
	//-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------

	
	@Override
	public void onBackPressed() {
		//Global.tabHost.setCurrentTab(Global.WEBVIEW_OPEN_FROM_THIS_TAB);
		Intent i = new Intent(WebViewActivity.this,TabHostActivity2.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		finish();
	}	
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	public class myWebClient extends WebViewClient
	{
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------	 
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			bLoadingPageFinished = false;
			progressBar.setVisibility(View.VISIBLE);//new
			tvProgressBar.setVisibility(View.VISIBLE);//new
			
		}
	    	
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------	 
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (bLoadingPageFinished == false) 
			{
				bRedirect = true;
				progressBar.setVisibility(View.VISIBLE);//new
				tvProgressBar.setVisibility(View.VISIBLE);//new
			}

			bLoadingPageFinished = false;
			
			view.loadUrl(url);	
			
			return true;
		}
	    	
	    //-------------------------------------------------------------------
	    //
	    //-------------------------------------------------------------------	 
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			
			if (bRedirect == false)
			{
				bLoadingPageFinished = true;
			}

			if (bLoadingPageFinished == true && bRedirect == false)
			{
				progressBar.setVisibility(View.GONE);
				tvProgressBar.setVisibility(View.GONE);
			} 
			else
			{
				bRedirect = false;
				progressBar.setVisibility(View.VISIBLE);//new
				tvProgressBar.setVisibility(View.VISIBLE);//new
			}
		}	
	}
}
