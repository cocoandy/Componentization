package com.cxz.order.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.cxz.order.R;

public class CustomPopupWindow extends PopupWindow implements View.OnClickListener {
    private View mPopView;
    private OnItemClickListener mListener;
    private ViewGroup rootview;

    public CustomPopupWindow(Context context, ViewGroup rootview) {
        super(context);
        this.rootview = rootview;
        init(context);
        setPopupWindow();

    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {        // TODO Auto-generated method stub
        LayoutInflater inflater = LayoutInflater.from(context);        //绑定布局
        mPopView = inflater.inflate(R.layout.dialog_input_text, rootview, false);

    }

    /**
     * 设置窗口的相关属性
     */
    @SuppressLint("InlinedApi")
    private void setPopupWindow() {
        this.setContentView(mPopView);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
//        this.setAnimationStyle(R.style.mypopwindow_anim_style);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明

    }

    /**
     * 定义一个接口，公布出去 在Activity中操作按钮的单击事件
     */
    public interface OnItemClickListener {
        void setOnItemClick(View v);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {        // TODO Auto-generated method stub
        if (mListener != null) {
            mListener.setOnItemClick(v);
        }
    }

}

