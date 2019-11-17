package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreViewModelFactory (
    private val finalScore: Int,
    private val yourName:String)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore,yourName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}