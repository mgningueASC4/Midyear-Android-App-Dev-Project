package com.example.imtia.apcsquiz

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
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
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.imtia.apcsquiz.DBHandlers.DBHelper
import com.example.imtia.apcsquiz.Main2Activity
import kotlinx.android.synthetic.main.fragment_q.*

import java.util.*
import kotlin.collections.ArrayList


class questionsFrag : Fragment(){
    //widgets
    private val TAG = "questionFrag"
    lateinit var a: TextView
    lateinit var b: TextView
    lateinit var c: TextView
    lateinit var d: TextView
    lateinit var e: TextView
    lateinit var nextBtn: ImageView
    lateinit var questionImage: ImageView

    var mContext = this.activity

    //arrays of buttons and questions
    var ar:ArrayList<TextView> = ArrayList<TextView>()
    var masterList:ArrayList<QuestionObject> = ArrayList<QuestionObject>()
    var topicQuestions:ArrayList<QuestionObject> = ArrayList<QuestionObject>()

    //database handling
    lateinit var dbHelper: DBHelper
    private var listener: OnFragmentInteractionListener? = null

    //topic of questions
    private var topic: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflate layout
        val v:View = inflater.inflate(R.layout.fragment_q, container, false)
        inflater.inflate(R.layout.fragment_q, container, false)
        Log.d(TAG, "question frag view inflated")
        //implement widgetes
        initButtons(v)

        //create database
        dbHelper = DBHelper(v.context)
        //get list of all questions from db
        masterList = dbHelper.getAllQuestions()

        //retrieve topic
        val args : Bundle ?= arguments
        topic = args?.getString("TOPIC")
        Log.d(TAG, "Topic selected: " + topic)

        //create list of questions according to topic selected
        getTopicQuestions(topic, topicQuestions)
        return v
    }

    //method to initialize answer buttons
    fun initButtons(v:View){
        a = v.findViewById(R.id.choiceA) as TextView
        b = v.findViewById(R.id.choiceB) as TextView
        c = v.findViewById(R.id.choiceC) as TextView
        d = v.findViewById(R.id.choiceD) as TextView
        e = v.findViewById(R.id.choiceE) as TextView
        
        
        ar.add(0, a)
        ar.add(1, b)
        ar.add(2, c)
        ar.add(3, d)
        ar.add(4, e)

        nextBtn = v.findViewById(R.id.gifImageView) as ImageView
        questionImage = v.findViewById(R.id.questionImageView) as ImageView

        answerSelection()
    }
    //add function to answer buttons
    fun answerSelection(){
        a.setOnClickListener {
            a.setBackgroundResource(R.drawable.answerselectedbackground)
            a.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE

            for(x in ar){
               if(x!=a){
                   x.setBackgroundResource(R.drawable.choicesbg3)
                   x.setTextColor(Color.rgb(0,0,0))
               }
            }

        }

        b.setOnClickListener {
            b.setBackgroundResource(R.drawable.answerselectedbackground)
            b.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE

            for(x in ar){
                if(x!=b){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }

        c.setOnClickListener {
            c.setBackgroundResource(R.drawable.answerselectedbackground)
            c.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE

            for(x in ar){
                if(x!=c){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }


        }

        d.setOnClickListener {
            d.setBackgroundResource(R.drawable.answerselectedbackground)
            d.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE

            for(x in ar){
                if(x!=d){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }
        }


        e.setOnClickListener {
            e.setBackgroundResource(R.drawable.answerselectedbackground)
            e.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE

            for(x in ar){
                if(x!=e){
                    x.setBackgroundResource(R.drawable.choicesbg3)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }
    }
    
    //create list questions based on topic
    fun getTopicQuestions(topic:String?, list:ArrayList<QuestionObject>){
        for (x in masterList){
            if(x.category1.equals(topic) || x.category2.equals(topic) || x.category3.equals(topic)){
                list.add(x)
                Log.d(TAG, "Questions for: " + topic + ", question year: " + x.Year)
            }
        }
    }

    fun showQuiz(list:ArrayList<QuestionObject>){
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