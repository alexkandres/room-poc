package com.example.roomwordsample

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.roomwordsample.Room.Word
import com.example.roomwordsample.Room.WordDao

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords() //LiveData runs Asynchronously, no @WorkerThread needed

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}