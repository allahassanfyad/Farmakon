package com.application.farmakon.ScenarioFarmakon.ScenarioCheckout.Model;//
//  ModelSendDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 29, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelSendDatum{

	@SerializedName("order_id")
	private int orderId;

	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	public int getOrderId(){
		return this.orderId;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelSendDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		orderId = jsonObject.optInt("order_id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("order_id", orderId);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}