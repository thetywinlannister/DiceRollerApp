package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            //Toast.makeText(this, "vroom vroom bitches", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.text = "Reset"
        resetButton.setOnClickListener {
            resetDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun resetDice() {
        diceImage.setImageResource(R.drawable.dice_1)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        if (randomInt==6) {
            Toast.makeText(this, "You got a 6! Take another turn", Toast.LENGTH_LONG).show()
        }
//        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
    }
}