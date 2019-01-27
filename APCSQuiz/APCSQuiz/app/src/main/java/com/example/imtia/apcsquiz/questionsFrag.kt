package com.example.imtia.apcsquiz

import android.content.Context
import android.graphics.Bitmap
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
import android.widget.*
import com.example.imtia.apcsquiz.DBHandlers.DBHelper
import com.example.imtia.apcsquiz.Main2Activity
import com.example.imtia.apcsquiz.Utils.Utils
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
    lateinit var panelScrollView: ScrollView
    lateinit var answerPanel: LinearLayout

    var mContext = this.activity

    //arrays of buttons and questions
    var ar:ArrayList<TextView> = ArrayList<TextView>()
    var masterList:ArrayList<QuestionObject> = ArrayList<QuestionObject>()
    var topicQuestions:ArrayList<QuestionObject> = ArrayList<QuestionObject>()
    var numberOfQuestions = 0
    var currentQuestion = 0

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


        //retrieve topic
        val args : Bundle ?= arguments
        topic = args?.getString("TOPIC")
        Log.d(TAG, "Topic selected: " + topic)


        //create database
        dbHelper = DBHelper(v.context)
        //get list of all questions from db
        masterList = dbHelper.getAllQuestions()
        topicQuestions = getQuestions(masterList, topic)
        numberOfQuestions = topicQuestions.size
        startTest(topicQuestions)

        return v
    }

    //method to initialize answer buttons
    fun initButtons(v:View){
        a = v.findViewById(R.id.choiceA) as TextView
        b = v.findViewById(R.id.choiceB) as TextView
        c = v.findViewById(R.id.choiceC) as TextView
        d = v.findViewById(R.id.choiceD) as TextView
        e = v.findViewById(R.id.choiceE) as TextView
        panelScrollView = v.findViewById(R.id.answersScrollView) as ScrollView
        answerPanel = v.findViewById(R.id.answerPannel) as LinearLayout
        
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
            nextBtn.requestFocus()

            for(x in ar){
               if(x!=a){
                   x.setBackgroundResource(R.drawable.answerchoicesbackground)
                   x.setTextColor(Color.rgb(0,0,0))
               }
            }

        }

        b.setOnClickListener {
            b.setBackgroundResource(R.drawable.answerselectedbackground)
            b.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE
            nextBtn.requestFocus()

            for(x in ar){
                if(x!=b){
                    x.setBackgroundResource(R.drawable.answerchoicesbackground)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }

        c.setOnClickListener {
            c.setBackgroundResource(R.drawable.answerselectedbackground)
            c.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE
            nextBtn.requestFocus()

            for(x in ar){
                if(x!=c){
                    x.setBackgroundResource(R.drawable.answerchoicesbackground)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }


        }

        d.setOnClickListener {
            d.setBackgroundResource(R.drawable.answerselectedbackground)
            d.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE
            nextBtn.requestFocus()

            for(x in ar){
                if(x!=d){
                    x.setBackgroundResource(R.drawable.answerchoicesbackground)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }
        }


        e.setOnClickListener {
            e.setBackgroundResource(R.drawable.answerselectedbackground)
            e.setTextColor(Color.rgb(0,0,0))
            nextBtn.visibility = VISIBLE
            nextBtn.requestFocus()

            for(x in ar){
                if(x!=e){
                    x.setBackgroundResource(R.drawable.answerchoicesbackground)
                    x.setTextColor(Color.rgb(0,0,0))
                }
            }

        }
    }
    
    //create list questions based on topic
    fun getQuestions(list:ArrayList<QuestionObject>, topic: String?): ArrayList<QuestionObject>{
        var result: ArrayList<QuestionObject> = ArrayList<QuestionObject>()
        for(x in list){
            if(topic.equals(x.category1) || topic.equals(x.category2) || topic.equals(x.category3)){
                result.add(x)
            }
        }
        return result
    }

    fun startTest(list:ArrayList<QuestionObject>){
        var modList = list
        modList.shuffle()
        showQuestion(currentQuestion, modList)
        var selectedAnswer = ""
        for(x in ar){
            if(x.background.equals(R.drawable.answerselectedbackground)){
                selectedAnswer = x.text.toString()
                return
            }
        }
        nextBtn.setOnClickListener{
            //show result
            if(modList.get(currentQuestion).correctAnswer.equals(selectedAnswer)){
                ar.get(currentQuestion).setBackgroundResource(R.drawable.answercorrectbackground)
            }else{
                ar.get(currentQuestion).setBackgroundResource(R.drawable.answerwrongbackground)
            }
            //change nextBtn function to show next question
            nextBtn.setOnClickListener{
                if(currentQuestion < modList.size) {
                    currentQuestion++
                    showQuestion(currentQuestion,modList)
                }
            }

        }
    }

    fun showQuestion(qn:Int, list:ArrayList<QuestionObject>){
        //TODO: create a results fragment to show results
        if(qn != list.size) {
            a.requestFocus()
            var targetQuestion = list.get(qn)
            var targetImage = Utils.getImage(targetQuestion.Question)
            questionImage.setImageBitmap(targetImage)

            a.setText(targetQuestion.answerA)
            b.setText(targetQuestion.answerB)
            c.setText(targetQuestion.answerC)
            d.setText(targetQuestion.answerD)
            e.setText(targetQuestion.answerE)
            for(x in ar){
                x.setBackgroundResource(R.drawable.answerchoicesbackground)
                nextBtn.visibility = INVISIBLE
            }
        }
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