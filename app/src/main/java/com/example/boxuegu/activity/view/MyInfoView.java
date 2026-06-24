package com.example.boxuegu.activity.view;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boxuegu.R;
import com.example.boxuegu.activity.LoginActivity;
import com.example.boxuegu.activity.SettingActivity;
import com.example.boxuegu.activity.UserInfoActivity;
import com.example.boxuegu.activity.utils.UtilsHelper;

/**
 * 个人中心/“我的”页面 视图类
 * 负责UI渲染、事件分发及登录状态展示逻辑
 */
public class MyInfoView implements View.OnClickListener {
    // 头像ImageView
    public ImageView iv_head_icon;

    // 头部布局（点击跳转）
    private LinearLayout ll_head;

    // 历史课程记录布局、设置布局
    private RelativeLayout rl_course_history, rl_setting;

    // 用户名显示TextView
    private TextView tv_user_name;

    // 上下文对象（绑定的Activity）
    private Activity mContext;

    // 布局加载器
    private LayoutInflater mInflater;

    // 当前页面的根View
    private View mCurrentView;

    // 登录状态标记
    private boolean isLogin = false;

    /**
     * 构造函数，初始化上下文和布局加载器
     * @param context 关联的Activity上下文
     */
    public MyInfoView(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        // 加载个人中心布局
        mCurrentView = mInflater.inflate(R.layout.main_view_myinfo, null);

        // 绑定布局控件ID
        ll_head = mCurrentView.findViewById(R.id.ll_head);
        iv_head_icon = mCurrentView.findViewById(R.id.iv_head_icon);
        rl_course_history = mCurrentView.findViewById(R.id.rl_course_history);
        rl_setting = mCurrentView.findViewById(R.id.rl_setting);
        tv_user_name = mCurrentView.findViewById(R.id.tv_user_name);

        // 设置页面可见
        mCurrentView.setVisibility(View.VISIBLE);

        // 根据登录状态设置UI参数
        setLoginParams(isLogin);

        // 注册点击事件监听器
        ll_head.setOnClickListener(this);
        rl_course_history.setOnClickListener(this);
        rl_setting.setOnClickListener(this);
    }

    /**
     * 点击事件分发处理
     * @param view 被点击的View
     */
    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.ll_head) {
            // 点击头部区域（头像/用户名）
            if (UtilsHelper.readLoginStatus(mContext)) {
                // 已登录：跳转到个人资料页面
                // 此处可添加跳转逻辑 Intent...
                Intent intent = new Intent(mContext, UserInfoActivity.class);
                mContext.startActivity(intent);
            } else {
                // 未登录：跳转到登录页面
                Intent intent = new Intent(mContext, LoginActivity.class);
                mContext.startActivityForResult(intent, 1);
            }
        } else if (viewId == R.id.rl_course_history) {
            // 点击学习历史记录
            if (UtilsHelper.readLoginStatus(mContext)) {
                // 已登录：跳转播放记录页面
                // 此处可添加跳转逻辑 Intent...
            } else {
                // 未登录：弹出提示
                Toast.makeText(mContext, "您还未登录，请先登录", Toast.LENGTH_SHORT).show();
            }
        } else if (viewId == R.id.rl_setting) {
            // 点击设置
            if (UtilsHelper.readLoginStatus(mContext)) {
                // 已登录：跳转到设置页面
                // 此处可添加跳转逻辑 Intent...
                //case R.id.rl_setting:
                    if ((UtilsHelper.readLoginStatus(mContext))) {
                        Intent intent=new Intent(mContext, SettingActivity.class);
                        mContext.startActivityForResult(intent,1);
                    }else{
                        Toast.makeText(mContext,"您还未登录，请先登录",
                                Toast.LENGTH_SHORT).show();

                    }
                    //break;
            } else {
                // 未登录：弹出提示
                Toast.makeText(mContext, "您还未登录，请先登录", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 根据登录状态更新界面显示（用户名/点击登录）
     * @param isLogin 登录状态
     */
    public void setLoginParams(boolean isLogin) {
        if (isLogin) {
            // 已登录：显示用户名
            tv_user_name.setText(UtilsHelper.readLoginUserName(mContext));
        } else {
            // 未登录：显示“点击登录”提示
            tv_user_name.setText("点击登录");
        }
    }

    /**
     * 获取页面根View
     * @return 初始化后的View
     */
    public View getView() {
        // 获取当前登录状态
        isLogin = UtilsHelper.readLoginStatus(mContext);

        // 如果View未初始化，则进行初始化
        if (mCurrentView == null) {
            initView();
        }
        return mCurrentView;
    }

    /**
     * 显示“我的”页面
     */
    public void showView() {
        // 如果View未初始化，则先初始化
        if (mCurrentView == null) {
            initView();
        }
        // 设置页面为可见状态
        mCurrentView.setVisibility(View.VISIBLE);
    }
}