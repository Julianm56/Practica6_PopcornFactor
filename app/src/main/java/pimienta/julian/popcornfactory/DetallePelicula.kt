package pimienta.julian.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""


        var button_pelicula = findViewById(R.id.buyTickets) as Button

        if (bundle != null) {
            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            var imagen_pelicula = findViewById(R.id.pelicula_imagen) as ImageView
            var titulo_pelicula = findViewById(R.id.nombre_pelicula) as TextView
            var desc_pelicula = findViewById(R.id.pelicula_desc) as TextView
            var seats_pelicula = findViewById(R.id.seatsLeft) as TextView

            imagen_pelicula.setImageResource(bundle.getInt("header"))
            titulo_pelicula.setText(bundle.getString("titulo"))
            desc_pelicula.setText(bundle.getString("sinopsis"))
            seats_pelicula.setText("$ns seats available ")
            id = bundle.getInt("pos")


            if(ns == 0){
                button_pelicula.isEnabled = false
            }else{
                button_pelicula.setOnClickListener{
                    var intent: Intent = Intent(this, SeatSelection::class.java)

                    intent.putExtra("id", id)
                    intent.putExtra("name", title)
                    startActivity(intent)
                }
            }
        }



    }
}