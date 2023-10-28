package com.fitrah.mysubmission

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvMovie: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileMe: ImageView = findViewById(R.id.profile)
        profileMe.setOnClickListener(this)

        rvMovie = findViewById(R.id.rv_movie)
        rvMovie.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()


    }

    override fun onClick(view: View) {
        if (view.id == R.id.profile) {
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataPhoto = resources.getStringArray(R.array.list_url_photo)
        val dataName = resources.getStringArray(R.array.list_name_movie)
        val dataRating = resources.getStringArray(R.array.list_rating_movie)
        val dataGenre = resources.getStringArray(R.array.list_genre_movie)
        val dataDurasi = resources.getStringArray(R.array.list_durasi_movie)
        val datasutradara = resources.getStringArray(R.array.list_sutradara_movie)
        val dataYear = resources.getStringArray(R.array.list_years_movie)
        val dataRatingUsia = resources.getStringArray(R.array.list_rating_usia)
        val dataStoryline = resources.getStringArray(R.array.list_storyline_movie)
        val listMovie = ArrayList<Movie>()

        for (i in dataGenre.indices) {
            val movie = Movie(dataPhoto[i], dataName[i], dataRating[i], dataGenre[i], dataDurasi[i], datasutradara[i], dataYear[i], dataRatingUsia[i], dataStoryline[i])
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovie.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovie.adapter = listMovieAdapter
    }
}
