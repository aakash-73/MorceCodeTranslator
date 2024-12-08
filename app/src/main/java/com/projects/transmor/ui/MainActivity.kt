package com.projects.transmor.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.projects.transmor.ui.composables.ClearButton
import com.projects.transmor.ui.composables.DisplayScreen
import com.projects.transmor.ui.composables.TextBox
import com.projects.transmor.ui.composables.TranslateButton
import com.projects.transmor.viewModels.TranslatorViewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: TranslatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           TranslationScreen()
        }
    }

    @Composable
    fun TranslationScreen() {
        var inputData by remember { mutableStateOf("") }
        val displayData by viewModel.textNeededToTranslate.collectAsState()

        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            Column(modifier = Modifier.padding(padding)){
                TextBox(
                    data = inputData,
                    onValueChange = { newString -> inputData = newString })
                Row {
                    TranslateButton(data = inputData,
                        onClick = { viewModel.identifyInputCode(inputData) })
                    ClearButton(
                        onClick = { inputData = "" }
                    )
                }
                DisplayScreen(displayData)
            }
        }
    }

}