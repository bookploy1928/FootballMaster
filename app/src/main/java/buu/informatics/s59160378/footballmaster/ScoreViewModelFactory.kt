package buu.informatics.s59160378.footballmaster

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160378.footballmaster.Database.ScoreDatabaseDao



class ScoreViewModelFactory (
    private val yourName:String,
    private val score:Int,
    private val dataSource: ScoreDatabaseDao,
    private val application: Application
)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(yourName,score,dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}