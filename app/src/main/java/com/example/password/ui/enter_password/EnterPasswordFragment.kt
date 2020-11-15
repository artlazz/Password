package com.example.password.ui.enter_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.password.R
import com.example.password.view.PasswordInputView

class EnterPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = EnterPasswordFragment()
    }

    private lateinit var viewModel: EnterPasswordViewModel

    private lateinit var passwordInputView: PasswordInputView

    private val listener: PasswordInputView.OnPasswordInteractionListener =
        object : PasswordInputView.OnPasswordInteractionListener {
            override fun onEnter(password: String) {
                // TODO check with saved pass, if correct continue, else passwordInputView.setError(errorText)

                if (true) {
                    Toast.makeText(requireContext(), "password is correct", Toast.LENGTH_SHORT).show()
                } else {
                    passwordInputView.setError("Wrong Pass")
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
        return inflater.inflate(R.layout.fragment_enter_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EnterPasswordViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        setListeners()
    }

    private fun init(view: View) {
        passwordInputView = view.findViewById(R.id.piv_enter_password)
    }

    private fun setListeners() {
        passwordInputView.setOnPasswordInteractionListener(listener)
    }


}