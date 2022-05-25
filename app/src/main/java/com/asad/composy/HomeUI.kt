package com.asad.composy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainUI(modifier: Modifier = Modifier, openNextScreen: (() -> Unit?)? = null) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            openNextScreen?.invoke()
        }) {
            Text(text = "MultiSelection List")
        }
    }
}

@Preview
@Composable
fun MainUIPreview() {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        MainUI()
    }
}