package com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model;//
//  ModelMyPreviousOrders.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 29, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelMyPreviousOrders{

	@SerializedName("orders")
	private ModelMyOrder[] orders;
	@SerializedName("status")
	private int status;

	public void setOrders(ModelMyOrder[] orders){
		this.orders = orders;
	}
	public ModelMyOrder[] getOrders(){
		return this.orders;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelMyPreviousOrders(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		status = jsonObject.optInt("status");
		JSONArray ordersJsonArray = jsonObject.optJSONArray("orders");
		if(ordersJsonArray != null){
			ArrayList<ModelMyOrder> ordersArrayList = new ArrayList<>();
			for (int i = 0; i < ordersJsonArray.length(); i++) {
				JSONObject ordersObject = ordersJsonArray.optJSONObject(i);
				ordersArrayList.add(new ModelMyOrder(ordersObject));
			}
			orders = (ModelMyOrder[]) ordersArrayList.toArray();
		}
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("status", status);
			if(orders != null && orders.length > 0){
				JSONArray ordersJsonArray = new JSONArray();
				for(ModelMyOrder ordersElement : orders){
					ordersJsonArray.put(ordersElement.toJsonObject());
				}
				jsonObject.put("orders", ordersJsonArray);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}