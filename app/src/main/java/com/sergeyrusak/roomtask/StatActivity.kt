package com.sergeyrusak.roomtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room

class StatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)

        val moneyTV = findViewById<TextView>(R.id.money)
        val goodTV = findViewById<TextView>(R.id.good)
        val englishTV = findViewById<TextView>(R.id.english)
        val bestTV = findViewById<TextView>(R.id.best)
        val longestTV = findViewById<TextView>(R.id.longest)

        val db by lazy {
            Room.databaseBuilder(
                this,
                AppDatabase::class.java, "results.db"
            ).build()
        }



        db.resultsDao().getTotal().observe(this
        ) { results -> moneyTV.text = results.toString() }
        db.resultsDao().getGreaterAVG().observe(this
        ) { results -> goodTV.text = results.toString() }
        db.resultsDao().getEnglishNameCount().observe(this
        ) { results -> englishTV.text = results.toString() }
        db.resultsDao().getTopCompany().observe(this
        ) { results -> bestTV.text = results.toString() }
        db.resultsDao().getLongestCompany().observe(this
        ) { results -> longestTV.text = results.toString() }
    }
}