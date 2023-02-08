package com.looktab.tinji.feature.airdrop

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.looktab.tinji.R
import com.looktab.tinji.databinding.ItemCardBinding
import com.looktab.tinji.feature.model.Nft

class SwipeCardAdapter : ListAdapter<Nft, SwipeCardAdapter.SwipeCardViewHolder>
    (NftDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeCardViewHolder {
        return SwipeCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SwipeCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class SwipeCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemCardBinding? =
            DataBindingUtil.bind(itemView)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: Nft) {
            binding?.item = item
        }
    }

    interface OnItemClickListener {
        fun onItemClick(id: String)
    }

    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        mListener = listener
    }
}

object NftDiffCallback : DiffUtil.ItemCallback<Nft>() {
    override fun areItemsTheSame(
        oldItem: Nft,
        newItem: Nft
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Nft,
        newItem: Nft
    ): Boolean {
        return oldItem == newItem
    }
}