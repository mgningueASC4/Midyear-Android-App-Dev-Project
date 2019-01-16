package com.example.imtia.apcsquiz

import android.content.Context
import android.graphics.Color
import android.graphics.PointF.length
import android.graphics.drawable.ColorDrawable
import android.media.Image
import android.os.Bundle
import android.os.Vibrator
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import kotlinx.android.synthetic.main.fragment_q.*
import org.w3c.dom.Text

//import com.felipecsl.gifimageview.library.GifImageView


class questionsFrag:Fragment(){

    lateinit var t1: TextView
    lateinit var t2: TextView
    lateinit var t3: TextView
    lateinit var t4: TextView
    lateinit var t5: TextView
    lateinit var btn: ImageView
    var ar:ArrayList<TextView> = ArrayList<TextView>()
    var userAnswers:ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val v:View = inflater.inflate(R.layout.fragment_q, container, false)
            t1 = v.findViewById<TextView>(R.id.textView4)
            t2 = v.findViewById<TextView>(R.id.textView8)
            t3 = v.findViewById<TextView>(R.id.textView9)
            t4 = v.findViewById<TextView>(R.id.textView10)
            t5 = v.findViewById<TextView>(R.id.textView)
            ar.add(0, t1)
            ar.add(1, t2)
            ar.add(2, t3)
            ar.add(3, t4)
            ar.add(4,t5)
            btn = v.findViewById(R.id.gifImageView) as ImageView
            inflater.inflate(R.layout.fragment_q, container, false)
            initButtons()
            return v
    }

    fun initButtons(){
        t1!!.setOnClickListener {
            t1!!.setBackgroundColor(Color.rgb(0,0,0))
            t1!!.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
               if(x!=t1){
                   x.setBackgroundResource(R.drawable.choicesbg3)
                   x.setTextColor(Color.rgb(0,0,0))
               }
            }

        }

        t2!!.setOnClickListener {
            t2!!.setBackgroundColor(Color.rgb(0,0,0))
            t2!!.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t2){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }

        t3!!.setOnClickListener {
            t3!!.setBackgroundColor(Color.rgb(0,0,0))
            t3!!.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t3){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }


        }

        t4!!.setOnClickListener {
            t4!!.setBackgroundColor(Color.rgb(0,0,0))
            t4!!.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t4){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }
        }


        t5!!.setOnClickListener {
            t5!!.setBackgroundColor(Color.rgb(0,0,0))
            t5!!.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t5){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }
    }

    fun phoneVibrate(x: Int) {
       // val b = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        //b?.vibrate(x.toLong())
    }


}