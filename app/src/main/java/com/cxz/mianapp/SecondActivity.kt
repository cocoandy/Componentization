package com.cxz.mianapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private var mTitle:String?= null
    companion object{
        fun  startAction(mContext:Context,title:String,name:String,age:Int ){
         val intent =   Intent().apply {
                setClass(mContext,SecondActivity::class.java)
                putExtra("TITLE",title)
                putExtra("NAME",name)
                putExtra("AGE",age)
            }
            mContext.startActivity(intent)
        }


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mTitle = intent.getStringExtra("TITLE")

        Log.e(javaClass.simpleName,"This is mTitle: $mTitle")

    }
}
