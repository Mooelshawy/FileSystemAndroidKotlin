package com.omran.accesssystemfile.model


import java.util.*

//to can using Parcelable use annotation @Parcelize
typealias DataModel = ArrayList<DataModelElement>

data class DataModelElement  (
        val albumID: Long,
        val id: Long,
        val title: String?,
        val url: String?,
        val thumbnailURL: String?
)

