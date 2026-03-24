package com.example.clicker31

import android.content.Context
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("game_prefs")

class GameStorage(private val context: Context) {
    private val SCORE_KEY = doublePreferencesKey("score")
    suspend fun getScore() : Double{
        return context.dataStore.data.map { prefs->
            prefs[SCORE_KEY]?.toDouble() ?: 0.0
        }.first()
    }
    suspend fun saveScore(score: Double){
        context.dataStore.edit { prefs->
            prefs[SCORE_KEY] = score
        }
    }
}