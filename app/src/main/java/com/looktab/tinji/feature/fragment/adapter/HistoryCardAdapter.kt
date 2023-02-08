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
import com.looktab.tinji.databinding.ItemHistoryBinding
import com.looktab.tinji.feature.model.History

class HistoryCardAdapter : ListAdapter<History, HistoryCardAdapter.HistoryCardViewHolder>
    (HistoryCardComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryCardViewHolder {
        return HistoryCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HistoryCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class HistoryCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemHistoryBinding? =
            DataBindingUtil.bind(itemView)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: History) {
            binding?.model = item

            binding?.reviewWrite?.setOnClickListener {
                mListener?.onItemClick(item.name)
            }
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

object HistoryCardComparator : DiffUtil.ItemCallback<History>() {
    override fun areItemsTheSame(
        oldItem: History,
        newItem: History
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: History,
        newItem: History
    ): Boolean {
        return oldItem == newItem
    }
}