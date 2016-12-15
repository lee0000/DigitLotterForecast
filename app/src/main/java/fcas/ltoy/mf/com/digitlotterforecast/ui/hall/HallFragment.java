package fcas.ltoy.mf.com.digitlotterforecast.ui.hall;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import fcas.ltoy.mf.com.digitlotterforecast.R;
import fcas.ltoy.mf.com.digitlotterforecast.model.HallListInfo;
import fcas.ltoy.mf.com.digitlotterforecast.serve.ClientManager;
import fcas.ltoy.mf.com.digitlotterforecast.ui.hall.adapter.HallHomeItemAdapter;

import static fcas.ltoy.mf.com.digitlotterforecast.R.id.recyclerView;

/**
 * Created by lee0oo0 on 16/11/13.
 */

public class HallFragment extends Fragment implements HallHomeItemAdapter.OnRecyclerViewListener {

    private final String mPageName = getClass().getName();
    private Context mContext;
    private View mRootView;

    HallHomeItemAdapter mHallHomeItemAdapter;

    @BindView(recyclerView)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(mPageName);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(mPageName);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.hall_fragment,container,false);
        ButterKnife.bind(this,mRootView);

        mRecyclerView.setHasFixedSize(true);
        mHallHomeItemAdapter = new HallHomeItemAdapter();
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mHallHomeItemAdapter.setOnRecyclerViewListener(this);
        mRecyclerView.setAdapter(mHallHomeItemAdapter);
        initDate();
        return mRootView;
    }

    private void initDate(){
//        ClientManager.getInstance().hallSsqList(getActivity(), "", new ClientManager.ICallBakBlock() {
//            @Override
//            public <T> void successBlock(T object) {
//
//                HallListInfo hallListInfo = (HallListInfo)object;
//                mHallHomeItemAdapter.setDataList(hallListInfo.getList());
//            }
//
//            @Override
//            public void errorBlock(Exception error) {
//
//            }
//        });

        ClientManager.getInstance().getHallSsqListFromBomb(getActivity(), "", new ClientManager.ICallBakBlock() {
            @Override
            public <T> void successBlock(T object) {
                HallListInfo hallListInfo = (HallListInfo)object;
                mHallHomeItemAdapter.setDataList(hallListInfo.getList());
            }

            @Override
            public void errorBlock(Exception error) {

            }
        });
    }

    public void onItemClick(int position){

    }

    public boolean onItemLongClick(int position){
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}


