package com.omran.accesssystemfile.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.omran.accesssystemfile.R
import com.omran.accesssystemfile.SendingData
import com.omran.accesssystemfile.adapter.PostAdapter
import com.omran.accesssystemfile.databinding.FragmentMainHomeBinding
import com.omran.accesssystemfile.viewmodel.PostsViewModel

class MainHome : Fragment() {

    lateinit var MainBinding : FragmentMainHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        MainBinding = FragmentMainHomeBinding.inflate(inflater , container, false)

        val view = MainBinding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        MainBinding.loading.setOnClickListener {

            it.findNavController().navigate(R.id.action_mainHome_to_displayData)

        }

        MainBinding.writeToFile.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainHome_to_writeToFile)
            SendingData.comeFromHere = true



        }

        MainBinding.readFromFile.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainHome_to_readFromFile)
        }
    }

}