package com.module.footballscores.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.module.footballscores.databinding.ItemMatchResultsFragmentBinding
import com.module.footballscores.model.MatchResults

class MatchResultsAdapter(private val onClickListener : ( MatchResults) -> Unit) :
    ListAdapter<MatchResults, MatchResultsAdapter.MatchResultHolder>(MovieRecDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchResultHolder {
        return MatchResultHolder(ItemMatchResultsFragmentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MatchResultHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.invoke(item)
        }

        holder.bind(item)
    }

    inner class MatchResultHolder(private val binding: ItemMatchResultsFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(matchResult: MatchResults) {

//            Glide.with(binding.root.context)
//                .load("$IMAGE_BASE_PATH${matchResult.backdropPath}")
//                .apply(
//                    RequestOptions()
//                        .placeholder(R.drawable.loading_animation)
//                        .error(R.drawable.ic_broken_image)
//                )
//                .into(binding.posterImage)
            binding.matchResult = matchResult

        }
    }
}

class MovieRecDiffCallback : DiffUtil.ItemCallback<MatchResults>() {
    override fun areItemsTheSame(oldItem: MatchResults, newItem: MatchResults): Boolean {
        return oldItem.date == newItem.date
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MatchResults, newItem: MatchResults): Boolean {
        return oldItem == newItem
    }
}