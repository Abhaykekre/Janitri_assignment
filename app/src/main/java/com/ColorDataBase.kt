package com

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ColorItem::class], version = 1)
abstract class ColorDatabase : RoomDatabase() {
    abstract fun colorsDao(): ColorsDAO
}