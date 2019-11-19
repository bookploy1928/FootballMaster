package buu.informatics.s59160378.footballmaster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160378.footballmaster.Database.ScoreDatabaseDao
import kotlinx.coroutines.*

class ScoreViewModel (var yourName:String, var score:Int,
                      val database: ScoreDatabaseDao,
                      application: Application): AndroidViewModel(application) {

    var scoreString = score.toString()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        uiScope.launch {
            storeScore(yourName, score)
        }

    }
    private suspend fun storeScore(name: String, score: Int) {
        return withContext(Dispatchers.IO) {
            val newScore = Score()
            newScore.name = name
            newScore.score = score
            database.insert(newScore)
//            database.clear()
        }
    }



}