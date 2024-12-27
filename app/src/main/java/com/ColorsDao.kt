package com

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ColorsDAO {
    @Insert
    suspend fun insertColor(colorItem: ColorItem)

    @Query("SELECT * FROM colors")
    suspend fun getAllColors(): List<ColorItem>
}