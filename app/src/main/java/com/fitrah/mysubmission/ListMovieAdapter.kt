package com.fitrah.mysubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListMovieAdapter(private val listMovie: ArrayList<Movie>): RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgMovie: ImageView = itemView.findViewById(R.id.img_movie)
        val nameMovie: TextView = itemView.findViewById(R.id.tv_item_name)
        val ratingMovie: TextView = itemView.findViewById(R.id.tv_item_rating)
        val genreMovie: TextView = itemView.findViewById(R.id.tv_genre_movie)
        val durationMovie: TextView = itemView.findViewById(R.id.tv_duration)
        val shareMovie: ImageView = itemView.findViewById(R.id.action_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, rating, genre, durasi) = listMovie[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgMovie)

        holder.nameMovie.text = name
        holder.ratingMovie.text = rating
        holder.genreMovie.text = genre
        holder.durationMovie.text = durasi

        holder.shareMovie.setOnClickListener {
            val intent = Intent()

            intent.action = Intent.ACTION_SEND

            val imgUrl = photo
            val textName = name
            val textRating = rating
            val textGenre = genre
            val textDuration = durasi
            val texToShare = "$imgUrl\nName Movie: $textName\nRating: $textRating\nGenre: $textGenre\nDuration: $textDuration"

            intent.putExtra(Intent.EXTRA_TEXT, texToShare )
            intent.type = "text/plain"
            holder.itemView.context.startActivity(Intent(Intent.createChooser(intent, "Bagikan")))
        }

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMovieActivity::class.java)
            intentDetail.putExtra("data_movie", listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}