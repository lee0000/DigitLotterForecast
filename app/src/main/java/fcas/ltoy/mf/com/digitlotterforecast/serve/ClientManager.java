package fcas.ltoy.mf.com.digitlotterforecast.serve;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import java.util.List;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CloudCodeListener;
import cn.bmob.v3.listener.FindListener;
import fcas.ltoy.mf.com.digitlotterforecast.model.ExpertSsqListInfo;
import fcas.ltoy.mf.com.digitlotterforecast.model.HallListInfo;
import fcas.ltoy.mf.com.digitlotterforecast.util.GsonUtil;
import fcas.ltoy.mf.com.digitlotterforecast.util.VolleyUtil;

import static fcas.ltoy.mf.com.digitlotterforecast.util.Constant.BASE_URL;

/**
 * Created by bingmingli on 16/11/15.
 */

public class ClientManager {
    private static ClientManager sSingleton = null;
    public static synchronized ClientManager getInstance() {
        if (sSingleton == null) {
            sSingleton = new ClientManager();
        }
        return sSingleton;
    }

    public interface ICallBakBlock{
        <T> void successBlock(T object);
        void errorBlock(Exception error);
    }

    // 双色球开奖列表
    public <T> void hallSsqList(Context context, T param, final ICallBakBlock callBakBlock){
        VolleyUtil.getInstance(context).get(BASE_URL + "lottery/ssq/first", param, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                HallListInfo hallListInfo = GsonUtil.gsonToBean(response, HallListInfo.class);
                callBakBlock.successBlock(hallListInfo);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBakBlock.errorBlock(error);
            }
        });
    };

    // 双色球专家推荐
    public <T> void expertSsqList(Context context, T param, final ICallBakBlock callBakBlock){
        BmobQuery<ExpertSsqListInfo> query = new BmobQuery<ExpertSsqListInfo>();
        query.findObjects(new FindListener<ExpertSsqListInfo>() {
            @Override
            public void done(List<ExpertSsqListInfo> list, BmobException e) {
                if (e == null){
                    callBakBlock.successBlock(list);
                }else{
                    callBakBlock.errorBlock(e);
                }
            }
        });
    };

    public <T> void getHallSsqListFromBomb(Context context, T param, final ICallBakBlock callBakBlock){
        AsyncCustomEndpoints ace = new AsyncCustomEndpoints();
        ace.callEndpoint("graspTest", new CloudCodeListener() {
            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    HallListInfo hallListInfo = GsonUtil.gsonToBean(o.toString(), HallListInfo.class);
                    callBakBlock.successBlock(hallListInfo);
                }else{
                    callBakBlock.errorBlock(e);
                }
            }

        });
    }
}