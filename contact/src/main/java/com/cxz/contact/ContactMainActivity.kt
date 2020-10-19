package com.cxz.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.contact_main_activity.*

class ContactMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_main_activity)
        mTvMains.setOnClickListener(View.OnClickListener {
            Toast.makeText(baseContext,"--------------->",Toast.LENGTH_SHORT).show()
        })
//        mTvMains.setOnClickListener {
//            Log.e("ContactMainActivity","--------------->")
//        }
    }
}
