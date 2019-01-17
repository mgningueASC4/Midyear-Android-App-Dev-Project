package com.example.imtia.apcsquiz

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Vibrator
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.imtia.apcsquiz.DBHandlers.DBHelper
import com.example.imtia.apcsquiz.Main2Activity

import java.util.*
import kotlin.collections.ArrayList


class questionsFrag : Fragment(){
    //widgets
    lateinit var t1: TextView
    lateinit var t2: TextView
    lateinit var t3: TextView
    lateinit var t4: TextView
    lateinit var t5: TextView
    lateinit var btn: ImageView
    lateinit var questionImage: ImageView

    var mContext = this.activity

    //arrays of buttons and questions
    var ar:ArrayList<TextView> = ArrayList<TextView>()
    var questions:ArrayList<QuestionObject> = ArrayList<QuestionObject>()

    //database handling
    lateinit var dbHelper: DBHelper
    private var listener: OnFragmentInteractionListener? = null

    //topic of questions
    private lateinit var topic: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val v:View = inflater.inflate(R.layout.fragment_q, container, false)
            //implement widgetes
            initButtons(v)
            //create database
            dbHelper = DBHelper(v.context)
            questions = dbHelper.getAllQuestions()
            //inflate layout
            inflater.inflate(R.layout.fragment_q, container, false)
            //retrieve topic
            topic = arguments!!.getString("TOPIC")
            //start actions
            btnFunction()
            return v
    }

    //method to initialize answer buttons
    fun initButtons(v:View){
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
        questionImage = v.findViewById(R.id.questionImageView) as ImageView
    }
    //add function to answer buttons
    fun btnFunction(){
        t1.setOnClickListener {
            t1.setBackgroundColor(Color.rgb(0,0,0))
            t1.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
               if(x!=t1){
                   x.setBackgroundResource(R.drawable.choicesbg3)
                   x.setTextColor(Color.rgb(0,0,0))
               }
            }

        }

        t2.setOnClickListener {
            t2.setBackgroundColor(Color.rgb(0,0,0))
            t2.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t2){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }

        t3.setOnClickListener {
            t3.setBackgroundColor(Color.rgb(0,0,0))
            t3.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t3){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }


        }

        t4.setOnClickListener {
            t4.setBackgroundColor(Color.rgb(0,0,0))
            t4.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t4){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }
        }


        t5.setOnClickListener {
            t5.setBackgroundColor(Color.rgb(0,0,0))
            t5.setTextColor(Color.rgb(255,255,255))
            btn.visibility = VISIBLE

            for(x in ar){
                if(x!=t5){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }
    }
    //create list questions based on topic

    fun phoneVibrate(x: Int) {
       // val b = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        //b?.vibrate(x.toLong())
    }


    //______________________________________________________________________________________________
    //methods not to be touched, don't want to mess with interface methods
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
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