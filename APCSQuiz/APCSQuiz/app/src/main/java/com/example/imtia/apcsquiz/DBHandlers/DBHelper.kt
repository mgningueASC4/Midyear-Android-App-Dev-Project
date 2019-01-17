package com.example.imtia.apcsquiz.DBHandlers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "APCSExamDB.db"

        //Table Categories
        private val TABLE_NAME = "Exam Questions"
        private val COL_CAT1 = "Category"
        private val COL_CAT2 = "Category2"
        private val COL_CAT3 = "Category3"
        private val COL_YEAR = "Year"
        private val COL_QUESTION_NUMBER = "Question Number"
        private val COL_QUESTION = "Question"
        private val COL_CORRECT_ANSWER = "Correct Answer"
        private val COL_ANSWER_A = "Answer A"
        private val COL_ANSWER_B = "Answer B"
        private val COL_ANSWER_C = "Answer C"
        private val COL_ANSWER_D = "Answer D"
        private val COL_ANSWER_E = "Answer E"
    }
}