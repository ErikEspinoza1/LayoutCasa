package com.example.layoutcasa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicioAdapter(private val lista: List<Servicio>) :
    RecyclerView.Adapter<ServicioAdapter.ServicioViewHolder>() {

    class ServicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icono: ImageView = itemView.findViewById(R.id.iconoServicio)
        val nombre: TextView = itemView.findViewById(R.id.nombreServicio)
        val etiqueta: TextView = itemView.findViewById(R.id.etiquetaServicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_servicio, parent, false)
        return ServicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServicioViewHolder, position: Int) {
        val servicio = lista[position]
        holder.icono.setImageResource(servicio.icono)
        holder.nombre.text = servicio.nombre

        if (servicio.etiqueta != null) {
            holder.etiqueta.text = servicio.etiqueta
            holder.etiqueta.visibility = View.VISIBLE
            holder.etiqueta.setBackgroundColor(servicio.colorEtiqueta ?: 0xFF888888.toInt())
        } else {
            holder.etiqueta.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = lista.size
}