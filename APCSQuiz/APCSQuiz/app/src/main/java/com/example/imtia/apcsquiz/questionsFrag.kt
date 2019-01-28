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
import org.w3c.dom.Text

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
    lateinit var  divider: View
    lateinit var questionTitle: TextView

    var mContext = this.activity

    //arrays of buttons and questions
    var ar:ArrayList<TextView> = ArrayList<TextView>()
    var masterList:ArrayList<QuestionObject> = ArrayList<QuestionObject>()
    var topicQuestions:ArrayList<QuestionObject> = ArrayList<QuestionObject>()

    //the number in index
    var currentQuestion = 0
    lateinit var currentQuestionShown: QuestionObject

    //database handling
    lateinit var dbHelper: DBHelper
    private var listener: OnFragmentInteractionListener? = null

    //topic of questions, questions correct, questions wrong
    private var topic: String ?= null
    var numberCorrect = 0
    var numberOfQuestions = 0

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

        //start test
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
        questionTitle = v.findViewById(R.id.questionNumberText) as TextView
        divider = v.findViewById(R.id.divider) as View
        panelScrollView = v.findViewById(R.id.answersScrollView) as ScrollView
        answerPanel = v.findViewById(R.id.answerPannel) as LinearLayout
        
        ar.add(0, a)
        ar.add(1, b)
        ar.add(2, c)
        ar.add(3, d)
        ar.add(4, e)

        nextBtn = v.findViewById(R.id.gifImageView) as ImageView
        questionImage = v.findViewById(R.id.questionImageView) as ImageView
    }

    //add function to answer buttons
    //answerSelection() called in startTest()
    fun answerSelection(){
        for (x in ar){
            answerSelectedMethod(x)
        }
    }
    //when an answer is clicked the bar will light up red if answered incorrect and green if correct
    //if wrong, the correct answer will be highlighted green
    fun answerSelectedMethod(chosen:TextView){
            chosen.setOnClickListener {
                if(nextBtn.visibility == INVISIBLE){
                chosen.setBackgroundResource(R.drawable.answerselectedbackground)
                chosen.setTextColor(Color.rgb(0, 0, 0))
                for (x in ar) {
                    if (x != chosen) {
                        x.setBackgroundResource(R.drawable.answerchoicesbackground)
                        x.setTextColor(Color.rgb(0, 0, 0))
                    }
                }

                var chosenAnswer = chosen.text?.substring(1, 2)
                Log.d("ANSWERING", "CHOSEN ANSWER: " + chosenAnswer)
                Log.d("ANSWERING", "CORRECT ANSWER: " + currentQuestionShown.correctAnswer)
                if (chosenAnswer.equals(currentQuestionShown.correctAnswer)) {
                    chosen.setBackgroundResource(R.drawable.answercorrectbackground)
                    divider.setBackgroundColor(Color.rgb(0, 255, 0))
                    numberCorrect++
                } else {
                    divider.setBackgroundColor(Color.rgb(255, 0, 0))
                    for (x in ar) {
                        if (x.text?.substring(1, 2).equals(currentQuestionShown.correctAnswer)) {
                            x.setBackgroundResource(R.drawable.answercorrectbackground)
                        }
                    }
                }
                nextBtn.visibility = VISIBLE
                nextBtn.requestFocus()
            } else {

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

        //0th, i.e, first question in list is showns
        var textTitle = "#" + (currentQuestion+1) + "/" + numberOfQuestions
        questionTitle.setText(textTitle)

        showQuestion(currentQuestion, modList)
        currentQuestionShown = modList.get(currentQuestion)
        answerSelection()

        //everytime nextbutton is clicked, the next question is shown
        nextBtn.setOnClickListener{
            divider.setBackgroundColor(0)
            if(currentQuestion < modList.size-1) {

                currentQuestion++

                var textTitle = "#" + (currentQuestion+1) + "/" + numberOfQuestions
                questionTitle.setText(textTitle)

                showQuestion(currentQuestion,modList)
                currentQuestionShown = modList.get(currentQuestion)
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
            }
            nextBtn.visibility = INVISIBLE
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