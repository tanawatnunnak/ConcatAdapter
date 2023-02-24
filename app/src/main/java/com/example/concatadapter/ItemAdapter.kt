package com.example.concatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ItemDetailBinding

class ItemAdapter(
    private val onClickItem: (position: Int, item: ItemModel) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    companion object {
        const val TYPE = 2
    }

    private var items: MutableList<ItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], onClickItem)
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    fun setItems(items: List<ItemModel>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    fun update(position: Int, text: String) {
        items[position].title = text
        notifyItemChanged(position)
    }

    class ViewHolder(
        private val binding: ItemDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ItemModel, onClickItem: (position: Int, text: ItemModel) -> Unit) {
            binding.apply {
                tvTitle.text = data.title
                tvTotal.text = data.total.toString()
                root.setOnClickListener {
                    onClickItem(absoluteAdapterPosition, data)
                }
            }
        }
    }
}