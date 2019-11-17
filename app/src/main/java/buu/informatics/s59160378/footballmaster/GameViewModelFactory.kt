package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GameViewModelFactory (
    private val arrQuestions:Array<Question>,
    private val yourName:String)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(arrQuestions,yourName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

