package com.example.concatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ItemHorizontalBinding

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    private var banners: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(banners[position])
    }

    fun updateBanner(banners: List<String>) {
        this.banners = banners
    }

    class ViewHolder(
        private val binding: ItemHorizontalBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {
            binding.tvText.text = text
        }
    }
}