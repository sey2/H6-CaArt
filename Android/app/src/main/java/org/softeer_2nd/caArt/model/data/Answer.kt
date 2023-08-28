package org.softeer_2nd.caArt.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Answer(
    val answer: String,
    val code: String
):Parcelable