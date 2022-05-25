package com.asad.composy.multiselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asad.composy.R
import com.asad.composy.data.DataModel

class MultiSelectionViewModel : ViewModel() {
    private val selectedItemCount = MutableLiveData(0)

    private val listItems: List<DataModel> = mutableListOf<DataModel>().apply {
        addAll(dataList)
    }


    fun getSelectedItemCount(): LiveData<Int> {
        return selectedItemCount
    }

    fun updateSelectedItemCount(count: Int) {
        this.selectedItemCount.value = count
    }

    fun getItems(): List<DataModel> {
        return listItems
    }
}

 val dataList = listOf(
    DataModel(R.drawable.icon_inversions, R.string.inversions),
    DataModel(R.drawable.icon_stretching, R.string.stretching),
    DataModel(R.drawable.icon_hiit, R.string.hiit),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_tabata, R.string.tabata),
    DataModel(R.drawable.icon_inversions, R.string.inversions),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_stretching, R.string.stretching),
    DataModel(R.drawable.icon_hiit, R.string.hiit),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_inversions, R.string.inversions),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_stretching, R.string.stretching),
    DataModel(R.drawable.icon_inversions, R.string.inversions),
    DataModel(R.drawable.icon_stretching, R.string.stretching),
    DataModel(R.drawable.icon_hiit, R.string.hiit),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_tabata, R.string.tabata),
    DataModel(R.drawable.icon_inversions, R.string.inversions),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_stretching, R.string.stretching),
    DataModel(R.drawable.icon_hiit, R.string.hiit),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_inversions, R.string.inversions),
    DataModel(R.drawable.icon_quick_yoqa, R.string.quick_yoga),
    DataModel(R.drawable.icon_stretching, R.string.stretching),
)