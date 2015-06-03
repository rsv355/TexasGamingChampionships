package com.greatbusiness.tgc;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

public class AirbrushkingApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

	
		Parse.initialize(this, "wthdi0lp1kES4PHf6c8KNKFZmefUG8Z5bc4FM0e4", "neQG8ZckNOg63gExgEPIXe29THo2DqlMeZaUReL6");
	    ParseUser.enableAutomaticUser();	
		
		// Save the current Installation to Parse.
	    PushService.setDefaultPushCallback(this, ReceivedPushMessageActivity.class);
		ParseInstallation.getCurrentInstallation().saveInBackground();
			
		// Subscribe to gate services
		//PushService.subscribe(this.getBaseContext(), "GatesUpdates", HomeActivity.class);

		//ParseACL defaultACL = new ParseACL();
		// If you would like all objects to be private by default, remove this
		// line.
		//defaultACL.setPublicReadAccess(true);
		//ParseACL.setDefaultACL(defaultACL, true);
	}

}
