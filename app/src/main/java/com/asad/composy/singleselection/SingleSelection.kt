package com.asad.composy.singleselection

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asad.composy.R
import com.asad.composy.data.DataModel

@Composable
fun SingleSelectionScreen(
    modifier: Modifier = Modifier,
    singleSelectionViewModel: SingleSelectionViewModel = viewModel()
) {
    ListItems(
        modifier = modifier.padding(4.dp),
        singleSelectionViewModel.getItems()
    )
}

@Composable
fun ListItems(
    modifier: Modifier = Modifier,
    listItems: List<DataModel>
) {
    var selectedIndex by rememberSaveable { mutableStateOf(-1) }

    LazyColumn(modifier) {
        itemsIndexed(items = listItems) { index, item ->
            RvRow(
                modifier = Modifier.padding(4.dp),
                item,
                index,
                selectedIndex == index
            ) { index ->
                selectedIndex = if (selectedIndex == index) {
                    -1
                } else
                    index
            }
            Divider(
                color = Color(0xFFC7C7C7),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun RvRow(
    modifier: Modifier = Modifier,
    item: DataModel,
    index: Int,
    selected: Boolean,
    onSelected: (index: Int) -> Unit
) {
    Column(modifier.clickable {
        onSelected.invoke(index)
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
                    .wrapContentWidth(Alignment.Start)
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

            Image(
                painter = painterResource(id = if (selected) R.drawable.ic_selected else R.drawable.ic_unselected),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun SingleSelectionScreenPreview() {
    SingleSelectionScreen()
}
