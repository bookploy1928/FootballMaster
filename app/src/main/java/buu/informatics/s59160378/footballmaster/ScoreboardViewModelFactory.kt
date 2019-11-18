package buu.informatics.s59160378.footballmaster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160378.footballmaster.Database.ScoreDatabaseDao
import kotlinx.coroutines.*


class ScoreboardViewModelFactory (
    private val dataSource: ScoreDatabaseDao,
    private val application: Application
)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreboardViewModel::class.java)) {
            return ScoreboardViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}