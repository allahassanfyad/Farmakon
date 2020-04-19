package com.application.farmakon.NetworkLayer;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


class RequestHandler
{

    @SuppressLint("StaticFieldLeak")
    private static RequestHandler mInstance;
    private RequestQueue mRequestQueue;
    @SuppressLint("StaticFieldLeak")
    private static Context mCtx;

    private RequestHandler(Context context)
    {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    static synchronized RequestHandler getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new RequestHandler(context);
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue()
    {
        if (mRequestQueue == null)
        {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }

}
