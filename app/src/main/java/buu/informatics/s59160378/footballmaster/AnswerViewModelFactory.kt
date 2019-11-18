package buu.informatics.s59160378.footballmaster

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AnswerViewModelFactory (
    private val answerFact: String,
    private val correction: String,
    private val arrQuestion: Array<Question>,
    private val yourName:String,
    private val score:Int)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnswerViewModel::class.java)) {
            return AnswerViewModel(answerFact, correction,arrQuestion,yourName,score) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
