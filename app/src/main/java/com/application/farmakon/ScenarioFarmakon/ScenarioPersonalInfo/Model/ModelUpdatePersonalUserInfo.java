package com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model;//
//  ModelUpdatePersonalUserInfo.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on June 3, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelUpdatePersonalUserInfo{

	@SerializedName("dob")
	private int dob;
	@SerializedName("email")
	private String email;
	@SerializedName("gender")
	private int gender;
	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name;

	public void setDob(int dob){
		this.dob = dob;
	}
	public int getDob(){
		return this.dob;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setGender(int gender){
		this.gender = gender;
	}
	public int getGender(){
		return this.gender;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelUpdatePersonalUserInfo(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		email = (String) jsonObject.opt("email");
		name = (String) jsonObject.opt("name");
		dob = jsonObject.optInt("dob");
		gender = jsonObject.optInt("gender");
		id = jsonObject.optInt("id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("dob", dob);
			jsonObject.put("email", email);
			jsonObject.put("gender", gender);
			jsonObject.put("id", id);
			jsonObject.put("name", name);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}