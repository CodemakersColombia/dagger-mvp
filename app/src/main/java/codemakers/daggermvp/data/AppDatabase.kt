package codemakers.daggermvp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import codemakers.daggermvp.data.dao.TodoDao
import codemakers.daggermvp.data.model.Todo
import java.util.*


object Converters {
        @TypeConverter
        @JvmStatic
        fun dateToLong(date: Date): Long = date.time

        @TypeConverter
        @JvmStatic
        fun longToDate(timestamp: Long) = Date(timestamp)
}


@Database(entities = arrayOf(Todo::class),
        version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}