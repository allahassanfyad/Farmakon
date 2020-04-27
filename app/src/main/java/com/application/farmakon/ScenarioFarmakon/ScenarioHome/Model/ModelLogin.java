package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Model;//
//  ModelLogin.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 23, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelLogin{

	@SerializedName("token")
	private String token;
	@SerializedName("userInfo")
	private ModelUserInfo userInfo;

	public void setToken(String token){
		this.token = token;
	}
	public String getToken(){
		return this.token;
	}
	public void setUserInfo(ModelUserInfo userInfo){
		this.userInfo = userInfo;
	}
	public ModelUserInfo getUserInfo(){
		return this.userInfo;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelLogin(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		token = (String) jsonObject.opt("token");
		userInfo = new ModelUserInfo(jsonObject.optJSONObject("userInfo"));
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("token", token);
			jsonObject.put("userInfo", userInfo.toJsonObject());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}