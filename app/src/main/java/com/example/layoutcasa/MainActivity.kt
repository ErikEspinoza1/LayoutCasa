package com.example.layoutcasa

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayout = findViewById<GridLayout>(R.id.gridServicios)

        val servicios = listOf(
            Servicio("Viaje", R.drawable.ic_viaje, "Oferta", 0xFF4CAF50.toInt()),
            Servicio("Comida", R.drawable.ic_comida, "Promoción", 0xFFFF9800.toInt()),
            Servicio("Explorar", R.drawable.ic_explorar, null, null),
            Servicio("Reserva", R.drawable.ic_reserva, null, null),
            Servicio("Dos ruedas", R.drawable.ic_dos_ruedas, "Oferta", 0xFF4CAF50.toInt()),
            Servicio("Por Horas", R.drawable.ic_por_horas, "Oferta", 0xFF4CAF50.toInt())
        )

        gridLayout.removeAllViews()
        for (servicio in servicios) {
            val item = layoutInflater.inflate(R.layout.item_servicio, gridLayout, false)

            val icono = item.findViewById<ImageView>(R.id.iconoServicio)
            val nombre = item.findViewById<TextView>(R.id.nombreServicio)
            val etiqueta = item.findViewById<TextView>(R.id.etiquetaServicio)

            icono.setImageResource(servicio.icono)
            nombre.text = servicio.nombre

            if (servicio.etiqueta != null) {
                etiqueta.text = servicio.etiqueta
                etiqueta.visibility = TextView.VISIBLE
                servicio.colorEtiqueta?.let { etiqueta.setBackgroundColor(it) }
            } else {
                etiqueta.visibility = TextView.GONE
            }

            gridLayout.addView(item)
        }

        val botonInicio = findViewById<Button>(R.id.buttonInicio)
        botonInicio.setOnClickListener {
            // Aquí podrías cambiar los servicios o mostrar otra vista
        }
    }
}
