package com.example.concatadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ItemFooterBinding

class FooterAdapter : RecyclerView.Adapter<FooterAdapter.ViewHolder>() {

    companion object {
        const val TYPE = 4
    }

    private var remaining: List<Int> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return remaining.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(remaining[position])
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    fun updateRemaining(value: Int) {
        this.remaining = listOf(value)
    }

    class ViewHolder(
        private val binding: ItemFooterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(value: Int) {
            binding.tvRemaining.text = "คงเหลือ $value"
        }
    }
}