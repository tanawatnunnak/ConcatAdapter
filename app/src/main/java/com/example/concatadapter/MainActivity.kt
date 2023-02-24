package com.example.concatadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concatadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy { MainViewModel() }

    private val horizontalAdapter: HorizontalAdapter by lazy {
        HorizontalAdapter()
    }

    private val horizontalWrapperAdapter: HorizontalWrapperAdapter by lazy {
        HorizontalWrapperAdapter(horizontalAdapter)
    }

    private val headerAdapter: HeaderAdapter by lazy { HeaderAdapter() }

    private val itemAdapter: ItemAdapter by lazy { ItemAdapter(::onClick) }

    private val footerAdapter: FooterAdapter by lazy { FooterAdapter() }

    private val concatAdapter: ConcatAdapter by lazy {
        val config = ConcatAdapter.Config.Builder().apply {
            setIsolateViewTypes(false)
        }.build()
        ConcatAdapter(
            config,
            horizontalWrapperAdapter,
            headerAdapter,
            itemAdapter,
            footerAdapter
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initObservable()
        viewModel.fetchApiSomeThing()
    }

    private fun initObservable() {
        viewModel.bannerLiveData.observe(this, horizontalAdapter::updateBanner)
        viewModel.headerLivedata.observe(this, headerAdapter::updateHeader)
        viewModel.itemsLiveData.observe(this, itemAdapter::setItems)
        viewModel.footerLiveData.observe(this, footerAdapter::updateRemaining)
    }

    private fun initAdapter() {
        binding.recyclerView.apply {
            adapter = concatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun onClick(position: Int, itemModel: ItemModel) {
        itemAdapter.update(position - 1, "This is update")
    }
}