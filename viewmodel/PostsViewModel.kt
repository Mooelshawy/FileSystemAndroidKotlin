package com.omran.accesssystemfile.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omran.accesssystemfile.api.ApiClient
import com.omran.accesssystemfile.api.PostInterface
import com.omran.accesssystemfile.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel : ViewModel() {

    val  postList = MutableLiveData<DataModel>()



    fun getPost(){
        // define api client for invoke interface
        val request = ApiClient.getApiCall(PostInterface::class.java)
        val call = request.getPosts()

        //call back take list of model  because my interface return list of model
        call.enqueue(object : Callback<DataModel>{

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.d("body", "onFailure:   Loading is failure ")
            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {

                postList.value = response.body()


            }
        })
    }
}