package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model;//
//  ModelAllProduct.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on May 14, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelAllProduct{

	@SerializedName("selected_items")
	private ModelAllSelectedItem[] selectedItems;
	@SerializedName("status")
	private int status;

	public void setSelectedItems(ModelAllSelectedItem[] selectedItems){
		this.selectedItems = selectedItems;
	}
	public ModelAllSelectedItem[] getSelectedItems(){
		return this.selectedItems;
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
	public ModelAllProduct(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		status = jsonObject.optInt("status");
		JSONArray selectedItemsJsonArray = jsonObject.optJSONArray("selected_items");
		if(selectedItemsJsonArray != null){
			ArrayList<ModelAllSelectedItem> selectedItemsArrayList = new ArrayList<>();
			for (int i = 0; i < selectedItemsJsonArray.length(); i++) {
				JSONObject selectedItemsObject = selectedItemsJsonArray.optJSONObject(i);
				selectedItemsArrayList.add(new ModelAllSelectedItem(selectedItemsObject));
			}
			selectedItems = (ModelAllSelectedItem[]) selectedItemsArrayList.toArray();
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
			if(selectedItems != null && selectedItems.length > 0){
				JSONArray selectedItemsJsonArray = new JSONArray();
				for(ModelAllSelectedItem selectedItemsElement : selectedItems){
					selectedItemsJsonArray.put(selectedItemsElement.toJsonObject());
				}
				jsonObject.put("selected_items", selectedItemsJsonArray);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}