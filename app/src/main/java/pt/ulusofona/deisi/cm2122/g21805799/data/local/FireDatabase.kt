package pt.ulusofona.deisi.cm2122.g21805799.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pt.ulusofona.deisi.cm2122.g21805799.data.local.dao.FireOperations
import pt.ulusofona.deisi.cm2122.g21805799.data.local.entities.FireDB

@Database(entities = [FireDB::class], version = 4)
abstract class FireDatabase : RoomDatabase() {

    abstract fun fireOperations(): FireOperations

    companion object {

        private var instance: FireDatabase? = null

        fun getInstance(applicationContext: Context): FireDatabase {
            synchronized(this) {
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        applicationContext,
                        FireDatabase::class.java,
                        "fire_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance as FireDatabase
            }
        }
    }
}