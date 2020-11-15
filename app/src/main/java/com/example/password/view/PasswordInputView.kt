package com.example.password.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.password.R
import com.google.android.material.button.MaterialButton

class PasswordInputView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0,
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private val NUMBER_1 = 1
    private val NUMBER_2 = 2
    private val NUMBER_3 = 3
    private val NUMBER_4 = 4
    private val NUMBER_5 = 5
    private val NUMBER_6 = 6
    private val NUMBER_7 = 7
    private val NUMBER_8 = 8
    private val NUMBER_9 = 9
    private val NUMBER_0 = 0

    private var password: String = ""
    private var listener: OnPasswordInteractionListener? = null

    private val ivPointNumber1: ImageView
    private val ivPointNumber2: ImageView
    private val ivPointNumber3: ImageView
    private val ivPointNumber4: ImageView
    private val btnNumber1: MaterialButton
    private val btnNumber2: MaterialButton
    private val btnNumber3: MaterialButton
    private val btnNumber4: MaterialButton
    private val btnNumber5: MaterialButton
    private val btnNumber6: MaterialButton
    private val btnNumber7: MaterialButton
    private val btnNumber8: MaterialButton
    private val btnNumber9: MaterialButton
    private val btnNumber0: MaterialButton
    private val btnNumberBack: MaterialButton
    private val btnNumberForgot: MaterialButton

    init {
        inflate(context, R.layout.password_input_layout, this)

        ivPointNumber1 = findViewById(R.id.iv_hidden_number_1)
        ivPointNumber2 = findViewById(R.id.iv_hidden_number_2)
        ivPointNumber3 = findViewById(R.id.iv_hidden_number_3)
        ivPointNumber4 = findViewById(R.id.iv_hidden_number_4)
        btnNumber1 = findViewById(R.id.btn_password_input_number_1)
        btnNumber2 = findViewById(R.id.btn_password_input_number_2)
        btnNumber3 = findViewById(R.id.btn_password_input_number_3)
        btnNumber4 = findViewById(R.id.btn_password_input_number_4)
        btnNumber5 = findViewById(R.id.btn_password_input_number_5)
        btnNumber6 = findViewById(R.id.btn_password_input_number_6)
        btnNumber7 = findViewById(R.id.btn_password_input_number_7)
        btnNumber8 = findViewById(R.id.btn_password_input_number_8)
        btnNumber9 = findViewById(R.id.btn_password_input_number_9)
        btnNumber0 = findViewById(R.id.btn_password_input_number_0)
        btnNumberBack = findViewById(R.id.btn_password_input_back)
        btnNumberForgot = findViewById(R.id.btn_password_input_forgot)

        setListeners()

        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.PasswordInputView, defStyle, 0)
            val btnTitle = typedArray.getString(R.styleable.PasswordInputView_button_text)
            val btnVisibility =
                typedArray.getBoolean(R.styleable.PasswordInputView_button_visibility, false)

            if (btnVisibility) {
                btnNumberForgot.visibility = View.VISIBLE
            } else {
                btnNumberForgot.visibility = View.GONE
            }

            btnNumberForgot.text = btnTitle

            typedArray.recycle()
        }
    }

    private fun setListeners() {
        btnNumber1.setOnClickListener { clickNumber(NUMBER_1) }
        btnNumber2.setOnClickListener { clickNumber(NUMBER_2) }
        btnNumber3.setOnClickListener { clickNumber(NUMBER_3) }
        btnNumber4.setOnClickListener { clickNumber(NUMBER_4) }
        btnNumber5.setOnClickListener { clickNumber(NUMBER_5) }
        btnNumber6.setOnClickListener { clickNumber(NUMBER_6) }
        btnNumber7.setOnClickListener { clickNumber(NUMBER_7) }
        btnNumber8.setOnClickListener { clickNumber(NUMBER_8) }
        btnNumber9.setOnClickListener { clickNumber(NUMBER_9) }
        btnNumber0.setOnClickListener { clickNumber(NUMBER_0) }

        btnNumberBack.setOnClickListener {
            if (password.isEmpty()) return@setOnClickListener
            password = password.dropLast(1)
            changePointColor(password.length, false)
        }
        btnNumberForgot.setOnClickListener {
            listener?.onForgot()
        }
    }

    private fun clickNumber(number: Int) {
        password += number
        changePointColor(password.length, true)

        if (password.length == 4) {
            listener?.onEnter(password)
            clearPass()
        }
    }

    private fun changePointColor(paintedCount: Int, animate: Boolean) {
        when (paintedCount) {
            0 -> {
                ivPointNumber1.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
                ivPointNumber2.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
                ivPointNumber3.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
                ivPointNumber4.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
            }
            1 -> {
                if (animate) animateView(ivPointNumber1)
                ivPointNumber1.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber2.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
                ivPointNumber3.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
                ivPointNumber4.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
            }
            2 -> {
                if (animate) animateView(ivPointNumber2)
                ivPointNumber1.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber2.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber3.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
                ivPointNumber4.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
            }
            3 -> {
                if (animate) animateView(ivPointNumber3)
                ivPointNumber1.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber2.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber3.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber4.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point
                    )
                )
            }
            4 -> {
                if (animate) animateView(ivPointNumber4)
                ivPointNumber1.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber2.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber3.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
                ivPointNumber4.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_point_painted
                    )
                )
            }
        }
    }

    private fun animateView(view: View) {
        view.animate()?.scaleXBy(0.08f)?.scaleYBy(0.08f)?.setDuration(100)
            ?.withEndAction {
                view.animate()?.scaleXBy(-0.08f)?.scaleYBy(-0.08f)?.setDuration(100)
                    ?.withEndAction {
                        enableButtons()
                    }
            }
        blockButtons()
    }

    private fun blockButtons() {
        btnNumber1.isClickable = false
        btnNumber2.isClickable = false
        btnNumber3.isClickable = false
        btnNumber4.isClickable = false
        btnNumber5.isClickable = false
        btnNumber6.isClickable = false
        btnNumber7.isClickable = false
        btnNumber8.isClickable = false
        btnNumber9.isClickable = false
        btnNumber0.isClickable = false
    }

    private fun enableButtons() {
        btnNumber1.isClickable = true
        btnNumber2.isClickable = true
        btnNumber3.isClickable = true
        btnNumber4.isClickable = true
        btnNumber5.isClickable = true
        btnNumber6.isClickable = true
        btnNumber7.isClickable = true
        btnNumber8.isClickable = true
        btnNumber9.isClickable = true
        btnNumber0.isClickable = true
    }

    fun clearPass() {
        password = ""
        changePointColor(0, false)
    }

    fun setError(errorText: String) {
        clearPass()
        Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
    }


    fun setOnPasswordInteractionListener(onPasswordInteractionListener: OnPasswordInteractionListener) {
        listener = onPasswordInteractionListener
    }

    interface OnPasswordInteractionListener {
        fun onEnter(password: String)
        fun onForgot()
    }
}
