package com.omran.accesssystemfile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omran.accesssystemfile.R
import com.omran.accesssystemfile.databinding.FragmentReadFromFileBinding
import com.omran.accesssystemfile.databinding.FragmentWriteToFileBinding
import com.omran.accesssystemfile.usingfile.ReadWriteFile

class ReadFromFile : Fragment() {

    lateinit var readBinding: FragmentReadFromFileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       readBinding = FragmentReadFromFileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return readBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        readBinding.screenFile.text = ReadWriteFile.readTextFile()

        readBinding.saveToExternalFile.setOnClickListener {

        }
    }

    private fun SaveToExternalFile(){

        
    }
}