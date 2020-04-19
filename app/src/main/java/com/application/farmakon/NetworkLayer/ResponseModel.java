package com.application.farmakon.NetworkLayer;

import org.json.JSONObject;

/**
 *
 * @desc Java Response Model Class for Controlling the Response by Specific Code
 */


public class ResponseModel
{

    private int responseCode;
    private String response;
    private JSONObject jsonObject;

    ResponseModel(int responseCode, String response)
    {
        this.responseCode = responseCode;
        this.response = response;
    }

    ResponseModel(int responseCode, JSONObject jsonObject)
    {
        this.responseCode = responseCode;
        this.jsonObject = jsonObject;
    }

    public int getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(int responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getResponse()
    {
        return response;
    }

    public void setResponse(String response)
    {
        this.response = response;
    }

    public JSONObject getJsonObject()
    {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject)
    {
        this.jsonObject = jsonObject;
    }
}
