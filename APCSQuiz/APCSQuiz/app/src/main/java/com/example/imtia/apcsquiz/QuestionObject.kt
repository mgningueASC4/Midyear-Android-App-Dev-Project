package com.example.imtia.apcsquiz

import java.sql.Blob

class QuestionObject {
    var qn: Int = 0
    var category1: String ?= null
    var category2: String ?= null
    var category3: String ?= null
    var Year: Int = 0
    lateinit var Question: Blob
    var correctAnswer: String ?= null
    var answerA: String ?= null
    var answerB: String ?= null
    var answerC: String ?= null
    var answerD: String ?= null
    var answerE: String ?= null

    constructor(qn:Int, c1:String, c2:String, c3:String, year:Int, question:Blob, cA:String, aA:String, aB:String, aC:String, aD:String, aE:String){

        this.qn = qn
        this.category1 = c1
        this.category2 = c2
        this.category3 = c3
        this.Year = year
        this.Question = question
        this.correctAnswer = cA
        this.answerA = aA
        this.answerB = aB
        this.answerC = aC
        this.answerD = aD
        this.answerE = aE
    }


}