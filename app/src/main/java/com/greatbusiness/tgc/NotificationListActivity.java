package com.greatbusiness.tgc;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.airbrushking.services.adapter.NotificationArrayAdapter;
import com.airbrushking.services.db.DbHelper;
import com.airbrushking.services.model.PushMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class NotificationListActivity extends Activity implements OnItemClickListener {

    private ListView notificationListView;
    //private ProgressBar loader;
    private ArrayList<PushMessage> mEntries = new ArrayList<PushMessage>();
    private NotificationArrayAdapter mAdapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_notification_list);
 
        loadMessages();
        notificationListView = (ListView) findViewById(android.R.id.list);
        //loader = (ProgressBar) findViewById(R.id.progressBar);
        
        mAdapter = new NotificationArrayAdapter(this, 0, mEntries, notificationListView);
        notificationListView.setAdapter(mAdapter);
        notificationListView.setOnItemClickListener(this);
        
        TextView empty = (TextView) findViewById(android.R.id.empty);
        notificationListView.setEmptyView(empty);
        
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadMessages();
    }


    private void loadMessages() {
        mEntries = new DbHelper(this).getPushMessages();
        //mAdapter.notifyDataSetChanged();
    }


    
    @Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		PushMessage item = mEntries.get(position);
		JSONObject json = new JSONObject();
		try {
			json.put("alert", item.getMessage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Intent intent = new Intent(getApplicationContext(), ReceivedPushMessageActivity.class);
		//Bundle bd = new Bundle();
		//bd.putString("com.parse.Data", json.toString());
		intent.putExtra("com.parse.Data", json.toString());
		intent.putExtra(ReceivedPushMessageActivity.KEY_UPDATE_LIST, false);
		startActivity(intent);
	}
    
 
}
