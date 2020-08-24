package com.application.farmakon.NetworkLayer;

import android.content.Context;

import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;

/**
 * @desc Java Api Calls Contains all the Project Calls
 */

public class Apicalls {

    private APIRouter apiRouter;

    public Apicalls(Context context, NetworkInterface networkInterface) {

        apiRouter = new APIRouter(context, networkInterface);
    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func User Login
     */

    public void loginUser(final String phone, final String platform, final String mobile_token, final String password) {

        apiRouter.performRequest(Apiclient.LOGIN_USER.getURL(), Apiclient.LOGIN_USER.getParams(), Arrays.asList(phone, platform, mobile_token, password), Request.Method.POST, Apiclient.LOGIN_USER.getCode());

    }


    //----------------------------------------------------------------------------------------------


    /**
     * @func User Registration
     */

    public void login_with_facebook(final String email, final String password, final String mobile_token) {

        apiRouter.performRequest(Apiclient.LOGIN_WITH_FACEBOOK.getURL(), Apiclient.LOGIN_WITH_FACEBOOK.getParams(), Arrays.asList(email, password, mobile_token), Request.Method.POST, Apiclient.LOGIN_WITH_FACEBOOK.getCode());


    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func User Registration
     */

    public void register_with_facebook(final String name, final String phone, final String email, final String password, final String platform, final String image_url, final String mobile_token) {

        apiRouter.performRequest(Apiclient.REGISTER_WITH_FACEBOOK.getURL(), Apiclient.REGISTER_WITH_FACEBOOK.getParams(), Arrays.asList(name, phone, email, password, platform, image_url, mobile_token), Request.Method.POST, Apiclient.REGISTER_WITH_FACEBOOK.getCode());


    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Edit User Profile
     */

    public void update_personal_info(final String email, final String name, final String gender, final String dob, final String lang) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.UPDATE_PERSONAL_INFO.getURL(), Request.Method.POST, Apiclient.UPDATE_PERSONAL_INFO.getParams(), Arrays.asList(email, name, gender, dob, lang), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Add a new Ad
     */

    public void get_all_category() {

        try {

            apiRouter.makeAdvancedRequest(Apiclient.ALL_CATEGORIES.getURL(), Request.Method.GET, Apiclient.ALL_CATEGORIES.getParams(), null, null);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Main Activity Ads
     */

    public void category_product(final String category_id) {


        try {

            apiRouter.makeAdvancedRequest(Apiclient.CATEGORY_PRODUCT.getURL(), Request.Method.POST, Apiclient.CATEGORY_PRODUCT.getParams(), Collections.singletonList(category_id), null);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Main Activity Ads
     */


    public void add_address(final String address_name, final String address_details, final String building, final String floor, final String apartment, final String notes) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.ADD_ADDRESS.getURL(), Request.Method.POST, Apiclient.ADD_ADDRESS.getParams(), Arrays.asList(address_name, address_details, building, floor, apartment, notes), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    //----------------------------------------------------------------------------------------------

    /**
     * @func Main Activity Ads
     */

    public void add_location(final String address, final String lat, final String lang) {

        try {

            apiRouter.makeAdvancedRequest(Apiclient.ADD_LOCATION.getURL(), Request.Method.POST, Apiclient.ADD_LOCATION.getParams(), Arrays.asList(address, lat, lang), null);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Main Activity Ads
     */

    public void send_order(final String products, final String image_urls, final String notes, final String address_id) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.SEN_ORDER.getURL(), Request.Method.POST, Apiclient.SEN_ORDER.getParams(), Arrays.asList(products, image_urls, notes, address_id), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Main Activity Ads
     */

    public void get_my_Orders() {
        try {

            apiRouter.makeAdvancedRequest(Apiclient.MY_ORDERS.getURL(), Request.Method.GET, Apiclient.MY_ORDERS.getParams(), null, null);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------


    /**
     * @func Main Activity Ads
     */

    public void faq() {
        try {
            apiRouter.makeAdvancedRequest(Apiclient.FAQ.getURL(), Request.Method.GET, Apiclient.FAQ.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        apiRouter.performRequest(Apiclient.SEND_ORDER.getURL(),Apiclient.SEND_ORDER.getParams(), Arrays.asList(items), Request.Method.POST,Apiclient.SEND_ORDER.getCode());

    }

    //----------------------------------------------------------------------------------------------


    public void get_personal_info() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.GET_PERSONAL_INFO.getURL(), Request.Method.GET, Apiclient.GET_PERSONAL_INFO.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    public void get_user_address() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.GET_USER_ADDRESS.getURL(), Request.Method.GET, Apiclient.GET_USER_ADDRESS.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    public void Logout() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.LOGOUT.getURL(), Request.Method.GET, Apiclient.LOGOUT.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------


    public void get_home() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.GET_HOME.getURL(), Request.Method.GET, Apiclient.GET_HOME.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    public void get_notification() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.GET_NOTIFICATION.getURL(), Request.Method.GET, Apiclient.GET_NOTIFICATION.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    public void get_all_products() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.GET_PRODUCTS.getURL(), Request.Method.GET, Apiclient.GET_PRODUCTS.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    public void search_product(final String key) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.SEARCH_PRODUCT.getURL(), Request.Method.POST, Apiclient.SEARCH_PRODUCT.getParams(), Collections.singletonList(key), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    public void get_partner() {

        try {
            apiRouter.makeAdvancedRequest1(Apiclient.GET_PARTNER.getURL(), Request.Method.GET, Apiclient.GET_PARTNER.getParams(), null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------



    public void get_Sub_Category(final String category_id) {

        try {
            apiRouter.makeAdvancedRequest1(Apiclient.GET_SUB_CATEGORY.getURL(), Request.Method.POST, Apiclient.GET_SUB_CATEGORY.getParams(), Collections.singletonList(category_id), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------



    public void get_Partner_product(final String partner_id) {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.GET_PARTNER_PRODUCT.getURL(), Request.Method.POST, Apiclient.GET_PARTNER_PRODUCT.getParams(), Collections.singletonList(partner_id), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


}