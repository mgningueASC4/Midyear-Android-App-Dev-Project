package com.example.imtia.apcsquiz

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.*
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
    lateinit var scrollView: ScrollView
    var originalBtnHeight = 0
    var originalBtnWidth = 0
    var btnList : ArrayList<Button>  = ArrayList<Button>()
    lateinit var cardFlip: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidgets()
    }

    fun initWidgets(){
        //init sound
        cardFlip = MediaPlayer.create(this, R.raw.cardflip)
        //scrollview
        scrollView = buttonScrollView

        // testButton = TestButton
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

        originalBtnHeight = algorithmBtn.layoutParams.height
        originalBtnWidth = algorithmBtn.layoutParams.width

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

        //set methods for buttons
        for(x in btnList){
            var v = x.rootView
            var t = x.text.toString()
            x.setOnClickListener {
                menuBtnAction(v, t, cardFlip)
            }


            var a: AnimationDrawable = x.background as AnimationDrawable
            a.setEnterFadeDuration(1500)
            a.setExitFadeDuration(1500)
            a.start()

        }

        initScrollListener(scrollView, cardFlip)

    }
    fun initScrollListener(v:ScrollView, m:MediaPlayer){
        Log.d("Main", "checking scroll")
        v.getViewTreeObserver().addOnScrollChangedListener {
            Log.d("Main", "scrolling...")
            m.start()
        }
    }

    fun menuBtnAction(v: View , topic:String, m:MediaPlayer){
        val i:Intent = Intent(this,Main2Activity::class.java)
        i.putExtra("TOPIC", topic)
        startActivity(i)
        m.start()
    }
}
