package com.example.imtia.apcsquiz

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

class questionsFrag:Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val i = view?.findViewById<ImageView>(R.id.imageView)
        //Glide.with(this).load(R.drawable.betternextbtn).asGif().crossFade().into(i)
        return inflater.inflate(R.layout.fragment_q, container, false)

    }
}