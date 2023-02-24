package com.example.concatadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.databinding.ItemHeaderBinding
import com.example.concatadapter.databinding.ItemLoadingBinding

class LoadingAdapter : RecyclerView.Adapter<LoadingAdapter.ViewHolder>() {

    companion object {
        const val TYPE = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view.root)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return TYPE
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}