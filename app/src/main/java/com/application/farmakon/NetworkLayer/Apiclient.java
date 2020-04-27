package com.application.farmakon.NetworkLayer;


import androidx.core.app.NavUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Apiclient
{

    /**
     * @API
     *
     * ---> 1) URL OF API METHOD
     *
     * ---> 2) ARRAY OF PARAMETERS KEYS
     *
     */

    LOGIN_USER("auth/login-with-phone", Arrays.asList("phone", "platform","mobile_token","password"),1),
    LOGIN_WITH_FACEBOOK("auth/login-with-facebook", Arrays.asList("email","password","mobile_token"),2),
    REGISTER_WITH_FACEBOOK("auth/register-with-facebook",Arrays.asList("name","phone","email","password","platform","image_url","mobile_token"),3),
    UPDATE_PERSONAL_INFO("update-personal-info", Arrays.asList("email","name","gender","dob","lang"),4),
    LOGOUT("logout",null,5),
    ALL_CATEGORIES("categories", null,6),
    CATEGORY_PRODUCT("category-products",Collections.singletonList("category_id"),7),
    ADD_ADDRESS("add-address-to-user", Arrays.asList("address_name","address_details","building","floor","apartment","notes"),8),
    ADD_LOCATION("add-location-to-user", Collections.singletonList("order_id"),9),
    MY_ORDERS("my-orders",null,10),
    FAQ("faq", null,11),
    SEN_ORDER("order-items", Arrays.asList("products","image_urls","notes","address_id"),12),
    GET_PERSONAL_INFO("my-personal-info", null,13),
    GET_USER_ADDRESS("my-address", null,14);







    //--------------------------------------

    /**
     * @BASE_URL
     */

    String BASE_URL = "https://www.pharmakon.be4maps.com/api/";

    private final String URL;
    private final List<String> params;
    private  final int code;



    Apiclient(String URL, List<String> params, int code)
    {

        this.URL = URL;
        this.params = params;
        this.code = code;
}

    public String getURL()
    {
        return BASE_URL + URL;
    }

    public List<String> getParams()
    {
        return params;
    }

    public int getCode()
    {
        return code;
    }
}
