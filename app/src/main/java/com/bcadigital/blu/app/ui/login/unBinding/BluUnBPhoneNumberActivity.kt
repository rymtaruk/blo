package com.bcadigital.blu.app.ui.login.unBinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.bcadigital.blu.R
import com.bcadigital.blu.app.ui.otp.BluOtpActivity
import com.bcadigital.blu.databinding.ActivityBluUnBphoneNumberBinding

//* UnB = Unbinding
class BluUnBPhoneNumberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBluUnBphoneNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluUnBphoneNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tilPhoneNumber.requestFocus()
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.tilPhoneNumber, InputMethodManager.SHOW_IMPLICIT)

        binding.etPhoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = s.toString()
                if (text.isNotEmpty()) {
                    binding.btnNext.setBackgroundResource(R.drawable.bg_button_corner_blue)
                } else {
                    binding.btnNext.setBackgroundResource(R.drawable.bg_button_corner_grey)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.btnNext.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            binding.btnNext.visibility = View.GONE
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                binding.pbLoading.visibility = View.GONE
                binding.btnNext.visibility = View.VISIBLE
                startActivity(Intent(it.context, BluOtpActivity::class.java))
            }, 500)
        }
    }
}