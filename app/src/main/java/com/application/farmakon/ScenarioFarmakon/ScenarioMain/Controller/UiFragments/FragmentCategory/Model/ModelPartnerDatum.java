package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model;//
//  ModelPartnerDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on July 28, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelPartnerDatum{

	@SerializedName("id")
	private int id;
	@SerializedName("image")
	private String image;
	@SerializedName("title")
	private Object title;

	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return this.image;
	}
	public void setTitle(Object title){
		this.title = title;
	}
	public Object getTitle(){
		return this.title;
	}

	public ModelPartnerDatum() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelPartnerDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		image = (String) jsonObject.opt("image");
		id = jsonObject.optInt("id");
		title = (String) jsonObject.opt("title");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("id", id);
			jsonObject.put("image", image);
			jsonObject.put("title", title);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}