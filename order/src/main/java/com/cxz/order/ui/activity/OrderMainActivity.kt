package com.cxz.order.ui.activity

import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.*
import com.cxz.order.R
import com.cxz.order.databinding.OrderMainActivityBinding
import com.cxz.order.views.CustomPopupWindow
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.order_main_activity.*


class OrderMainActivity : BaseActivity(), View.OnClickListener {

    override fun initLayout(): Int = R.layout.order_main_activity
    override fun initContentView() {
        bining = setBiningContentView<OrderMainActivityBinding> {
            it.lifecycleOwner = this
            it.clickListener = this
        }
        mToolBar.init(this) {
            setTitle("首页导航")
            inflateMenu(R.menu.mian_menu)
            mToolBar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    item?.itemId.toString().showToast()
                    popu?.showAtLocation(mRlMain, Gravity.BOTTOM, 0, 0)
                    return true
                }

            })
        }
    }

    private var bining: OrderMainActivityBinding? = null
    private var popu: CustomPopupWindow? = null


    override fun initView() {
        popu = CustomPopupWindow(this, mRlMain)
        verifyStoragePermissions()
    }

    override fun initData() {

    }


    override fun initViewEvent() {

    }

    override fun onClick(v: View?) {
        "------------------->>>>>".e(TAG)
        when (v) {
            mTvMainCarView -> {
                OrderCarViewActivity.startaction(this)
            }
            mTvMainRetrofit -> {
                OrderHttpActivity.startaction(this)
            }
            mTvMainSpread -> {
                OrderExtendActivity.startaction(this)
            }
            mTvMainCoordintor -> {
                OrderScrollingActivity.startaction(this)
            }
            mTvMainPaging -> {
                OrderPagingActivity.startaction(this)
            }
            mTvMainBining -> {
                OrderDataBiningActivity.startaction(this)
            }
        }


    }


}
