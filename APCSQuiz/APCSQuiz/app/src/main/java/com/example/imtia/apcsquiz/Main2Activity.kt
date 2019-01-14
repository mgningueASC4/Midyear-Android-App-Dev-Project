package com.example.imtia.apcsquiz

import android.app.Fragment
import android.app.FragmentManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import com.example.imtia.apcsquiz.R.layout.fragment_q
import java.util.ArrayList
//import javax.swing.text.StyleConstants.getBackground



class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    fun optionBtn(v: View){
        v.setBackgroundColor(Color.rgb(34,34,34))
       /* val t1 = v.findViewById<TextView>(R.id.textView4)
        val t2 = v.findViewById<TextView>(R.id.textView10)
        val t3 = v.findViewById<TextView>(R.id.textView8)
        val t4 = v.findViewById<TextView>(R.id.textView9)
        val cd = t1.getBackground() as ColorDrawable
        val cc = cd.getColor()

        val cd2 = t2.getBackground() as ColorDrawable
        val cc2 = cd2.getColor()

        val cd3 = t3.getBackground() as ColorDrawable
        val cc3 = cd3.getColor()

        val cd4 = t4.getBackground() as ColorDrawable
        val cc4 = cd4.getColor()
        if(v!=t1 && cc==Color.rgb(255, 255, 255)){
            t1.setBackgroundResource(R.drawable.choicesbg3)
        }else if(v!=t2 && cc2==Color.rgb(255, 255, 255)){
            t2.setBackgroundResource(R.drawable.choicesbg3)

        }else if(v!=t3 && cc3==Color.rgb(255, 255, 255)){
            t3.setBackgroundResource(R.drawable.choicesbg3)

        }else if(v!=t4 && cc4==Color.rgb(255, 255, 255)){
            t4.setBackgroundResource(R.drawable.choicesbg3)
        }else{

        }*/
        //val t: ImageView = v.findViewById<ImageView>(R.id.gifImageView)
        //t.setVisibility(VISIBLE)


    }


}
