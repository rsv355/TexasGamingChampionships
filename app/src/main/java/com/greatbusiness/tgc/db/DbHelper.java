package com.greatbusiness.tgc.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.airbrushking.services.model.PushMessage;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
	
	static final String TAG = "DbHelper";
	static final String DB_NAME = "airbrushkingservices_db";
	static final int DB_VERSION = 1;
	//public static DbHelper self;
	
	public DbHelper(Context ctx) {
		super(ctx, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
			
	    db.execSQL("CREATE TABLE IF NOT EXISTS push_messages("
	    		+ "object_id TEXT PRIMARY KEY,"
	    		+ "message TEXT,"
	    		+ "created_at LONG"
	    		+ ");"); 
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS push_messages");
	}
	
	
	public void insertPushMessage(PushMessage entry) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("object_id", entry.getObjectId());
		values.put("message", entry.getMessage());
		values.put("created_at", entry.getCreatedAt());
		
		db.insert("push_messages", null, values);
		db.close();
	}
	
	public void deletePushMessage(String objId) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete("push_messages", "OBJECT_ID = ?", new String[]{objId});
		db.close();
	}
	
	public ArrayList<PushMessage> getPushMessages() {
		ArrayList<PushMessage> list = new ArrayList<PushMessage>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor mCursor = db.rawQuery("SELECT * FROM push_messages ORDER BY created_at DESC", null);
		mCursor.moveToFirst();
		
		if (!mCursor.isAfterLast()) {
			do {
				PushMessage entry = new PushMessage();
				entry.setObjectId(mCursor.getString(mCursor.getColumnIndex("object_id")));
				entry.setMessage(mCursor.getString(mCursor.getColumnIndex("message")));
				entry.setCreatedAt(mCursor.getLong(mCursor.getColumnIndex("created_at")));
				list.add(entry);
			} while (mCursor.moveToNext());
		}
		mCursor.close();
		db.close();
		return list;
	}
}