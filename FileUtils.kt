package com.omran.accesssystemfile

import android.content.Context
import android.os.Environment
import java.io.File

const  val imageFormat = "JPEG"
class FileUtils {

    /*
    * this code from meduim for read file from assets folder and save it the app folder directory
    * we create this class for create a file and save bitmap in it from internal file in app
    * //////////////////////////////////////////////////////////////////////////////////////
    * the same code using in save file in external file but have some diffenets like |shoud have permisition in mainfiest file
    * 
    * */
    fun  createFileInStorage(context: Context, fileName:String):File?{
        
        val timestamp:String = System.currentTimeMillis()
                .toString() + imageFormat   
        
        val name = if(fileName.length == 0 ) timestamp else fileName

        return File(getAppFileDir(context),name)

    }


    fun createFileInExternalStorage(context:Context , fileName: String):File?{
        val timestamp:String = System.currentTimeMillis()
                .toString() + imageFormat
        val name = if(fileName.length == 0 ) timestamp else fileName
        return File(getAppExternalFileDir(context),name)
    }

    private fun getAppExternalFileDir(context: Context): File? {
        val file =context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (file != null && !file.exists()){
            file.mkdirs()
        }
        return file
    }

    private fun getAppFileDir(context: Context): File? {
        val file =context.filesDir
        if (file != null && !file.exists()){
            file.mkdirs()
        }
        return file
    }


}