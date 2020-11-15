package com.example.password.ui.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.password.R
import com.google.android.material.button.MaterialButton

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var btnCreate: MaterialButton
    private lateinit var btnEnter: MaterialButton

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreate = view.findViewById(R.id.btn_create_pass)
        btnEnter = view.findViewById(R.id.btn_enter_pass)

        btnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_createPasswordFragment)
        }
        btnEnter.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_enterPasswordFragment)
        }
    }

}