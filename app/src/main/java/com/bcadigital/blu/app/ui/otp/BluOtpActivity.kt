package com.bcadigital.blu.app.ui.otp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.bcadigital.blu.app.ui.password.BluPasswordActivity
import com.bcadigital.blu.app.utils.GenericKeyEvent
import com.bcadigital.blu.app.utils.GenericTextWatcher
import com.bcadigital.blu.databinding.ActivityBluOtpBinding

class BluOtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBluOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etOne.requestFocus()
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.etOne, InputMethodManager.SHOW_IMPLICIT)

        keyboardListener()
        binding.etFour.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = s.toString()
                if (text.length == 1) {
                    binding.pbLoading.visibility = View.VISIBLE
                    binding.llOtp.visibility = View.INVISIBLE
                    val handler = Handler(Looper.getMainLooper())
                    handler.postDelayed({
                        binding.pbLoading.visibility = View.INVISIBLE
                        binding.llOtp.visibility = View.VISIBLE

                        deleteFieldOtp()
                    }, 1000)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun keyboardListener() {
        binding.etOne.addTextChangedListener(GenericTextWatcher(binding.etOne, binding.etTwo, null))
        binding.etTwo.addTextChangedListener(
            GenericTextWatcher(
                binding.etTwo,
                binding.etThree, null
            )
        )
        binding.etThree.addTextChangedListener(
            GenericTextWatcher(
                binding.etThree,
                binding.etFour, null
            )
        )
        binding.etFour.addTextChangedListener(
            GenericTextWatcher(
                binding.etFour, null, object : GenericTextWatcher.CallbackWatcher {
                    override fun onFinish() {
                        val otp =
                            binding.etOne.text.toString() + binding.etTwo.text.toString() + binding.etThree.text.toString() + binding.etFour.text.toString()
                        Toast.makeText(this@BluOtpActivity, otp, Toast.LENGTH_LONG).show()
                        binding.pbLoading.visibility = View.VISIBLE
                        binding.llOtp.visibility = View.INVISIBLE
                        val handler = Handler(Looper.getMainLooper())
                        handler.postDelayed({
                            binding.pbLoading.visibility = View.INVISIBLE
                            binding.llOtp.visibility = View.VISIBLE

                            startActivity(Intent(this@BluOtpActivity, BluPasswordActivity::class.java))
                            deleteFieldOtp()
                        }, 300)
                    }
                }
            )
        )

        binding.etOne.setOnKeyListener(GenericKeyEvent(binding.etOne, null))
        binding.etTwo.setOnKeyListener(GenericKeyEvent(binding.etTwo, binding.etOne))
        binding.etThree.setOnKeyListener(GenericKeyEvent(binding.etThree, binding.etTwo))
        binding.etFour.setOnKeyListener(GenericKeyEvent(binding.etFour, binding.etThree))
    }


    fun deleteFieldOtp() {
        binding.etOne.text = null
        binding.etTwo.text = null
        binding.etThree.text = null
        binding.etFour.text = null
        binding.etOne.requestFocus()
    }
}