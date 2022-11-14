package com.example.diceapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.diceapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val images = arrayListOf<Int>(R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,
           R.drawable.dice5,R.drawable.dice6)
        binding.button.setOnClickListener{
            val mp:MediaPlayer
            mp = MediaPlayer.create(this, R.raw.dice_sound);
            mp.start()

            val randomNumbers =(1 until 6).random()
            val randomNumbers2 =(1 until 6).random()
            binding.dice1.setImageResource(images[randomNumbers])
            binding.dice2.setImageResource(images[randomNumbers2])
            YoYo.with(Techniques.Shake)
                .duration(400)
                .repeat(0)
                .playOn(binding.dice1)
            YoYo.with(Techniques.Shake)
                .duration(400)
                .repeat(0)
                .playOn(binding.dice2)

        }

    }
}