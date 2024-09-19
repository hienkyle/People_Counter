package edu.tcu.hienminhdau.peoplecounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val countTextView = findViewById<TextView>(R.id.textview)
        val addButton = findViewById<Button>(R.id.add_button)
        var count = 0
        var toast: Toast? = null

        addButton.setOnClickListener{ _ ->
            count++
            countTextView.text = count.toString()
        }

        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener{ _ ->
            toast?.cancel()
            toast = Toast.makeText(this, "Count before reset was $count.", Toast.LENGTH_SHORT)
            toast?.show()

            count = 0
            countTextView.text = count.toString()
        }
    }
}