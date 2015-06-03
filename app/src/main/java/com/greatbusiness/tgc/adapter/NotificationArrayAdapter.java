package com.greatbusiness.tgc.adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.airbrushking.services.R;
import com.airbrushking.services.db.DbHelper;
import com.airbrushking.services.model.PushMessage;

import java.util.List;


public class NotificationArrayAdapter extends ArrayAdapter<PushMessage> {
    
	private ListView pushMessagesListView;
	
    public NotificationArrayAdapter(Context context,
                              int textViewResourceId, 
                              List<PushMessage> objects,
                              ListView gateListView) {
        super(context, textViewResourceId, objects);
        this.pushMessagesListView = gateListView;
    }

    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
       
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.activity_notification_row, null);
        }
        
        ViewHolder holder = (ViewHolder) v.getTag(R.id.id_holder);       
        
        if (holder == null) {
            holder = new ViewHolder(v);
            v.setTag(R.id.id_holder, holder);
        }        
        
        PushMessage entry = getItem(position); 
        holder.message.setText(entry.getMessage());
       
//        Drawable imageOpen;
//        Drawable imageClose;
//        if(entry.isOpen()) {
//        	imageOpen = this.getContext().getResources().getDrawable(R.drawable.open);
//        	imageClose = this.getContext().getResources().getDrawable(R.drawable.close_grey);
//        }	
//        else {
//        	imageOpen = this.getContext().getResources().getDrawable(R.drawable.open_grey);
//        	imageClose = this.getContext().getResources().getDrawable(R.drawable.close);
//        }	
        	
       // holder.date.setText("  " + entry.getNumComments());
        //holder.imgOpen.setBackgroundDrawable(imageOpen);
        //holder.imgClose.setBackgroundDrawable(imageClose);
//        
//        java.text.DateFormat format = DateFormat.getDateFormat(this.getContext());
//        holder.lastTapped.setText(format.format(entry.getUpdateAt()));
		CharSequence createdAt = DateUtils.getRelativeDateTimeString(
                this.getContext(), entry.getCreatedAt(),
                DateUtils.HOUR_IN_MILLIS, DateUtils.WEEK_IN_MILLIS,
                DateUtils.FORMAT_NUMERIC_DATE);
       
        holder.date.setText(createdAt);
        holder.imgDel.setOnClickListener(new DeleteClickListener(entry));
        //        if(lastTappList == null)
//        	lastTappList = new LastTappedTask(entry, getContext(), this);
//        
//        holder.imgOpen.setOnClickListener(lastTappList);
//        holder.imgClose.setOnClickListener(lastTappList);
			
        return v;
    }
    
    
    private class ViewHolder {
        TextView message;
        TextView date;
        ListButton imgDel;
        
        public ViewHolder(View v) {
            message = (TextView) v.findViewById(R.id.tv_title);
            imgDel = (ListButton) v.findViewById(R.id.img_delete);
            date = (TextView) v.findViewById(R.id.tv_date);
            
            v.setTag(this);
        }
    }
    
    class DeleteClickListener implements View.OnClickListener {

    	private PushMessage msg;
    	public DeleteClickListener(PushMessage msg){
    		this.msg = msg;
    	}
    	
		@Override
		public void onClick(View v) {
			new DbHelper(getContext()).deletePushMessage(msg.getObjectId());
			remove(msg);
			notifyDataSetChanged();
		}
    	
    }
}
