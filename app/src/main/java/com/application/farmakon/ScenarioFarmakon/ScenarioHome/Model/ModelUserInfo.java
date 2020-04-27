package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Model;//
//  ModelUserInfo.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 23, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelUserInfo{

	@SerializedName("id")
	private int id;
	@SerializedName("lang")
	private String lang;
	@SerializedName("phone")
	private String phone;

	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setLang(String lang){
		this.lang = lang;
	}
	public String getLang(){
		return this.lang;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelUserInfo(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		lang = (String) jsonObject.opt("lang");
		phone = (String) jsonObject.opt("phone");
		id = jsonObject.optInt("id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("id", id);
			jsonObject.put("lang", lang);
			jsonObject.put("phone", phone);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}