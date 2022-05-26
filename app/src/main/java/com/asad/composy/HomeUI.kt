package com.asad.composy

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asad.composy.HomeActivity.Companion.MULTI_SELECTION_EVENT
import com.asad.composy.HomeActivity.Companion.SINGLE_SELECTION_EVENT

@Composable
fun MainUI(
    modifier: Modifier = Modifier,
    openNextScreen: ((event: @ClickEvents Int) -> Unit)? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = {
            openNextScreen?.invoke(MULTI_SELECTION_EVENT)
        }) {
            Text(text = "MultiSelection List")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            openNextScreen?.invoke(SINGLE_SELECTION_EVENT)
        }) {
            Text(text = "SingleSelection List")
        }
    }
}

@Preview
@Composable
fun MainUIPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        MainUI()
    }
}