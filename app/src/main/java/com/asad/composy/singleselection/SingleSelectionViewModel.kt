package com.asad.composy.singleselection

import androidx.lifecycle.ViewModel
import com.asad.composy.R
import com.asad.composy.data.DataModel

class SingleSelectionViewModel : ViewModel() {

    private val listItems = mutableListOf<DataModel>().apply {
        addAll(dataList)
    }

    fun getItems(): List<DataModel> {
        return listItems
    }
}

private val dataList = listOf(
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