package com.example.flixter

import org.json.JSONArray

data class Movie(
    val title: String,
    val overview: String,
    private val posterPath: String
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.get("title").toString(),
                        movieJson.get("overview").toString(),
                        movieJson.get("poster_path").toString()
                    )
                )
            }

            return movies
        }
    }
}