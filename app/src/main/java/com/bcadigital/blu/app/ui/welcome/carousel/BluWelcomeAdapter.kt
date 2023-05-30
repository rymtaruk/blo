package com.bcadigital.blu.app.ui.welcome.carousel

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcadigital.blu.app.model.WelcomeCarouselModel
import com.bcadigital.blu.databinding.ItemBluWelcomeBinding

class BluWelcomeAdapter : RecyclerView.Adapter<BluWelcomeAdapter.ViewHolder>() {
    var items: List<WelcomeCarouselModel>? = null
        set(value) {
            if (field == null){
                field = value
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBluWelcomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items?.get(position)
        holder.binding.tvTitle.text = data?.title
        holder.binding.tvDescription.text = data?.description
        holder.binding.root.setBackgroundColor(Color.parseColor(data?.backgroundColor))
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items!!.size
        } else {
            return 0
        }
    }

    inner class ViewHolder(view: ItemBluWelcomeBinding): RecyclerView.ViewHolder(view.root) {
        val binding = view
    }
}