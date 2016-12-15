package fcas.ltoy.mf.com.digitlotterforecast.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by bingmingli on 16/12/15.
 */

public class ExpertSsqListInfo extends BmobObject {
    private String title;
    private String content;
    private int count;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    @Override
//    public BmobDate getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(BmobDate createdAt) {
//        this.createdAt = createdAt;
//    }
}
