package com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model;//
//  ModelGetAddressDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 24, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelGetAddressDatum{

	@SerializedName("address_name")
	private String addressName;
	@SerializedName("apartment_no")
	private String apartmentNo;
	@SerializedName("build_no")
	private String buildNo;
	@SerializedName("floor_no")
	private String floorNo;
	@SerializedName("full_address")
	private String fullAddress;
	@SerializedName("id")
	private int id;
	@SerializedName("latitude")
	private Object latitude;
	@SerializedName("longitude")
	private Object longitude;
	@SerializedName("notes")
	private Object notes;

	public void setAddressName(String addressName){
		this.addressName = addressName;
	}
	public String getAddressName(){
		return this.addressName;
	}
	public void setApartmentNo(String apartmentNo){
		this.apartmentNo = apartmentNo;
	}
	public String getApartmentNo(){
		return this.apartmentNo;
	}
	public void setBuildNo(String buildNo){
		this.buildNo = buildNo;
	}
	public String getBuildNo(){
		return this.buildNo;
	}
	public void setFloorNo(String floorNo){
		this.floorNo = floorNo;
	}
	public String getFloorNo(){
		return this.floorNo;
	}
	public void setFullAddress(String fullAddress){
		this.fullAddress = fullAddress;
	}
	public String getFullAddress(){
		return this.fullAddress;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setLatitude(Object latitude){
		this.latitude = latitude;
	}
	public Object getLatitude(){
		return this.latitude;
	}
	public void setLongitude(Object longitude){
		this.longitude = longitude;
	}
	public Object getLongitude(){
		return this.longitude;
	}
	public void setNotes(Object notes){
		this.notes = notes;
	}
	public Object getNotes(){
		return this.notes;
	}

	public ModelGetAddressDatum() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelGetAddressDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		addressName = (String) jsonObject.opt("address_name");
		apartmentNo = (String) jsonObject.opt("apartment_no");
		buildNo = (String) jsonObject.opt("build_no");
		floorNo = (String) jsonObject.opt("floor_no");
		fullAddress = (String) jsonObject.opt("full_address");
		id = jsonObject.optInt("id");
		latitude = (String) jsonObject.opt("latitude");
		longitude = (String) jsonObject.opt("longitude");
		notes = (String) jsonObject.opt("notes");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("address_name", addressName);
			jsonObject.put("apartment_no", apartmentNo);
			jsonObject.put("build_no", buildNo);
			jsonObject.put("floor_no", floorNo);
			jsonObject.put("full_address", fullAddress);
			jsonObject.put("id", id);
			jsonObject.put("latitude", latitude);
			jsonObject.put("longitude", longitude);
			jsonObject.put("notes", notes);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}