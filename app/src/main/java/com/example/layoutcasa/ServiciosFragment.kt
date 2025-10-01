package com.example.layoutcasa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ServiciosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_servicios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val servicios = listOf(
            Servicio("Viaje", R.drawable.ic_viaje, "Oferta", 0xFF4CAF50.toInt()),
            Servicio("Comida", R.drawable.ic_comida, "Promoción", 0xFFFF9800.toInt()),
            Servicio("Explorar", R.drawable.ic_explorar, null, null),
            Servicio("Reserva", R.drawable.ic_reserva, null, null),
            Servicio("Dos ruedas", R.drawable.ic_dos_ruedas, "Oferta", 0xFF4CAF50.toInt()),
            Servicio("Por Horas", R.drawable.ic_por_horas, "Oferta", 0xFF4CAF50.toInt())
        )

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerServicios)
        recycler.layoutManager = GridLayoutManager(requireContext(), 3)
        recycler.adapter = ServicioAdapter(servicios)
    }
}