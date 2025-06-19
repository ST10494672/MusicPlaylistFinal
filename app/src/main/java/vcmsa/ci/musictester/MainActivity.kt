package vcmsa.ci.musictester

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    class SecondActivity {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etArtist = findViewById<EditText>(R.id.etArtist)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val etComment = findViewById<EditText>(R.id.etComment)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnGoToSecond = findViewById<Button>(R.id.btnGoToSecond)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        // Save Playlist Data
        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val artist = etArtist.text.toString().trim()
            val rating = ratingBar.rating.toDouble()
            val comment = etComment.text.toString().trim()

            if (title.isEmpty()) {
                etTitle.error = "Title is required"
                return@setOnClickListener
            }

            // Show success message
            tvMessage.text =
                "Saved:\nTitle: $title\nArtist: $artist\nRating: $rating\nComment: $comment"

            // Store in a list or pass to SecondActivity
            val playlistItem = mapOf(
                "title" to title,
                "artist" to artist,
                "rating" to rating,
                "comment" to comment)

        }
    }
}