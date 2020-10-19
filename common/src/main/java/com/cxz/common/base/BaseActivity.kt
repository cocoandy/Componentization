package com.cxz.common.base

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.cxz.common.spread.setBiningContentView


abstract class BaseActivity : AppCompatActivity(), BaseView {
    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentView()
        initStatusBar()
        initView()
        initViewEvent()
        initData()
    }

     open fun initContentView() {
        setBiningContentView()
    }

    /**
     * 获取状态栏的高度
     */
    protected fun getStatusBarHeight(mContext: Context): Int {
        val mResId = mContext.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (mResId > 0) {
            return mContext.resources.getDimensionPixelSize(mResId)
        }
        return 0;
    }

    /**
     * 设置Title高度和padding 保证标题不被状态栏遮住
     */
    fun setBarHeightAndPadding(mView: View) {
        val params: ViewGroup.LayoutParams = mView.layoutParams
        val mStatusBarHeight = getStatusBarHeight(this)
        params.height += mStatusBarHeight
        mView.setPadding(0, mStatusBarHeight, 0, 0)
    }

    /**
     * 设置返回键和返回键的图标
     */
    fun setNavigationOnClick(mToolBar: Toolbar, icon: Int) {
        mToolBar.setNavigationIcon(icon)
        mToolBar.setNavigationOnClickListener {
            finish()
        }
    }

    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    fun verifyStoragePermissions() {
        // Check if we have write permission
        val permission = ActivityCompat.checkSelfPermission(
            this!!,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                this, PERMISSIONS_STORAGE,
                REQUEST_EXTERNAL_STORAGE
            )
        }
    }


    /**
     * 沉浸式
     */
    private fun initStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            //Android 在4.4版本以下不支持沉浸式
            return
        }

        //判断是否大于5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //清除透明状态栏的标识
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //添加绘制状态栏的标识
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置标题栏的颜色
            window.statusBarColor = Color.TRANSPARENT

            var visible = window.decorView.systemUiVisibility
            //隐藏虚拟导航栏
            visible = visible or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            visible = visible or View.SYSTEM_UI_FLAG_IMMERSIVE
            //设置布局内容全屏显示
            visible = visible or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            //防止内容区域发生变化
            visible = visible or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

            window.decorView.systemUiVisibility = visible
        } else {
            // 小于5.0的处理
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }

    }


}