package com.example.concatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ItemHorizontalWrapperBinding

class HorizontalWrapperAdapter(
    private val horizontalAdapter: HorizontalAdapter
) : RecyclerView.Adapter<HorizontalWrapperAdapter.ViewHolder>() {

    companion object {
        const val TYPE = 0
    }

    private var lastScroll = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemHorizontalWrapperBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(horizontalAdapter, lastScroll) {
            lastScroll = it
        }
    }

    class ViewHolder(
        private val binding: ItemHorizontalWrapperBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            horizontalAdapter: HorizontalAdapter,
            lastScroll: Int,
            onScroll: (position: Int) -> Unit
        ) {
            binding.rcvHorizontal.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = horizontalAdapter
                doOnPreDraw {
                    scrollBy(lastScroll, 0)
                }
                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        onScroll(recyclerView.computeHorizontalScrollOffset())
                    }
                })
            }
        }
    }
}