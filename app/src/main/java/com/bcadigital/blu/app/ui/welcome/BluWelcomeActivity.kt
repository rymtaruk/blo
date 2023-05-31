package com.bcadigital.blu.app.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcadigital.blu.app.model.WelcomeCarouselModel
import com.bcadigital.blu.app.ui.login.unBinding.BluUnBPhoneNumberActivity
import com.bcadigital.blu.app.ui.welcome.carousel.BluWelcomeAdapter
import com.bcadigital.blu.databinding.ActivityBluWelcomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class BluWelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBluWelcomeBinding
    private lateinit var carouselAdapter: BluWelcomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carouselAdapter = BluWelcomeAdapter()
        val items = ArrayList<WelcomeCarouselModel>()
        items.add(
            WelcomeCarouselModel(
                "Mulai Langkahmu Bareng blu!",
                "Untuk hidup lebih mudah dan terkoneksi, apa pun tujuanmu",
                "",
                "#33CDCF"
            )
        )
        items.add(
            WelcomeCarouselModel(
                "Nabung Bebas Biaya Admin ✨",
                "Mulai langkahmu, nabung dengan bunga 3%. Bayar-bayar juga lebih gampang!",
                "",
                "#283FFF"
            )
        )
        items.add(
            WelcomeCarouselModel(
                "Atur Keuangan Enaknya Barengan.",
                "Pakai bluGether, urusan patungan, beres~",
                "",
                "#0E761F"
            )
        )
        items.add(
            WelcomeCarouselModel(
                "Pakai blu, Enjoy bluRewards!",
                "Nikmati bebas biaya transfer sampai cashback dengan terus bertransaksi pakai blu! \n *Selengkapnya cek Fees & Retes",
                "",
                "#283FFF"
            )
        )
        carouselAdapter.items = items
        binding.vpWelcome.adapter = carouselAdapter

        TabLayoutMediator(binding.tlDotWelcome, binding.vpWelcome) { _, _ ->

        }.attach()

        binding.btnStart.setOnClickListener {
            startActivity(Intent(it.context, BluUnBPhoneNumberActivity::class.java))
        }
    }
}