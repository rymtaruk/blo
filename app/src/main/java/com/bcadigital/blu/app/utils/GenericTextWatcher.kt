package com.bcadigital.blu.app.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.bcadigital.blu.R

class GenericTextWatcher internal constructor(
    private val currentView: EditText,
    private val nextView: View?,
    private val callback: CallbackWatcher?
) :
    TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun afterTextChanged(s: Editable?) {
        val text = s.toString()
        when (currentView.id) {
            R.id.etOne -> if (text.length == 1) {
                nextView!!.requestFocus()
            }

            R.id.etTwo -> if (text.length == 1) {
                nextView!!.requestFocus()
            }

            R.id.etThree -> if (text.length == 1) {
                nextView!!.requestFocus()
            }

            R.id.etFour -> if (text.length == 1) {
                callback?.onFinish()
            }
            //You can use EditText4 same as above to hide the keyboard
        }

        when (currentView.id) {
            R.id.etOne -> if (text.length == 1) currentView.background =
                null else currentView.background =
                currentView.context.getDrawable(R.drawable.bg_ring_grey)

            R.id.etTwo -> if (text.length == 1) currentView.background =
                null else currentView.background =
                currentView.context.getDrawable(R.drawable.bg_ring_grey)

            R.id.etThree -> if (text.length == 1) currentView.background =
                null else currentView.background =
                currentView.context.getDrawable(R.drawable.bg_ring_grey)

            R.id.etFour -> if (text.length == 1) currentView.background =
                null else currentView.background =
                currentView.context.getDrawable(R.drawable.bg_ring_grey)
        }
    }

    interface CallbackWatcher {
        fun onFinish()
    }
}