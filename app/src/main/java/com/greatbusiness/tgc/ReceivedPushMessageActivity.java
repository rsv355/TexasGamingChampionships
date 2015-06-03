package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.greatbusiness.tgc.db.DbHelper;
import com.greatbusiness.tgc.model.PushMessage;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import org.json.JSONException;
import org.json.JSONObject;

public class ReceivedPushMessageActivity extends Activity {

	private TextView pushMessage;
	private String notificationTxt;
	
	public static final String KEY_UPDATE_LIST = "UPDATE_LIST";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_push_notification);
		pushMessage = (TextView) findViewById(R.id.push_message);
		final boolean toUpdateList = getIntent().getBooleanExtra(KEY_UPDATE_LIST, true);
		
		try {
			JSONObject json = new JSONObject(getIntent().getExtras().getString("com.parse.Data"));
			notificationTxt = json.getString("alert");
			
		} catch (JSONException exe) {
			Log.e("AirBrush", "Error during extraction of Json data from push message.");
		}
		
		if(notificationTxt != null){
			pushMessage.setText(notificationTxt.toString());
			pushMessage.setMovementMethod(LinkMovementMethod.getInstance());
		}	
		
		final ParseObject pushOpen = new ParseObject("PushOpen");
		pushOpen.put("message", notificationTxt);
		pushOpen.saveInBackground(new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if(e == null && toUpdateList){
					DbHelper db = new DbHelper(getApplicationContext());
					db.insertPushMessage(new PushMessage(pushOpen));
				}
			}
		});
		
		
	}

}
