package com.example.imtia.apcsquiz

import android.app.Activity
import android.support.v4.app.Fragment
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.imtia.apcsquiz.DBHandlers.DBHelper
import me.itangqi.waveloadingview.WaveLoadingView
import kotlin.system.exitProcess

class resultsFrag: Fragment() {
    private var listener: questionsFrag.OnFragmentInteractionListener? = null

    lateinit var wl:WaveLoadingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflate layout
        val v: View = inflater.inflate(R.layout.fragment_r, container, false)
        inflater.inflate(R.layout.fragment_r, container, false)
        wl = v.findViewById(R.id.waveLoadingView)
        val a: Bundle ?= arguments
        var c:String ?= a?.getString("Correct")
        var c2 = c?.toDouble()
        var c3 = c2?.toInt()
        wl.progressValue = c3!!

        if(c3<50.00){
            wl.bottomTitle = c+"%"
        }else if(c3<80){
            wl.centerTitle = c+"%"
        }else{
            wl.topTitle = c+"%"
        }

        val e = v.findViewById<ImageView>(R.id.imageView)
        e.setOnClickListener{
            exitProcess(-1)
        }
        return v
    }


    //methods not to be touched, don't want to mess with interface methods
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }



    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}