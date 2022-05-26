package com.asad.composy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.asad.composy.multiselection.MultiSelectionActivity
import com.asad.composy.singleselection.SingleSelectionActivity
import com.asad.composy.ui.theme.ComposyTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ComposyTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainUI(modifier = Modifier) {
                        when (it) {
                            SINGLE_SELECTION_EVENT -> {
                                launchActivity(SingleSelectionActivity::class.java)
                            }
                            MULTI_SELECTION_EVENT -> {
                                launchActivity(MultiSelectionActivity::class.java)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun launchActivity(className: Class<*>) {
        startActivity(Intent(this, className))
    }

    companion object {
        const val SINGLE_SELECTION_EVENT = 1
        const val MULTI_SELECTION_EVENT = 2
    }
}