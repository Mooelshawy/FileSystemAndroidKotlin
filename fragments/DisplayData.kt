package com.omran.accesssystemfile.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.omran.accesssystemfile.App
import com.omran.accesssystemfile.R
import com.omran.accesssystemfile.SendingData
import com.omran.accesssystemfile.adapter.PostAdapter
import com.omran.accesssystemfile.databinding.FragmentDisplayDataBinding
import com.omran.accesssystemfile.model.DataModel
import com.omran.accesssystemfile.usingfile.ReadWriteFile
import com.omran.accesssystemfile.viewmodel.PostsViewModel
import java.io.File

class DisplayData : Fragment() {


    private lateinit var binding: FragmentDisplayDataBinding
    private val viewmodel = PostsViewModel()
    private val myAdapter = PostAdapter(App.instance())
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDisplayDataBinding.inflate(inflater, container, false)

        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.getPost()

        binding.postList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewmodel.postList.observe(viewLifecycleOwner, Observer<DataModel> {


            myAdapter.PostArrayList = it
            binding.postList.adapter = myAdapter


        })

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_displayData_to_writeToFile)
            SendingData.comeFromHere = false


            //create file in /data/data/file /"fileName".txt
            val filename = "myfile.txt"
            if (context?.getFileStreamPath(filename)?.exists() == true){
                context?.openFileOutput(filename,Context.MODE_APPEND)

                Log.d("11111", "onViewCreated: ${context?.getFileStreamPath(filename)?.exists()}")
            }
            else{
                context?.openFileOutput(filename,Context.MODE_PRIVATE)
                Log.d("888888", "onViewCreated: ${context?.getFileStreamPath(filename)?.exists()}")
            }


            ReadWriteFile.writeToFile(myAdapter.PostArrayList.toString(), App.instance(), filename)

            Toast.makeText(App.instance(),"Data Ready Write to $filename file"  ,Toast.LENGTH_SHORT).show()

        }


    }



}
