package com.example.movieapp.movieRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.movieapp.data.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(com.example.movieapp.movieRoom.TypeConverters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile

        private var INSTANCE: MovieDatabase? = null
        fun getDatabase(context: Context): MovieDatabase {
            return INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_table"
                ) .fallbackToDestructiveMigration().build()
                INSTANCE = db
                db
            }
        }
    }
}