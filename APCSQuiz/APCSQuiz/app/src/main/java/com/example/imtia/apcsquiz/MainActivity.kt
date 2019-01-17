package com.example.imtia.apcsquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.imtia.apcsquiz.R.layout.activity_main2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //widgets
    lateinit var testButton: Button
    lateinit var algorithmBtn: Button
    lateinit var loopBtn: Button
    lateinit var arrayBtn: Button
    lateinit var arrayListBtn: Button
    lateinit var stringBtn: Button
    lateinit var classesBtn: Button
    lateinit var fieldsBtn: Button
    lateinit var recursionBtn: Button
    lateinit var bigOBtn: Button
    lateinit var searchSortBtn: Button

    var btnList : ArrayList<Button>  = ArrayList<Button>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidgets()
    }

    fun initWidgets(){
        testButton = TestButton
        algorithmBtn = ab_expressions
        loopBtn = loops
        arrayBtn = arrays
        arrayListBtn = arraylists
        stringBtn = strings
        classesBtn = class_interface_inheritance_polymorphism
        fieldsBtn = fields_methods_prameter
        recursionBtn = recursion
        bigOBtn = big_o
        searchSortBtn = searchSort

        btnList.add(algorithmBtn)
        btnList.add(algorithmBtn)
        btnList.add(loopBtn)
        btnList.add(arrayBtn)
        btnList.add(arrayListBtn)
        btnList.add(stringBtn)
        btnList.add(classesBtn)
        btnList.add(fieldsBtn)
        btnList.add(fieldsBtn)
        btnList.add(recursionBtn)
        btnList.add(bigOBtn)
        btnList.add(searchSortBtn)

        for(x in btnList){
            var v = x.rootView
            var t = x.text.toString()
            x.setOnClickListener {
                menuBtnAction(v, t)
            }
        }

    }

    fun menuBtnAction(v: View , topic:String){
        val i:Intent = Intent(this,Main2Activity::class.java)
        i.putExtra("TOPIC", topic)
        startActivity(i)
    }
}
