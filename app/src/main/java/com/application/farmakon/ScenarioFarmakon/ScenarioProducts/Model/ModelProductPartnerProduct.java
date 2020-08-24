package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model;//
//  ModelProductPartnerProduct.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on July 28, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelProductPartnerProduct{

	@SerializedName("data")
	private ModelProductPartnerDatum[] data;
	@SerializedName("status")
	private int status;

	public void setData(ModelProductPartnerDatum[] data){
		this.data = data;
	}
	public ModelProductPartnerDatum[] getData(){
		return this.data;
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
	public ModelProductPartnerProduct(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		status = jsonObject.optInt("status");
		JSONArray dataJsonArray = jsonObject.optJSONArray("data");
		if(dataJsonArray != null){
			ArrayList<ModelProductPartnerDatum> dataArrayList = new ArrayList<>();
			for (int i = 0; i < dataJsonArray.length(); i++) {
				JSONObject dataObject = dataJsonArray.optJSONObject(i);
				dataArrayList.add(new ModelProductPartnerDatum(dataObject));
			}
			data = (ModelProductPartnerDatum[]) dataArrayList.toArray();
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
				for(ModelProductPartnerDatum dataElement : data){
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