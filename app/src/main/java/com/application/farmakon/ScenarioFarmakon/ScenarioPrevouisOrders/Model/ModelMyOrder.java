package com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model;//
//  ModelMyOrder.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 29, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelMyOrder{

	@SerializedName("code")
	private String code;
	@SerializedName("date")
	private String date;
	@SerializedName("id")
	private int id;
	@SerializedName("total")
	private String total;

	public void setCode(String code){
		this.code = code;
	}
	public String getCode(){
		return this.code;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getDate(){
		return this.date;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setTotal(String total){
		this.total = total;
	}
	public String getTotal(){
		return this.total;
	}

	public ModelMyOrder() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelMyOrder(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		code = (String) jsonObject.opt("code");
		date = (String) jsonObject.opt("date");
		id = jsonObject.optInt("id");
		total = (String) jsonObject.opt("total");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("code", code);
			jsonObject.put("date", date);
			jsonObject.put("id", id);
			jsonObject.put("total", total);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}