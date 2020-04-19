package com.application.farmakon.local_data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class saved_data {
    public static String get_Tax_Percentage(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("taxpercentage",MODE_PRIVATE);
        String taxpercentage=sharedPreferences.getString("taxpercentage","0");
        return taxpercentage;
    }

    public static String get_Discount_Percentage(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("discountpercentage",MODE_PRIVATE);
        String discountpercentage=sharedPreferences.getString("discountpercentage","0");
        return discountpercentage;
    }

    public static String get_Delevary(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("delivary",MODE_PRIVATE);
        String delivary=sharedPreferences.getString("delivary","0");
        return delivary;
    }


    public static String get_token(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",MODE_PRIVATE);
        String token=sharedPreferences.getString("token_key","0");
        return token;
    }

    public static String get_intro_num(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("intro_num",MODE_PRIVATE);
        String intro_num=sharedPreferences.getString("intro_num","0");
        return intro_num;
    }

    public static boolean get_user_check(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("id",MODE_PRIVATE);
        boolean value=sharedPreferences.getBoolean("islogin",false);
        return value;
    }


    public static boolean get_facebook_login(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("facebooklogin",MODE_PRIVATE);
        boolean value=sharedPreferences.getBoolean("islogin",false);
        return value;
    }

    public static boolean get_gmail_login(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("gmaillogin",MODE_PRIVATE);
        boolean value=sharedPreferences.getBoolean("islogin",false);
        return value;
    }

    public static String get_Product_Item_Id(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("product_id",MODE_PRIVATE);
        String product_id=sharedPreferences.getString("product_id","0");
        return product_id;
    }

    public static String get_Payment_Method_num(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("payment_num",MODE_PRIVATE);
        String payment_num=sharedPreferences.getString("payment_num","0");
        return payment_num;
    }

    public static String get_image_url(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("image_url",MODE_PRIVATE);
        String delivery_time=sharedPreferences.getString("image_url","0");
        return delivery_time;
    }

//
//    public String get_user_name(Context context)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_name",MODE_PRIVATE);
//        String user_name=sharedPreferences.getString("user_name","0");
//        return user_name;
//    }
//
//    public String get_user_email(Context context)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_email",MODE_PRIVATE);
//        String user_email=sharedPreferences.getString("user_email","0");
//        return user_email;
//    }
//
//    public String get_user_phone(Context context)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_phone",MODE_PRIVATE);
//        String user_phone=sharedPreferences.getString("user_phone","0");
//        return user_phone;
//    }
//
//    public static String get_user_id(Context context)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("user_id",MODE_PRIVATE);
//        String user_id=sharedPreferences.getString("user_id","0");
//        return user_id;
//    }
//
//    public boolean get_user_check(Context context)
//    {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("id",MODE_PRIVATE);
//        boolean value=sharedPreferences.getBoolean("islogin",false);
//        return value;
//    }

}
