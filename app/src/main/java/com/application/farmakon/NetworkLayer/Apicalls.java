package com.application.farmakon.NetworkLayer;

import android.content.Context;

import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @desc Java Api Calls Contains all the Project Calls
 */

public class Apicalls
{

    private APIRouter apiRouter;

    public Apicalls(Context context, NetworkInterface networkInterface)
    {

        apiRouter = new APIRouter(context, networkInterface);
    }

    //----------------------------------------------------------------------------------------------

    /**
     *
     * @func User Login
     */

    public void loginUser(final String email, final String password, final String  mob_token) {

        apiRouter.performRequest(Apiclient.LOGIN_USER.getURL(),Apiclient.LOGIN_USER.getParams(), Arrays.asList(email,password,mob_token), Request.Method.POST,Apiclient.LOGIN_USER.getCode());

    }


    //----------------------------------------------------------------------------------------------


    /**
     *
     * @func User Registration
     */

    public void registerUser(final String Name, final String Phone, final String Email, final String Password, final String Platform,final String Image_Url,final String Lang,final String Mobile_Token)
    {

        apiRouter.performRequest(Apiclient.Register_Uer.getURL(),Apiclient.Register_Uer.getParams(), Arrays.asList(Name,Phone,Email,Password,Platform,Image_Url,Lang,Mobile_Token), Request.Method.POST,Apiclient.Register_Uer.getCode());


    }

    //----------------------------------------------------------------------------------------------



    /**
     *
     * @func Edit User Profile
     */

    public  void get_all_branches ()
    {

//        apiRouter.performRequest(Apiclient.GET_ALL_BRANCHES.getURL(),Apiclient.GET_ALL_BRANCHES.getParams(),null, Request.Method.GET,Apiclient.GET_ALL_BRANCHES.getCode());

    }

    //----------------------------------------------------------------------------------------------


    /**
     *
     * @func Add a new Ad
     */

    public  void get_Payment_Info ()
    {

        apiRouter.performRequest(Apiclient.PAYMENT_INFO.getURL(),Apiclient.PAYMENT_INFO.getParams(),null, Request.Method.GET,Apiclient.PAYMENT_INFO.getCode());

    }

    //----------------------------------------------------------------------------------------------


    /**
     *
     * @func Main Activity Ads
     *
     */

    public void get_products ()
    {

        apiRouter.performRequest(Apiclient.PRODUCTS.getURL(),Apiclient.PRODUCTS.getParams(),null, Request.Method.GET, Apiclient.PRODUCTS.getCode());

    }

    //----------------------------------------------------------------------------------------------


    /**
     *
     * @func Main Activity Ads
     *
     */


    public void get_Payment_Merhod (final String sub_total,final String tax,final String discount,final String delivery,final String total,final String order_id,final String payment_method )
    {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.PAYMENT_METHOD.getURL(),Request.Method.POST,Apiclient.PAYMENT_METHOD.getParams(),Arrays.asList(sub_total,tax,discount,delivery,total,order_id,payment_method), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    //----------------------------------------------------------------------------------------------

    /**
     *
     * @func Main Activity Ads
     *
     */

    public void get_My_Order_Details (final String order_id)
    {

        try {

            apiRouter.makeAdvancedRequest(Apiclient.MY_ORDERS_DETAILS.getURL(),Request.Method.POST,Apiclient.MY_ORDERS_DETAILS.getParams(),Collections.singletonList(order_id), null);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------


    /**
     *
     * @func Main Activity Ads
     *
     */

    public void get_Bank_Tranfer (final String order_id,final String bank_name,final String owner_name,final String account_number,final String amount,final String image_url)
    {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.BANK_TRANSFER.getURL(),Request.Method.POST,Apiclient.BANK_TRANSFER.getParams(),Arrays.asList(order_id,bank_name,owner_name,account_number,amount,image_url), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------



    /**
     *
     * @func Main Activity Ads
     *
     */

    public void get_My_Order ()
    {
        try {

            apiRouter.makeAdvancedRequest(Apiclient.MY_ORDERS.getURL(),Request.Method.GET,Apiclient.MY_ORDERS.getParams(),null, null);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------


    /**
     *
     * @func Main Activity Ads
     *
     */

    public void sendOrder (final JSONObject items)
    {
        try {
            apiRouter.makeAdvancedRequest2(Apiclient.SEND_ORDER.getURL(),Request.Method.POST,Apiclient.SEND_ORDER.getParams(),items,null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        apiRouter.performRequest(Apiclient.SEND_ORDER.getURL(),Apiclient.SEND_ORDER.getParams(), Arrays.asList(items), Request.Method.POST,Apiclient.SEND_ORDER.getCode());

    }

    //----------------------------------------------------------------------------------------------




    public void get_Verfication_Register (final String user_id,final String code)
    {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.REGISTER_CONFIRMATION.getURL(),Request.Method.POST,Apiclient.REGISTER_CONFIRMATION.getParams(),Arrays.asList(user_id,code), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------




    public void Logout() {

        try {
            apiRouter.makeAdvancedRequest(Apiclient.LOGOUT.getURL(),Request.Method.GET,Apiclient.LOGOUT.getParams(),null,null);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------------------------------------------
}