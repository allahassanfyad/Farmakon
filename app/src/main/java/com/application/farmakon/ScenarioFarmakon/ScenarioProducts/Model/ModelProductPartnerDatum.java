package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model;//
//  ModelProductPartnerDatum.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on July 28, 2020

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class ModelProductPartnerDatum{

	@SerializedName("description")
	private String description;
	@SerializedName("id")
	private int id;
	@SerializedName("image")
	private String image;
	@SerializedName("price")
	private String price;
	@SerializedName("price_after_discount")
	private String priceAfterDiscount;
	@SerializedName("qty_stock")
	private String qtyStock;
	@SerializedName("title")
	private String title;

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
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
	public void setPrice(String price){
		this.price = price;
	}
	public String getPrice(){
		return this.price;
	}
	public void setPriceAfterDiscount(String priceAfterDiscount){
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public String getPriceAfterDiscount(){
		return this.priceAfterDiscount;
	}
	public void setQtyStock(String qtyStock){
		this.qtyStock = qtyStock;
	}
	public String getQtyStock(){
		return this.qtyStock;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}

	public ModelProductPartnerDatum() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public ModelProductPartnerDatum(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		description = (String) jsonObject.opt("description");
		image = (String) jsonObject.opt("image");
		price = (String) jsonObject.opt("price");
		qtyStock = (String) jsonObject.opt("qty_stock");
		title = (String) jsonObject.opt("title");
		id = jsonObject.optInt("id");
		priceAfterDiscount = (String) jsonObject.opt("price_after_discount");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("description", description);
			jsonObject.put("id", id);
			jsonObject.put("image", image);
			jsonObject.put("price", price);
			jsonObject.put("price_after_discount", priceAfterDiscount);
			jsonObject.put("qty_stock", qtyStock);
			jsonObject.put("title", title);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}