package com.elife.tzelife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.elife.tzelife.R;
import com.elife.tzelife.model.OrderModel;

import java.util.ArrayList;

/**
 * Created by tzhang on 2016/9/26.
 */
public class NormalPagerAdapter extends RecyclerView.Adapter<NormalPagerAdapter.NormalViewHolder> {

    private Context mContext;
    private ArrayList<OrderModel> mListDelivery;


    public NormalPagerAdapter(Context context, ArrayList<OrderModel> listDelivery) {
        this.mContext = context;
        this.mListDelivery = listDelivery;
    }

    // 完成view的获取，返回ViewHolder
    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        View view = View.inflate(parent.getContext(), R.layout.item_normal_adapter, null);

        return new NormalViewHolder(view);
    }

    // 为控件设置数据，执行与ListView的getView相似，就是当一个item有不可见变为可见时就会执行一次onBindViewHolder方法
    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public NormalViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View view) {

        }
    }

    private IOnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(IOnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface IOnItemClickListener {
        void onItemClick(View view, int postion);
    }
}
