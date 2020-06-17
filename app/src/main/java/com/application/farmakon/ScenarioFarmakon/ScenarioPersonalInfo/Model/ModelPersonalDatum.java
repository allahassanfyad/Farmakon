package com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model;//
//  ModelPersonalDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on June 3, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelPersonalDatum{

	@SerializedName("dob")
	private String dob;
	@SerializedName("email")
	private String email;
	@SerializedName("gender")
	private String gender;
	@SerializedName("id")
	private int id;
	@SerializedName("lang")
	private String lang;
	@SerializedName("name")
	private String name;

	public void setDob(String dob){
		this.dob = dob;
	}
	public String getDob(){
		return this.dob;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return this.gender;
	}
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
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelPersonalDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		dob = (String) jsonObject.opt("dob");
		email = (String) jsonObject.opt("email");
		gender = (String) jsonObject.opt("gender");
		lang = (String) jsonObject.opt("lang");
		name = (String) jsonObject.opt("name");
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
			jsonObject.put("lang", lang);
			jsonObject.put("name", name);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}