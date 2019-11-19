package buu.informatics.s59160378.footballmaster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160378.footballmaster.Database.ScoreDatabaseDao
import kotlinx.coroutines.*
import timber.log.Timber

class ScoreboardViewModel (val database: ScoreDatabaseDao,
application: Application
): AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var scoreList = database.getAllScore()
}
