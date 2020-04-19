package com.application.farmakon.NetworkLayer;


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

    LOGIN_USER("auth/login", Arrays.asList("email", "password","mobile_token"),1),
    Register_Uer("auth/register", Arrays.asList("name","phone","email","password","platform","image_url","lang","mobile_token"),2),
    LOGOUT("logout?",null,3),
    PAYMENT_INFO("checkout",null,4),
    PRODUCTS("products",null,5),
    PAYMENT_METHOD("order-finance", Arrays.asList("sub_total","tax","discount","delivery","total","order_id","payment_method"),6),
    BANK_TRANSFER("bank-transfer",Arrays.asList("order_id","bank_name","owner_name","account_number","amount","image_url"),7),
    MY_ORDERS("my-orders", null,8),
    MY_ORDERS_DETAILS("my-order-details", Collections.singletonList("order_id"),9),
    SEND_ORDER("order-items",null,10),
    REGISTER_CONFIRMATION("auth/verify", Arrays.asList("user_id","code"),11),
    Select_By_City("/select_haraj_by_search_city", Collections.singletonList("city"),12);





    //--------------------------------------

    /**
     * @BASE_URL
     */

    String BASE_URL = "http://www.tamraat.com/api/";

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
