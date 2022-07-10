package yash.com.example.quiza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView



class LastPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_page)

        val plyName: TextView = findViewById(R.id.playerName)
        val plyScore: TextView = findViewById(R.id.playerScore)
        val btFinish: Button = findViewById(R.id.btnFinish)
        plyName.text = intent.getStringExtra(Constants.USER_NAME)

        val totQues = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val corAns = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        plyScore.text = "Your Score is ${corAns} out of ${totQues}"

        btFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}