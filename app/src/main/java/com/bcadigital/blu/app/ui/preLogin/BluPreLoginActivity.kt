package com.bcadigital.blu.app.ui.preLogin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcadigital.blu.app.model.CarouselModel
import com.bcadigital.blu.app.ui.passcode.BluPasscodeActivity
import com.bcadigital.blu.app.ui.preLogin.card.BluPreLoginCardAdapter
import com.bcadigital.blu.databinding.ActivityBluPreLoginBinding

class BluPreLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityBluPreLoginBinding
    lateinit var cardAdapter: BluPreLoginCardAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluPreLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        cardAdapter = BluPreLoginCardAdapter()
        binding.vpCard.apply {
            layoutManager = LinearLayoutManager(this@BluPreLoginActivity, LinearLayoutManager.HORIZONTAL, false)
            itemAnimator = null
        }

        val carouselModel = ArrayList<CarouselModel>()
        carouselModel.add(CarouselModel("","Reminder", "Ada 3 promo yang menarik buat kamu","#1316dd","","",""))
        carouselModel.add(CarouselModel("","Halo", "Ada 4 promo yang menarik buat kamu","#262260","","",""))
        carouselModel.add(CarouselModel("","Explore", "Ada 5 promo yang menarik buat kamu","#262260","","",""))
        cardAdapter.items = carouselModel
        binding.vpCard.adapter = cardAdapter

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(it.context, BluPasscodeActivity::class.java))
        }
    }
}