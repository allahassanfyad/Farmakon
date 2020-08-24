package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model;//
//  ModelSubDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on July 28, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelSubDatum{

	@SerializedName("id")
	private int id;
	@SerializedName("image")
	private String image;
	@SerializedName("title")
	private String title;

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
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}

	public ModelSubDatum() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelSubDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		image = String.valueOf(jsonObject.opt("image"));
		title = String.valueOf(jsonObject.opt("title"));
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
			jsonObject.put("image", image);
			jsonObject.put("title", title);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}