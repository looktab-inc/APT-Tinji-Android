package com.looktab.tinji.feature.nft

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
import com.looktab.tinji.databinding.ItemNftRowBinding
import com.looktab.tinji.feature.model.Nft

class NFTCardAdapter : ListAdapter<Nft, NFTCardAdapter.NftCardViewHolder>
    (NftDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftCardViewHolder {
        return NftCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_nft_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NftCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class NftCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemNftRowBinding? =
            DataBindingUtil.bind(itemView)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: Nft) {
            binding?.model = item
            binding?.layoutBastItem?.setOnClickListener {
                mListener?.onItemClick(item.id)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(id: Int)
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