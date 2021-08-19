package com.omran.accesssystemfile.api

import com.omran.accesssystemfile.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {

    @GET("posts")
    //return call for enaue retrofit take list of model
    fun getPosts() : Call<DataModel>
}