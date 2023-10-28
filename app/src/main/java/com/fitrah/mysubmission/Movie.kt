package com.fitrah.mysubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val photo: String,
    val name: String,
    val rating: String,
    val genre: String,
    val durasi: String,
    val sutradata: String,
    val year: String,
    val ratingUsia: String,
    val storyline: String,
): Parcelable
