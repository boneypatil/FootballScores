package com.module.footballscores.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.module.footballscores.databinding.ItemMatchResultsBinding
import com.module.footballscores.model.MatchResults

class MatchResultsAdapter(private val onClickListener : ( MatchResults) -> Unit) :
    ListAdapter<MatchResults, MatchResultsAdapter.MatchResultHolder>(MovieRecDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchResultHolder {
        return MatchResultHolder(ItemMatchResultsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MatchResultHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.invoke(item)
        }

        holder.bind(item)
    }

    inner class MatchResultHolder(private val binding: ItemMatchResultsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(matchResult: MatchResults) {
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