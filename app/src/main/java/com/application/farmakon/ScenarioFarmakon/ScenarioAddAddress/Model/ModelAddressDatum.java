package com.application.farmakon.ScenarioFarmakon.ScenarioAddAddress.Model;//
//  ModelAddressDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 24, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelAddressDatum{

	@SerializedName("address_id")
	private int addressId;
	@SerializedName("address_name")
	private String addressName;
	@SerializedName("phone")
	private String phone;

	public void setAddressId(int addressId){
		this.addressId = addressId;
	}
	public int getAddressId(){
		return this.addressId;
	}
	public void setAddressName(String addressName){
		this.addressName = addressName;
	}
	public String getAddressName(){
		return this.addressName;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelAddressDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		addressName = (String) jsonObject.opt("address_name");
		phone = (String) jsonObject.opt("phone");
		addressId = jsonObject.optInt("address_id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("address_id", addressId);
			jsonObject.put("address_name", addressName);
			jsonObject.put("phone", phone);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}