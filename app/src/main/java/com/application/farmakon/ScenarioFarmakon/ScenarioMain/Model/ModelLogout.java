package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Model;//
//  ModelLogout.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on March 23, 2020

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;


public class ModelLogout {

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
		return this.message;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelLogout(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		message = String.valueOf(jsonObject.opt("message"));
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("message", message);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}