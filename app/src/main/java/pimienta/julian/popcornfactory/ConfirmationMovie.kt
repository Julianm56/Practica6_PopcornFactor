package pimienta.julian.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConfirmationMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_movie)

        var bundle = intent.extras
        var seatNumber = -1
        var movieTitle = ""

        if (bundle != null) {
            seatNumber = bundle.getInt("seatNumber")
            movieTitle = bundle.getString("titlemovie").toString()

        }

        val seatSelected = findViewById<TextView>(R.id.selected_seat)
        val movieSelected = findViewById<TextView>(R.id.movie_selected)
        val btnConfirm = findViewById<Button>(R.id.btn_final)
        val clientName = findViewById<EditText>(R.id.Client_name)

        seatSelected.setText("Selected seat: ${seatNumber}")
        movieSelected.setText("Movie seat: ${movieTitle}")

        btnConfirm.setOnClickListener {
            if (clientName.text.isNotEmpty() && clientName.text.isNotBlank()){
                var intent: Intent = Intent()

                intent.putExtra("seatReserved", seatNumber)

                Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show()

                setResult(RESULT_OK, intent)

                finish()

            } else {
                Toast.makeText(this, "Please enter your name to continue", Toast.LENGTH_LONG).show()
            }

        }


    }
}