package buu.informatics.s59160378.footballmaster.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import buu.informatics.s59160378.footballmaster.Score

@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract val scoreDatabaseDao: ScoreDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}