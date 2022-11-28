package com.example.simplegalleryhw

import java.io.Serializable

data class GalleryModel (
    val img : String,
    var select : Boolean
        ) : Serializable