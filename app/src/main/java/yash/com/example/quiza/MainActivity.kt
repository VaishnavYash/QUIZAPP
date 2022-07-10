package yash.com.example.quiza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val srtbutton: Button = findViewById(R.id.firstbutton)
        val txtname: TextView = findViewById(R.id.txtname)
        srtbutton.setOnClickListener {
            if(txtname.text.isEmpty()){
                Toast.makeText(this,"Please Enter a Name", Toast.LENGTH_LONG).show()
            }else {
                val intent = Intent(this, QuizQuestion::class.java)
                intent.putExtra(Constants.USER_NAME, txtname.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}