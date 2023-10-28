package com.fitrah.mysubmission

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val DATA_MOVIE = "data_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val dataMovie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Movie>("data_movie", Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Movie>("data_movie")
        }

        val imgMovieDetail: ImageView = findViewById(R.id.img_movie_detail)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailRating: TextView = findViewById(R.id.tv_detail_rating)
        val tvDetailGenre: TextView = findViewById(R.id.tv_detail_genre)
        val tvDetailDuration: TextView = findViewById(R.id.tv_detail_duration)
        val tvDetailTahun: TextView = findViewById(R.id.tv_detail_tahun)
        val tvDetailStoryline: TextView = findViewById(R.id.tv_storyline_movie)

        Glide.with(imgMovieDetail)
            .load(dataMovie?.photo)
            .into(imgMovieDetail)
        tvDetailName.text = dataMovie?.name
        tvDetailRating.text = dataMovie?.rating
        tvDetailGenre.text = dataMovie?.genre
        tvDetailDuration.text = dataMovie?.durasi
        tvDetailTahun.text = dataMovie?.year
        tvDetailStoryline.text = dataMovie?.storyline

    }
}