package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model;//
//  ModelNotificationDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 30, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelNotificationDatum{

	@SerializedName("body")
	private String body;
	@SerializedName("id")
	private int id;
	@SerializedName("title")
	private String title;

	public void setBody(String body){
		this.body = body;
	}
	public String getBody(){
		return this.body;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}

	public ModelNotificationDatum() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelNotificationDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		body = (String) jsonObject.opt("body");
		title = (String) jsonObject.opt("title");
		id = jsonObject.optInt("id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("body", body);
			jsonObject.put("id", id);
			jsonObject.put("title", title);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}