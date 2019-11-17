package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber


class AnswerViewModel (val answerFact: String, val correction: Boolean) : ViewModel() {

    var resultString: String

    init {
        Timber.i(correction.toString() + " test")

        if (correction) {
            resultString = "Correct^^"
        } else {
            resultString = "Incorrect!!"
        }
    }
}