package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import timber.log.Timber


class AnswerViewModel (val answerFact: String, val correction: String,val arrQuestion: Array<Question>,var yourName:String,var score:Int ) : ViewModel() {

    var resultString: String
    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    init {
        if (correction == "correct") {
            resultString = "Correct^^"
            score+=10
        } else if(correction == "timeUp") {
            resultString = "TimeUP!!"
        }else {
            resultString = "InCorrect!!"
        }

        _showSnackbarEvent.value = true
    }



    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }
}