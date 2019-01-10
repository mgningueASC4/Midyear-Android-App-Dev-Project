package com.example.imtia.apcsquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.imtia.apcsquiz.R.layout.activity_main2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var testButton: Button
    lateinit var ab_expression: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidgets()
    }

    fun initWidgets(){
        testButton = TestButton
        //stringButton = button1
    }

    fun menuBtnAction(v: View){
        val i:Intent = Intent(this,Main2Activity::class.java)
        startActivity(i)
    }
}
