package com

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class ColorItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val time: Long,
    val sync: Boolean = false
)