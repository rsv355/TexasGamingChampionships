package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TabHost;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Global {

    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
	public static TabHost tabHost = null;
	
	public static String OPEN_THIS_LINK = "";
	
	public static int WEBVIEW_OPEN_FROM_THIS_TAB = -1;
	
	public static final String CUSTOM_AIRBRUSH = "http://airbrushking.net/services/airbrush";
	public static final String GRAPHIC_DESIGN = "http://airbrushking.net/services/graphics";
	public static final String WEBSITE_DESIGN = "http://airbrushking.net/services/websites";
	public static final String PHOTOGRAPHY = "http://airbrushking.net/services/photography";

	public static final String NEW_CLIENT_ACCOUNT = "http://airbrushking.net/shop/index.php?dispatch=profiles.add";
	public static final String PHONE_NUMBER = "281-725-6821";
	public static final String EMAIL_US = "http://www.airbrushking.net/contact";
	public static final String EMAIL = "airbrushkingservices@gmail.com";
	public static final String WEBSITE_SERVICES = "http://airbrushking.net/services";
	public static final String WEBSITE = "http://airbrushking.net";


	public static final String WEBSITE_TICKET = "http://airbrushking.net/tournaments/events";
	public static final String WEBSITE_SHOPPING = "http://www.tgcstore.club";
	public static final String WEBSITE_S = "http://airbrushking.net/tournaments/sponsors";



	public static final String SHARE_SHOP = "http://www.airbrushking.net/shop";
	public static final String SHARE_GALLERY = "http://www.airbrushking.net/gallery";
	public static final String SHARE_SERVICES = "http://www.airbrushking.net/services";
	public static final String SHARE_SPECIALS = "http://www.airbrushking.net/specials";
	public static final String SHARE_PRESS = "http://www.airbrushking.net/press";
	public static final String SHARE_EVENTS = "http://www.airbrushking.net/events";
	public static final String SHARE_CONSULTING = "http://www.airbrushkingconsulting.com";
	public static final String SHARE_TESTIMONIALS = "http://www.airbrushking.net/testimonials";
	public static final String SHARE_PROMO_TEAM = "http://www.airbrushking.net/promoteam";
	public static final String SHARE_BUSINESS = "http://www.airbrushkingbusiness.com";
	public static final String SHARE_MODELS = "http://www.airbrushking.net/models";
	public static final String SHARE_PACKAGES = "http://www.airbrushking.net/services/packages";
	public static final String SHARE_CUSTOM_APPS="http://airbrushking.net/services/customapps";
	public static final String SHARE_VIDEOS="http://airbrushking.net/services/videos";
	public static final String SHARE_WEDDINGS="http://airbrushking.net/services/weddings";
	
	
	public static final String SOCIAL_FACEBOOK = "https://www.facebook.com/airbrushking";
	public static final String SOCIAL_GOOGLE_PLUS = "https://plus.google.com/+AirbrushKing";
	public static final String SOCIAL_LINKEDIN = "http://www.linkedin.com/in/airbrushking";
	public static final String SOCIAL_TWITTER = "https://twitter.com/airbrushking";
	public static final String SOCIAL_INSTAGRAM = "http://instagram.com/airbrushking";
	public static final String SOCIAL_YOUTUBE = "https://www.youtube.com/AirbrushKingServices";
	
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    static void mDialPhoneNumber(Activity activity)
    { 
    	String sPhoneNumber = Global.PHONE_NUMBER;
    	sPhoneNumber = sPhoneNumber.replaceAll("[^0-9]+", "");
    	
		try 
		{
			sPhoneNumber = URLEncoder.encode(sPhoneNumber, "UTF-8");
			
			Intent iLlamar = new Intent(Intent.ACTION_CALL);
			iLlamar.setData(Uri.parse("tel:" + URLEncoder.encode(sPhoneNumber, "UTF-8")));
			activity.startActivity(iLlamar);
		} 
		catch (UnsupportedEncodingException e)
		{
			//...
		}
    }
    
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    static void mEmailUs(Activity activity)
    {
		Intent iEmail = new Intent(Intent.ACTION_SEND);

		iEmail.setType("plain/text");
		iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{Global.EMAIL});
		//iEmail.putExtra(Intent.EXTRA_SUBJECT, "");
		//iEmail.putExtra(Intent.EXTRA_TEXT, "");

		activity.startActivity(Intent.createChooser(iEmail, ""));
    }
    
    //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    static void mShowLinkInWebView(String sLink)
    {
    	OPEN_THIS_LINK = sLink;
    	tabHost.setCurrentTab(5);
    	//tabHost.invalidate();
    	tabHost.getCurrentView().setVisibility(View.VISIBLE);
    }
}