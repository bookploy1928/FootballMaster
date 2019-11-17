package buu.informatics.s59160378.footballmaster

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AnswerViewModelFactory (
    private val answerFact: String,
    private val correction: Boolean)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnswerViewModel::class.java)) {
            return AnswerViewModel(answerFact, correction) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
