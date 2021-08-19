package com.omran.accesssystemfile.fragments

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.omran.accesssystemfile.App
import com.omran.accesssystemfile.FileUtils
import com.omran.accesssystemfile.R
import com.omran.accesssystemfile.SendingData

import com.omran.accesssystemfile.databinding.FragmentWriteToFileBinding
import com.omran.accesssystemfile.usingfile.ReadWriteFile
import com.omran.accesssystemfile.usingfile.ReadWriteFile.readTextFile
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class WriteToFile : Fragment() {


    lateinit var writeBinding: FragmentWriteToFileBinding



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        writeBinding = FragmentWriteToFileBinding.inflate(inflater, container, false)


        if (SendingData.comeFromHere == true){
            writeBinding.textView.visibility = View.GONE
            writeBinding.done.visibility = View.GONE
            writeBinding.dataToSaveInFile.visibility = View.VISIBLE
            writeBinding.saveToFile.visibility = View.VISIBLE
            SendingData.comeFromHere =false
        }
        else{
            writeBinding.dataToSaveInFile.visibility = View.GONE
            writeBinding.saveToFile.visibility = View.GONE
            writeBinding.textView.visibility = View.VISIBLE
            writeBinding.done.visibility = View.VISIBLE
        }
        // Inflate the layout for this fragment
        return writeBinding.root
    }



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        writeBinding.done.setOnClickListener {
            Toast.makeText(App.instance(),"Data Save "  ,Toast.LENGTH_SHORT).show()

            it.findNavController().navigate(R.id.action_writeToFile_to_mainHome)

        }
        writeBinding.textView.text = readTextFile()

        writeBinding.saveBitmap.setOnClickListener {
            saveFileInAppDirectory()
        }
        WriteDataFromUserInput()

    }

    private fun WriteDataFromUserInput(){
        writeBinding.saveToFile.setOnClickListener {
            ReadWriteFile.writeToFile(writeBinding.dataToSaveInFile.text.toString(),App.instance(),"myfile.txt")
            Toast.makeText(App.instance(),"Data Save "  ,Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("ResourceType")
    fun saveFileInAppDirectory(){
        val file = FileUtils().createFileInStorage(App.instance() ,"test.jpeg")

        Log.d("file path", "saveFileInAppDirectory: ${file!!.absolutePath}")

        if (!file.exists()){
            file.createNewFile()
                }

        val assetManger = App.instance().assets
        val bitmap:Bitmap
        val inputStream:InputStream
        val fileoutput :FileOutputStream

        try {
            inputStream = assetManger.open(getString(R.mipmap.mood_sample_round))
            fileoutput = FileOutputStream(file)
            bitmap = BitmapFactory.decodeStream(inputStream)

            bitmap.compress(Bitmap.CompressFormat.JPEG , 100 , fileoutput)
        }catch (e:Exception){
            e.stackTrace
        }
    }




}






