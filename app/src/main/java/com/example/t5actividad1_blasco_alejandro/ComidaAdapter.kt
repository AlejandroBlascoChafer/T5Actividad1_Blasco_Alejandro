package com.example.t5actividad1_blasco_alejandro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t5actividad1_blasco_alejandro.databinding.ItemComidaBinding


class ComidaAdapter(private val comidas: List<Comida>, private val listener: OnClickListener):RecyclerView.Adapter<ComidaAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemComidaBinding.bind(view)

        fun setListener(comida: Comida) {
            binding.root.setOnClickListener { listener.onClick(comida) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comida, parent, false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comida = comidas.get(position)
        with(holder){
            setListener(comida)
            binding.nombre.text = comida.getNombre()
            binding.pais.text = comida.getPais()
            binding.ivIconoComida.setImageResource(comida.getIcon())
        }
    }

    override fun getItemCount(): Int = comidas.size
}