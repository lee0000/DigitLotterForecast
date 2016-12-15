package fcas.ltoy.mf.com.digitlotterforecast.ui.hall.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fcas.ltoy.mf.com.digitlotterforecast.R;
import fcas.ltoy.mf.com.digitlotterforecast.model.HallListInfo;

/**
 * Created by bingmingli on 16/11/15.
 */

public class HallHomeItemAdapter extends RecyclerView.Adapter {
    public static interface OnRecyclerViewListener {
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    private static final String TAG = HallHomeItemAdapter.class.getSimpleName();
    private List list;

    public void setDataList(List list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hall_item, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        PersonViewHolder holder = (PersonViewHolder) viewHolder;
        holder.position = position;
        HallListInfo.HallDetailListInfo person = (HallListInfo.HallDetailListInfo)list.get(position);
        holder.nameTv.setText(person.getIssue());
    }

    @Override
    public int getItemCount() {
        if (list == null)return 0;
        return list.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
    {
        public View rootView;
        public TextView nameTv;
        public int position;

        public PersonViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.textView);
//            ageTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_age_tv);
            rootView = itemView.findViewById(R.id.rootView);
            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener) {
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(null != onRecyclerViewListener){
                return onRecyclerViewListener.onItemLongClick(position);
            }
            return false;
        }
    }
}
