package com.example.imtia.apcsquiz.DBHandlers

import android.annotation.*
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.preference.PreferenceManager
import android.util.Log
import com.example.imtia.apcsquiz.QuestionObject
import java.io.*

class DBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VER){
    private val TAG = "#DB"
    private val context = context
    //lateinit var db: SQLiteDatabase


    companion object {
        private var DB_VER = 1
        private val DB_NAME = "APCSExam.db"
        private val DB_CREATED = "DB_CREATED"

        //Table Categories
        private val TABLE_NAME = "ExamQuestions"
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

    private var mCreateDb = false
    private var mUpgradeDb = false

    override fun onCreate(db: SQLiteDatabase?) {
        mCreateDb = true
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(newVersion > oldVersion) {
            mUpgradeDb = true
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        if(mCreateDb) {
            mCreateDb = false
            copyDatabaseFromAssets(db)
            Log.d(TAG, "Copied DB")
        }

        if(mUpgradeDb) {
            mUpgradeDb = false
            copyDatabaseFromAssets(db)
        }
    }

    private fun copyDatabaseFromAssets(db: SQLiteDatabase?) {
        var inputStream: InputStream? = null
        var outputStream: OutputStream? = null

        try {
            inputStream = context.assets.open(DB_NAME)
            outputStream = FileOutputStream(db?.path)

            val buffer = ByteArray(1024)
            var length: Int = inputStream!!.read(buffer)
            while (length > 0) {
                outputStream.write(buffer, 0, length)
                length = inputStream.read(buffer)
            }
            outputStream.flush()

            val  copiedDb = context.openOrCreateDatabase(DB_NAME, 0, null)

            val isDbCreated = copiedDb != null

            copiedDb.execSQL("PRAGMA user_version = $DB_VER")
            copiedDb.close()

            // DB_CREATED
            val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
            val sharePrefEditor = sharedPref.edit()
            sharePrefEditor.putBoolean(DB_CREATED, isDbCreated)
            sharePrefEditor.apply()
        } catch (e: IOException) {
            e.printStackTrace()
            throw Error("copyDatabaseFromAssets: Error copying database.")
        } finally {
            try {
                outputStream?.close()
                inputStream?.close()
            }catch (e: IOException) {
                e.printStackTrace()
                throw Error("copyDatabaseFromAssets: Error closing stream.")
            }
        }

    }



    //These methods reads the db and finds questions based on categories____________________________
    fun getAllQuestions() : ArrayList<QuestionObject>{
        Log.d(TAG, "Querying the database for the questions")
        var questionList: ArrayList<QuestionObject> = ArrayList<QuestionObject>()
        val db = this.readableDatabase
        val selectAllQuery = "SELECT * FROM " + TABLE_NAME
        val cursor = db.rawQuery(selectAllQuery, null)
        if (cursor != null){
            if(cursor.moveToFirst()){
                do{
                    val question: QuestionObject = QuestionObject()
                    question.qn = cursor.getInt(cursor.getColumnIndex(COL_QUESTION_NUMBER))
                    question.Year = cursor.getInt(cursor.getColumnIndex(COL_YEAR))
                    question.category1 = cursor.getString(cursor.getColumnIndex(COL_CAT1))
                    question.category2 = cursor.getString(cursor.getColumnIndex(COL_CAT2))
                    question.category3 = cursor.getString(cursor.getColumnIndex(COL_CAT3))
                    question.Question = cursor.getBlob(cursor.getColumnIndex(COL_QUESTION))
                    question.correctAnswer = cursor.getString(cursor.getColumnIndex(COL_CORRECT_ANSWER))
                    question.answerA = cursor.getString(cursor.getColumnIndex(COL_ANSWER_A))
                    question.answerB = cursor.getString(cursor.getColumnIndex(COL_ANSWER_B))
                    question.answerC = cursor.getString(cursor.getColumnIndex(COL_ANSWER_C))
                    question.answerD = cursor.getString(cursor.getColumnIndex(COL_ANSWER_D))
                    question.answerE = cursor.getString(cursor.getColumnIndex(COL_ANSWER_E))
                    Log.d(TAG, "Question added: year - " + question.Year + " number - " + question.qn)
                    questionList.add(question)
                }while(cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return questionList
    }

}