package ru.netology.Nmedia


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*;


class MainActivityKAE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        likes?.setOnClickListener {
            likes?.setImageResource(R.drawable.ic_likes_24dp_red)
        }
    }
}