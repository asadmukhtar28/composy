@file:OptIn(ExperimentalUnitApi::class)

package com.asad.composy.multiselection

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asad.composy.R
import com.asad.composy.data.DataModel

@Composable
fun MultiSelectionScreen(
    modifier: Modifier = Modifier,
    multiSelectionViewModel: MultiSelectionViewModel = viewModel()
) {
    ListItems(
        modifier = modifier.padding(4.dp),
        dataList,
        multiSelectionViewModel.getSelectedItemCount()
    ) {
        multiSelectionViewModel.updateSelectedItemCount(it)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItems(
    modifier: Modifier = Modifier, listItems: List<DataModel>,
    count: LiveData<Int> = MutableLiveData(0), itemsCount: (selectedItemCount: Int) -> Unit
) {
    var selectedItemCount by rememberSaveable { mutableStateOf(0) }

    LazyColumn(modifier) {
        stickyHeader {
            RvHeader(count = count)
        }
        items(items = listItems) { item ->
            RvRow(modifier = Modifier.padding(4.dp), item) { checkedState ->
                if (checkedState)
                    ++selectedItemCount
                else --selectedItemCount

                itemsCount.invoke(selectedItemCount)
            }
            Divider(
                color = Color(0xFFC7C7C7),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun RvHeader(modifier: Modifier = Modifier, count: LiveData<Int> = MutableLiveData(0)) {

    val selectedItemCount = count.observeAsState().value

    val selectedItems =
        buildAnnotatedString {
            append("You have selected ")
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    fontSize = TextUnit(20f, TextUnitType.Sp)
                )
            ) {
                append("$selectedItemCount")
            }
            append(" items")
        }


    Surface(
        color = Color.LightGray,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = selectedItems,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun RvRow(
    modifier: Modifier = Modifier,
    item: DataModel,
    onRowItemClick: (state: Boolean) -> Unit
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    Column(modifier.clickable {
        checkedState = !checkedState
        onRowItemClick.invoke(checkedState)
    }) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.drawableRes),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = item.title),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

            Checkbox(
                checked = checkedState, onCheckedChange = { newValue ->
                    checkedState = newValue
                    onRowItemClick.invoke(checkedState)
                },
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun PreviewRvHeader() {
    RvHeader(modifier = Modifier)
}

@Preview
@Composable
fun PreviewRvRow() {
    RvRow(
        modifier = Modifier.padding(4.dp),
        item = DataModel(R.drawable.icon_inversions, R.string.inversions)
    ) {}
}

@Preview
@Composable
fun PreviewListItems() {
    ListItems(
        modifier = Modifier.padding(4.dp),
        listOf<DataModel>().apply {
            DataModel(
                R.drawable.icon_inversions,
                R.string.inversions
            )
        }
    ) {

    }
}