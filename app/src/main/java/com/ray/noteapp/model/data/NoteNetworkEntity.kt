package com.ray.noteapp.model.data
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data coming from Network
data class NoteNetworkEntity(

    @SerializedName("pk")
    @Expose
    var id:Int,

    @SerializedName("title")
    @Expose
    var title:String,

    @SerializedName("time_update")
    @Expose
    var time_update:Int,

    @SerializedName("body")
    @Expose
    var body:String,
){}