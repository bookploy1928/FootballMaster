package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber


class AnswerViewModel (val answerFact: String, val correction: String,val arrQuestion: Array<Question>,var yourName:String,var score:Int ) : ViewModel() {

    var resultString: String

    init {
        if (correction == "correct") {
            resultString = "Correct^^"
            score+=10
        } else if(correction == "timeUp") {
            resultString = "TimeUP!!"
        }else {
            resultString = "InCorrect!!"
        }
    }
}