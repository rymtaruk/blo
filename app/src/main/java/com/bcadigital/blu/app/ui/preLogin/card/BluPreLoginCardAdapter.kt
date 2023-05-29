package com.bcadigital.blu.app.ui.preLogin.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcadigital.blu.app.model.CarouselModel
import com.bcadigital.blu.databinding.ItemBluPreLoginCardBinding

class BluPreLoginCardAdapter : RecyclerView.Adapter<BluPreLoginCardAdapter.ViewHolder>() {
    var items: List<CarouselModel>? = null
        set(value) {
            if (items == null){
                field = value
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBluPreLoginCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items?.get(position)

        holder.view.tvHeader.text = data?.titleHeader
    }

    override fun getItemCount(): Int {
        if (items == null){
            return 0
        } else {
            return items!!.size
        }
    }

    inner class ViewHolder(binding: ItemBluPreLoginCardBinding) : RecyclerView.ViewHolder(binding.root){
        val view = binding
    }
}