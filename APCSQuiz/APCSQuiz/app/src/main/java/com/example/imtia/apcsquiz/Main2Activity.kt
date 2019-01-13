package com.example.imtia.apcsquiz

import android.app.Fragment
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.example.imtia.apcsquiz.R.layout.fragment_q
import java.util.ArrayList

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        /*val t:FragmentTransaction = supportFragmentManager.beginTransaction()
        val fq:QFragment = QFragment.newInstance()
        t?.add(R.id.fragmentHolder, fq, null)
        t?.commit()*/
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
        //val m:FragmentManager = getFragmentManager()



    }


}
