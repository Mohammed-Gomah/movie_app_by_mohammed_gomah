package com.example.movieapp.movieRoom

import androidx.room.TypeConverter
import com.example.movieapp.data.Country
import com.example.movieapp.data.Externals
import com.example.movieapp.data.Image
import com.example.movieapp.data.Links
import com.example.movieapp.data.Network
import com.example.movieapp.data.Rating
import com.example.movieapp.data.Schedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromListString(value: List<String>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toString(value: String?): List<String>? {
        val listItem = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listItem)
    }

    @TypeConverter
    fun fromImage(value: Image?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toImage(value: String?): Image? {
        return gson.fromJson(value, Image::class.java)
    }

    @TypeConverter
    fun fromLinks(value: Links?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toLinks(value: String?): Links? {
        return gson.fromJson(value, Links::class.java)
    }

    @TypeConverter
    fun fromRating(value: Rating?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toRating(value: String?): Rating? {
        return gson.fromJson(value, Rating::class.java)
    }

    @TypeConverter
    fun fromExternals(value: Externals?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toExternals(value: String?): Externals? {
        return gson.fromJson(value, Externals::class.java)
    }

    @TypeConverter
    fun fromCountry(value: Country?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toCountry(value: String?): Country? {
        return gson.fromJson(value, Country::class.java)
    }

    @TypeConverter
    fun fromAny(value: Any?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toAny(value: String): Any? {
        return gson.fromJson(value, Any::class.java)
    }

    @TypeConverter
    fun fromNetwork(value: Network?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toNetwork(value: String?): Network? {
        return gson.fromJson(value, Network::class.java)
    }

    @TypeConverter
    fun fromSchedule(value: Schedule?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toSchedule(value: String?): Schedule? {
        return gson.fromJson(value, Schedule::class.java)
    }
}



