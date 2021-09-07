package com.victorteka.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = false)
internal abstract class NYTArticlesDB : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object {
        var database: NYTArticlesDB? = null

        fun getInstance(context: Context): NYTArticlesDB {
            database?.let {
                return it
            }
            return Room.databaseBuilder(context, NYTArticlesDB::class.java, "food_db")
                .build()
        }
    }
}