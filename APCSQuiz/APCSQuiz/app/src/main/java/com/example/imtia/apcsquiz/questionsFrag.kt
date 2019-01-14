package com.example.imtia.apcsquiz

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import org.w3c.dom.Text

//import com.felipecsl.gifimageview.library.GifImageView


class questionsFrag:Fragment(){

    var t1: TextView?= null
    var t2: TextView?= null
    var t3: TextView?= null
    var t4: TextView?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         t1 = container?.findViewById<TextView>(R.id.textView4)
        t2 = container?.findViewById<TextView>(R.id.textView8)
        t3 = container?.findViewById<TextView>(R.id.textView9)
        t4 = container?.findViewById<TextView>(R.id.textView10)

        return inflater.inflate(R.layout.fragment_q, container, false)
    }

    fun optionBtn(v:View){
        v.setBackgroundColor(Color.rgb(34,34,34))
        val t:ImageView = v.findViewById<ImageView>(R.id.gifImageView)
        t.setVisibility(VISIBLE)
    }
}