package com.cxz.order.ui.activity

import android.content.Context
import android.content.Intent
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.common.spread.init
import com.cxz.order.R
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.order_extend_activity.*
import java.lang.StringBuilder

/**
 * 扩展函数 let run with also apply
 */
class OrderExtendActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.order_extend_activity
    override fun initContentView() {
        setBiningContentView()
        mToolBar.init(activity = this, icon = R.mipmap.ic_back) {
            setTitle("Extend")
        }
    }


    var stringBuffer: StringBuffer? = null
    var stringBuffer1 = StringBuffer()

    companion object {
        fun startaction(mContext: Context) {
            val mIntent =
                Intent().apply() {
                    setClass(mContext, OrderExtendActivity::class.java)
                }
            mContext.startActivity(mIntent)
        }
    }


    override fun initView() {
    }

    //自己观察这几个扩展函数的不同  返回值  传入参数  用法
    override fun initData() {

        //场景1：最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理
        //场景2：然后就是需要去明确一个变量所处特定的作用域范围内可以使用
        val httpStr1 = stringBuffer?.let {
            it.append("http://")
            it.append("www")
            it.append(".")
            it.append("baidu")
            it.append(".")
            it.append("com")
            it.toString()
        }

        //返回值是最后一行指定
        var httpStr2 = stringBuffer?.run {
            append("http://")
            append("www")
            append(".")
            append("baidu")
            append(".")
            append("com")
            toString()
        }

        //传入对象，返回值是最后一行指定
        var httpStr3 = with(stringBuffer1) {
            append("http://")
            append("www")
            append(".")
            append("baidu")
            append(".")
            append("com")
            toString()
        }


        //和run用法一样，但是返回值是对象本身
        var httpStr4 = stringBuffer?.apply {
            append("http://")
            append("www")
            append(".")
            append("baidu")
            append(".")
            append("com")

        }.toString()


        //返回值是最后一行指定
        var httpStr5 = stringBuffer?.also() {
            it.append("http://")
            it.append("www")
            it.append(".")
            it.append("baidu")
            it.append(".")
            it.append("com")
        }.toString()

        mTvName.text =

            StringBuilder().apply {
                append(" //场景1：最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理\n")
                append(" //场景2：然后就是需要去明确一个变量所处特定的作用域范围内可以使用\n")
                append(" val httpStr1 = stringBuffer?.let {\n")
                append("     it.append(\"http://\")\n")
                append("     it.append(\"www\")\n")
                append("     it.append(\".\")\n")
                append("     it.append(\"baidu\")\n")
                append("     it.append(\".\")\n")
                append("     it.append(\"com\")\n")
                append("     it.toString()\n")
                append(" }\n")
                append("\n")
                append(" //返回值是最后一行指定\n")
                append(" var httpStr2 =  stringBuffer?.run {\n")
                append("     append(\"http://\")\n")
                append("     append(\"www\")\n")
                append("     append(\".\")\n")
                append("     append(\"baidu\")\n")
                append("     append(\".\")\n")
                append("     append(\"com\")\n")
                append("     toString()\n")
                append(" }\n")
                append("\n")
                append(" //传入对象，返回值是最后一行指定\n")
                append(" var httpStr3 = with(stringBuffer1){\n")
                append("     append(\"http://\")\n")
                append("     append(\"www\")\n")
                append("     append(\".\")\n")
                append("     append(\"baidu\")\n")
                append("     append(\".\")\n")
                append("     append(\"com\")\n")
                append("     toString()\n")
                append(" }\n")
                append("\n")
                append("\n")
                append(" //和run用法一样，但是返回值是对象本身\n")
                append(" var httpStr4 = stringBuffer?.apply {\n")
                append("     append(\"http://\")\n")
                append("     append(\"www\")\n")
                append("     append(\".\")\n")
                append("     append(\"baidu\")\n")
                append("     append(\".\")\n")
                append("     append(\"com\")\n")
                append("\n")
                append(" }.toString()\n")
                append("\n")
                append("\n")
                append(" //返回值是最后一行指定\n")
                append(" var httpStr5 =stringBuffer?.also(){\n")
                append("     it.append(\"http://\")\n")
                append("     it.append(\"www\")\n")
                append("     it.append(\".\")\n")
                append("     it.append(\"baidu\")\n")
                append("     it. append(\".\")\n")
                append("     it.  append(\"com\")\n")
                append(" }.toString()")
            }.toString()
    }

    override fun initViewEvent() {

    }
}
