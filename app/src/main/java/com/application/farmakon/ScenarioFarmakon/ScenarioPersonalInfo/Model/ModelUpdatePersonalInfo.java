package com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model;//
//  ModelUpdatePersonalInfo.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on June 3, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelUpdatePersonalInfo{

	@SerializedName("status")
	private int status;
	@SerializedName("userInfo")
	private ModelUpdatePersonalUserInfo userInfo;

	public void setStatus(int status){
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}
	public void setUserInfo(ModelUpdatePersonalUserInfo userInfo){
		this.userInfo = userInfo;
	}
	public ModelUpdatePersonalUserInfo getUserInfo(){
		return this.userInfo;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelUpdatePersonalInfo(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		status = jsonObject.optInt("status");
		userInfo = new ModelUpdatePersonalUserInfo(jsonObject.optJSONObject("userInfo"));
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("status", status);
			jsonObject.put("userInfo", userInfo.toJsonObject());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}