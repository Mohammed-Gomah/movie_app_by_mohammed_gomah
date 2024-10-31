package com.example.movieapp.data


import com.google.gson.annotations.SerializedName
class ActorX : ArrayList<Cast>()

data class Cast(
    @SerializedName("character")
    val character: Character? = Character(),
    @SerializedName("person")
    val person: Person? = Person(),
    @SerializedName("self")
    val self: Boolean? = false,
    @SerializedName("voice")
    val voice: Boolean? = false
)


data class Character(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("_links")
    val links: Links? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)


data class Person(
    @SerializedName("birthday")
    val birthday: String? = "",
    @SerializedName("country")
    val country: Country? = Country(),
    @SerializedName("deathday")
    val deathday: Any? = Any(),
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: Image? = Image(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("updated")
    val updated: Int? = 0,
    @SerializedName("url")
    val url: String? = ""
)
data class ActorImage(
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("original")
    val original: String? = null
)