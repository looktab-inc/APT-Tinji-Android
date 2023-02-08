package com.looktab.tinji.feature.fragment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.looktab.tinji.R
import com.looktab.tinji.databinding.ItemWalletCardBinding
import com.looktab.tinji.feature.model.Token

class WalletCardAdapter : ListAdapter<Token, WalletCardAdapter.WalletCardViewHolder>
    (SubCategoryComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletCardViewHolder {
        return WalletCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wallet_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WalletCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class WalletCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemWalletCardBinding? =
            DataBindingUtil.bind(itemView)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: Token) {
            binding?.viewModel = item
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

object SubCategoryComparator : DiffUtil.ItemCallback<Token>() {
    override fun areItemsTheSame(
        oldItem: Token,
        newItem: Token
    ): Boolean {
        return oldItem.token == newItem.token
    }

    override fun areContentsTheSame(
        oldItem: Token,
        newItem: Token
    ): Boolean {
        return oldItem == newItem
    }
}