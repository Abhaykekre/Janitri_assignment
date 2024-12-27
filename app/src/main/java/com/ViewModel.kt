package com

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlin.random.Random

class MyViewModel(private val database: ColorDatabase, private val context: Context) : ViewModel() {
    private val db = Firebase.firestore
    private val unsyncedColors = mutableListOf<ColorItem>()

    fun getAllColors(callback: (List<ColorItem>) -> Unit) {
        viewModelScope.launch {
            val colors = database.colorsDao().getAllColors()
            callback(colors)
        }
    }

    fun addColor() {
        viewModelScope.launch {
            val newColor = generateRandomColor()
            unsyncedColors.add(newColor)
            database.colorsDao().insertColor(newColor)
        }
    }

    private fun generateRandomColor(): ColorItem {
        val red = Random.nextInt(0, 256)
        val green = Random.nextInt(0, 256)
        val blue = Random.nextInt(0, 256)
        val code = String.format("#%02X%02X%02X", red, green, blue)
        val time = System.currentTimeMillis()

        return ColorItem(code = code, time = time)
    }





    fun syncColors() {
        val db = Firebase.firestore
        fun syncColors() {
            val db = Firebase.firestore
            db.collection("cities").document("LA")
                .set("colorItem")
                .addOnSuccessListener { }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error writing document", e)
                }

        }


    }

}