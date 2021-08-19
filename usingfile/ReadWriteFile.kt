package com.omran.accesssystemfile.usingfile

import android.content.Context
import android.util.Log
import com.omran.accesssystemfile.App
import java.io.*

object ReadWriteFile {

    //code for write data for internal file
    fun writeToFile(data: String, context: Context, filename: String) {
        try {
            val outputStreamWriter = OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE))
            outputStreamWriter.write(data)
            outputStreamWriter.close()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed: $e")
        }
    }

    //code for read data from internal file or
    //raw resource file
    //data save in file come from api
    fun readTextFile() : StringBuilder{
        var string: String? = ""
        val stringBuilder = StringBuilder()
        val iss: InputStream = App.instance().openFileInput("myfile.txt")
        val reader = BufferedReader(InputStreamReader(iss))
        while (true) {
            try {
                string = reader.readLine()
                if (string == null) break
            } catch (e: IOException) {
                e.printStackTrace()
            }
            stringBuilder.append(string).append("\n")

        }
        iss.close()
        return stringBuilder

    }
}