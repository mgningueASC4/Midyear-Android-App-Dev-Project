package com.example.imtia.apcsquiz


import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.util.Log




class Main2Activity : AppCompatActivity(), questionsFrag.OnFragmentInteractionListener {
    private val TAG: String = "Main2Activity"
    lateinit var questionFragment: questionsFrag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //initialize fragment
        questionFragment = questionsFrag()
        init()
    }

    fun init(){
        //replace fragments in container
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.questionFragment, questionFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        Log.d(TAG, "question fragment started")
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

}
