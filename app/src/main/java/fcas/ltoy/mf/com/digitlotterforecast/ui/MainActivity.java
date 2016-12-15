package fcas.ltoy.mf.com.digitlotterforecast.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import fcas.ltoy.mf.com.digitlotterforecast.R;
import fcas.ltoy.mf.com.digitlotterforecast.ui.hall.HallFragment;
import fcas.ltoy.mf.com.digitlotterforecast.ui.rcm.RcmSsqFragment;
import fcas.ltoy.mf.com.digitlotterforecast.ui.tool.ToolFragment;
import fcas.ltoy.mf.com.digitlotterforecast.util.Constant;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomTab)
    PagerBottomTabLayout mBottomTabLayout;

    Controller mBottomTabcontroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        Bmob.initialize(this, Constant.BOMB_KEY);
        mBottomTabcontroller = mBottomTabLayout.builder()
                .addTabItem(android.R.drawable.ic_menu_camera, "相机")
                .addTabItem(android.R.drawable.ic_menu_compass, "开奖")
                .addTabItem(android.R.drawable.ic_menu_help, "工具")
                .build();
        mBottomTabcontroller.addTabItemClickListener(listener);
    }

    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag)
        {
            Log.i("asd","onSelected:"+index+"   TAG: "+tag.toString());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (index){

                case 0:
                    RcmSsqFragment rcmSsqFragment = new RcmSsqFragment();
                    transaction.replace(R.id.frameLayout,rcmSsqFragment);
                    break;
                case 1:
                    HallFragment hallFragment = new HallFragment();
                    transaction.replace(R.id.frameLayout,hallFragment);
                    break;
                case 2:
                    ToolFragment toolFragment = new ToolFragment();
                    transaction.replace(R.id.frameLayout,toolFragment);
                    break;
            }

            transaction.commit();
        }

        @Override
        public void onRepeatClick(int index, Object tag) {
            Log.i("asd","onRepeatClick:"+index+"   TAG: "+tag.toString());
        }
    };

}
