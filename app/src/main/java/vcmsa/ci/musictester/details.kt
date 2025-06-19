package vcmsa.ci.musictester

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize Views
        val tvAverageRating = findViewById<TextView>(R.id.tvAverageRating)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnBackToMain = findViewById<Button>(R.id.btnBackToMain)
        val btnExitApp = findViewById<Button>(R.id.btnExitApp)

        //  playlist data for testing
        val playlist = listOf(
            mapOf("title" to "Song 1", "rating" to 4.5),
            mapOf("title" to "Song 2", "rating" to 3.0),
            mapOf("title" to "Song 3", "rating" to 5.0)
        )

        // Calculate Average Rating
        btnCalculate.setOnClickListener {
            var totalRating = 0.0
            for (song in playlist) {
                val rating = song["rating"] as? Double ?: 0.0
                totalRating += rating
            }

            val average = if (playlist.isNotEmpty()) totalRating / playlist.size else 0.0
            tvAverageRating.text = "Average Rating: ${"%.2f".format(average)}"
        }

        // Go Back to Main Screen
        btnBackToMain.setOnClickListener {
            finish()
        }

        // Exit App
        btnExitApp.setOnClickListener {
            finishAffinity() // Closes all activities
        }
    }
}