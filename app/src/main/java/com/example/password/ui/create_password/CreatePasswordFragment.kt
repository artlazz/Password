package com.example.password.ui.create_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.password.R
import com.example.password.view.PasswordInputView

class CreatePasswordFragment : Fragment() {

    companion object {
        fun newInstance() = CreatePasswordFragment()
    }

    private lateinit var viewModel: CreatePasswordViewModel
    private var createdPassword: String = ""

    private lateinit var passwordInputView: PasswordInputView
    private lateinit var tvHint: TextView

    private val listener: PasswordInputView.OnPasswordInteractionListener =
        object : PasswordInputView.OnPasswordInteractionListener {
            override fun onEnter(password: String) {
                // TODO check is this is first enter, then user must enter pass again

                if (createdPassword.isEmpty()) {
                    createdPassword += password
                    tvHint.text = "Repeat entered password"
                }
                else {
                    if (createdPassword != password) passwordInputView.setError("Wrong repeat password")
                    else {
                        // TODO save the password, and continue

                        Toast.makeText(requireContext(), "password is saved", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onForgot() {
                // TODO nothing to do here
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreatePasswordViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        setListeners()
    }

    private fun init(view: View) {
        passwordInputView = view.findViewById(R.id.piv_create_password)
        tvHint = view.findViewById(R.id.tv_create_password_hint)
    }

    private fun setListeners() {
        passwordInputView.setOnPasswordInteractionListener(listener)
    }
}