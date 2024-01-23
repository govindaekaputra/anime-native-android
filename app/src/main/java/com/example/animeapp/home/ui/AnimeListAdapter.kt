package com.example.animeapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animeapp.R
import com.example.animeapp.databinding.ItemAnimeBinding
import com.example.animeapp.home.domain.model.Anime

class AnimeListAdapter : ListAdapter<Anime, AnimeListAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = getItem(position)
        holder.binding.apply {
            anime.apply {
                Glide.with(holder.itemView.context)
                    .load(image).into(ivAnime)
                tvTitleAnime.text = title
                tvSynopsisAnime.text = synopsis
                tvTypeEpsAnime.text =
                    holder.itemView.context.getString(R.string.type_and_episodes_anime, type, eps)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Anime> =
            object : DiffUtil.ItemCallback<Anime>() {
                override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                    return oldItem.malId == newItem.malId
                }

                override fun areContentsTheSame(
                    oldItem: Anime,
                    newItem: Anime
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }
}