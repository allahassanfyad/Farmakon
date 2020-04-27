package com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model;//
//  ModelGetAddressUser.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 24, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelGetAddressUser{

	@SerializedName("data")
	private ModelGetAddressDatum[] data;
	@SerializedName("status")
	private int status;

	public void setData(ModelGetAddressDatum[] data){
		this.data = data;
	}
	public ModelGetAddressDatum[] getData(){
		return this.data;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}


	public ModelGetAddressUser() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelGetAddressUser(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		status = jsonObject.optInt("status");
		JSONArray dataJsonArray = jsonObject.optJSONArray("data");
		if(dataJsonArray != null){
			ArrayList<ModelGetAddressDatum> dataArrayList = new ArrayList<>();
			for (int i = 0; i < dataJsonArray.length(); i++) {
				JSONObject dataObject = dataJsonArray.optJSONObject(i);
				dataArrayList.add(new ModelGetAddressDatum(dataObject));
			}
			data = (ModelGetAddressDatum[]) dataArrayList.toArray();
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
			if(data != null && data.length > 0){
				JSONArray dataJsonArray = new JSONArray();
				for(ModelGetAddressDatum dataElement : data){
					dataJsonArray.put(dataElement.toJsonObject());
				}
				jsonObject.put("data", dataJsonArray);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}