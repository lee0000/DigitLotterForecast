package fcas.ltoy.mf.com.digitlotterforecast.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bingmingli on 16/11/15.
 */

public class VolleyUtil {
    private Context mContext;
    private RequestQueue mQueue;

    private static VolleyUtil mVolleyUtil = null;

    private VolleyUtil(Context context) {
        mContext = context;
        mQueue = Volley.newRequestQueue(mContext);
    }

    public static VolleyUtil getInstance(Context context) {
        if (mVolleyUtil == null) {
            mVolleyUtil = new VolleyUtil(context);
        }
        return mVolleyUtil;
    }

    /**
     * Post请求
     *
     * @param url
     * @param value
     * @param listener
     * @param errorListener
     */
    public <T> void post(String url, final T value, Listener<String> listener, ErrorListener errorListener) {

        StringRequest request = new StringRequest(Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("params", GsonUtil.toJson(value));
                return map;
            }
        };
        mQueue.add(request);
    }

    /**
     * Get请求
     *
     * @param url
     * @param value
     * @param listener
     * @param errorListener
     */
    public <T> void get(String url, final T value, Listener<String> listener, ErrorListener errorListener) {

        StringRequest request = new StringRequest(Method.GET, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("params", GsonUtil.toJson(value));
                return map;
            }
        };
        mQueue.add(request);
    }

    public RequestQueue getmQueue() {
        return mQueue;
    }
}
