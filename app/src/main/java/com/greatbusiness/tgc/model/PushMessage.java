package com.greatbusiness.tgc.model;


import com.parse.ParseObject;

public class PushMessage {

	private String objectId;
	private String message;
	private Long createdAt;
	
	public PushMessage(){}
	
	public PushMessage(ParseObject obj){
		this.objectId = obj.getObjectId();
		this.message = obj.getString("message");
		this.createdAt = obj.getCreatedAt().getTime();
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		
		if(o instanceof PushMessage){
			PushMessage pMsg = (PushMessage) o;
			if(pMsg.getObjectId().equals(this.objectId))
				return true;
		}
		
		return false;
			
	}
	
	
	
	
}
