package pimienta.julian.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras

        if (bundle != null) {
            var imagen_pelicula = findViewById(R.id.pelicula_imagen) as ImageView
            var titulo_pelicula = findViewById(R.id.nombre_pelicula) as TextView
            var desc_pelicula = findViewById(R.id.pelicula_desc) as TextView

            imagen_pelicula.setImageResource(bundle.getInt("header"))
            titulo_pelicula.setText(bundle.getString("titulo"))
            desc_pelicula.setText(bundle.getString("sinopsis"))
        }
    }
}