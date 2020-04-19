package com.application.farmakon.local_data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class send_data {
    // SET TOTAL ID
    public static void CART_TAX_PERCETAGE(Context context, String taxpercentage)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("taxpercentage",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("taxpercentage", taxpercentage);
        editor.commit();
    }


    public static void CART_DISCOUNT_PERCETAGE(Context context, String discountpercentage)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("discountpercentage",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("discountpercentage", discountpercentage);
        editor.commit();
    }


    public static void CART_DELIVARY(Context context, String delivary)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("delivary",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("delivary", delivary);
        editor.commit();
    }


    //Get Token
    public static void token(Context context, String token)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("token_key", token);
        editor.commit();
    }



    //SET PRODUCT ID
    public static void SET_INTRO_NUM(Context context, String intro_num)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("intro_num",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("intro_num", intro_num);
        editor.commit();
    }

    public static void userId_check(Context context , boolean value)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("id",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("islogin",value);
        editor.commit();
    }

    //LOGIN FACEBOOK USER
    public static void FACEBOOK_LOGIN(Context context , boolean value)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("facebooklogin",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("islogin",value);
        editor.commit();
    }

    //LOGIN GMAIL USER
    public static void GMAIL_LOGIN(Context context , boolean value)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("gmaillogin",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("islogin",value);
        editor.commit();
    }


    //SET OFFER ID
    public static void SET_Product_Item_Id(Context context, String id)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("product_id",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("product_id", id);
        editor.commit();
    }

    public static void SET_PAYMENT_METHODNUMBER(Context context, String payment_num)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("payment_num",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("payment_num", payment_num);
        editor.commit();
    }

    //Image BAnk Transfer
    public static void SAVE_IMAGE(Context context, String image)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("image_url",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("image_url", image);
        editor.commit();
    }

//
//    //SET USER NAME
//    public static void SET_USER_NAME(Context context, String user_name)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_name",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("user_name", user_name);
//        editor.commit();
//    }
//
//    //SET EMAIL
//    public static void SET_USER_EMAIL(Context context, String user_email)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_email",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("user_email", user_email);
//        editor.commit();
//    }
//
//    //SET PHONE
//    public static void SET_USER_PHONE(Context context, String user_phone)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_phone",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("user_phone", user_phone);
//        editor.commit();
//    }
//
//    //SET USER ID
//    public static void SET_USER_ID(Context context, String user_id)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_id",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("user_id", user_id);
//        editor.commit();
//    }
//
//    public static void userId_check(Context context , boolean value)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("id",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putBoolean("islogin",value);
//        editor.commit();
//    }

}
