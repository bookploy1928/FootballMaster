package buu.informatics.s59160378.footballmaster

import android.app.Application
import timber.log.Timber

class FootballMasterApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}