package fcas.ltoy.mf.com.digitlotterforecast.ui.tool;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fcas.ltoy.mf.com.digitlotterforecast.R;

/**
 * Created by lee0oo0 on 16/11/13.
 */

public class ToolFragment extends Fragment {

    private Context mContext;
    private View mRootView;

    @BindView(R.id.webview)
    WebView mWebView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.tool_fragment,container,false);
        ButterKnife.bind(this,mRootView);

//        String html_value = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"><title>Lorem Ipsum</title></head><body style=\"width:300px; color: #00000; \"><p><strong> About us</strong> </p><p><strong> Lorem Ipsum</strong> is simply dummy text .</p><p><strong> Lorem Ipsum</strong> is simply dummy text </p><p><strong> Lorem Ipsum</strong> is simply dummy text </p></body></html>";
//        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.loadData(html_value, "text/html", "UTF-8");
        mWebView.loadUrl("https://vipc.cn/ssq/checkup");
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}


