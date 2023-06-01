package com.bcadigital.blu.app.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.bcadigital.blu.databinding.ViewBluFavoriteBinding

class BluFavoriteView(context: Context, attr: AttributeSet) : LinearLayout(context, attr) {
    private var binding: ViewBluFavoriteBinding
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewBluFavoriteBinding.inflate(inflater, this, false)

    }
}