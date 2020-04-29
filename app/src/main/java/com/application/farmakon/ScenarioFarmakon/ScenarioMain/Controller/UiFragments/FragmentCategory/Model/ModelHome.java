package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model;//
//  ModelHome.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on April 27, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelHome{

	@SerializedName("categories")
	private ModelCategory[] categories;
	@SerializedName("selected_items")
	private ModelSelectedItem[] selectedItems;
	@SerializedName("slides")
	private ModelSlide[] slides;
	@SerializedName("status")
	private int status;

	public void setCategories(ModelCategory[] categories){
		this.categories = categories;
	}
	public ModelCategory[] getCategories(){
		return this.categories;
	}
	public void setSelectedItems(ModelSelectedItem[] selectedItems){
		this.selectedItems = selectedItems;
	}
	public ModelSelectedItem[] getSelectedItems(){
		return this.selectedItems;
	}
	public void setSlides(ModelSlide[] slides){
		this.slides = slides;
	}
	public ModelSlide[] getSlides(){
		return this.slides;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}

	public ModelHome() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelHome(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		status = jsonObject.optInt("status");
		JSONArray categoriesJsonArray = jsonObject.optJSONArray("categories");
		if(categoriesJsonArray != null){
			ArrayList<ModelCategory> categoriesArrayList = new ArrayList<>();
			for (int i = 0; i < categoriesJsonArray.length(); i++) {
				JSONObject categoriesObject = categoriesJsonArray.optJSONObject(i);
				categoriesArrayList.add(new ModelCategory(categoriesObject));
			}
			categories = (ModelCategory[]) categoriesArrayList.toArray();
		}
		JSONArray selectedItemsJsonArray = jsonObject.optJSONArray("selected_items");
		if(selectedItemsJsonArray != null){
			ArrayList<ModelSelectedItem> selectedItemsArrayList = new ArrayList<>();
			for (int i = 0; i < selectedItemsJsonArray.length(); i++) {
				JSONObject selectedItemsObject = selectedItemsJsonArray.optJSONObject(i);
				selectedItemsArrayList.add(new ModelSelectedItem(selectedItemsObject));
			}
			selectedItems = (ModelSelectedItem[]) selectedItemsArrayList.toArray();
		}
		JSONArray slidesJsonArray = jsonObject.optJSONArray("slides");
		if(slidesJsonArray != null){
			ArrayList<ModelSlide> slidesArrayList = new ArrayList<>();
			for (int i = 0; i < slidesJsonArray.length(); i++) {
				JSONObject slidesObject = slidesJsonArray.optJSONObject(i);
				slidesArrayList.add(new ModelSlide(slidesObject));
			}
			slides = (ModelSlide[]) slidesArrayList.toArray();
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
			if(categories != null && categories.length > 0){
				JSONArray categoriesJsonArray = new JSONArray();
				for(ModelCategory categoriesElement : categories){
					categoriesJsonArray.put(categoriesElement.toJsonObject());
				}
				jsonObject.put("categories", categoriesJsonArray);
			}
			if(selectedItems != null && selectedItems.length > 0){
				JSONArray selectedItemsJsonArray = new JSONArray();
				for(ModelSelectedItem selectedItemsElement : selectedItems){
					selectedItemsJsonArray.put(selectedItemsElement.toJsonObject());
				}
				jsonObject.put("selected_items", selectedItemsJsonArray);
			}
			if(slides != null && slides.length > 0){
				JSONArray slidesJsonArray = new JSONArray();
				for(ModelSlide slidesElement : slides){
					slidesJsonArray.put(slidesElement.toJsonObject());
				}
				jsonObject.put("slides", slidesJsonArray);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}