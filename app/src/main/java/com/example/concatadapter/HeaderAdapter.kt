package com.example.concatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ItemHeaderBinding

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {

    companion object {
        const val TYPE = 1
    }

    private var header: List<Int> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return header.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(header[position])
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    fun updateHeader(value: Int) {
        this.header = listOf(value)
        notifyItemChanged(header.size)
    }

    class ViewHolder(
        private val binding: ItemHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(value: Int) {
            binding.tvTotal.text = value.toString()
        }
    }
}