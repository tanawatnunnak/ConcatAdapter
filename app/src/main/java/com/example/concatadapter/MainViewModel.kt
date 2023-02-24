package com.example.concatadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _bannerLiveData: MutableLiveData<List<String>> = MutableLiveData()
    val bannerLiveData: LiveData<List<String>> = _bannerLiveData

    private val _headerLiveData: MutableLiveData<Int> = MutableLiveData()
    val headerLivedata: LiveData<Int> = _headerLiveData

    private val _itemsLiveData: MutableLiveData<List<ItemModel>> = MutableLiveData()
    val itemsLiveData: LiveData<List<ItemModel>> = _itemsLiveData

    private val _footerLiveData: MutableLiveData<Int> = MutableLiveData()
    val footerLiveData: LiveData<Int> = _footerLiveData

    fun fetchApiSomeThing() {
        val result = mockData()
        _bannerLiveData.value = mockBanner()
        _headerLiveData.value = result.size
        _itemsLiveData.value = result
        _footerLiveData.value = result.size - Random(result.size).nextInt()
    }

    private fun mockData(): List<ItemModel> {
        return mutableListOf<ItemModel>().apply {
            repeat(20) { value ->
                add(
                    ItemModel(
                        title = "I am number $value",
                        total = value * Random(value).nextInt()
                    )
                )
            }
        }
    }

    private fun mockBanner(): List<String> {
        return listOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
        )
    }
}