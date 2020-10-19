package com.cxz.mianapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTvMain.setOnClickListener (this)

    }

    override fun onClick(v: View?) {
        SecondActivity.startAction(this,"你好 123","大熊",18)
    }
}
