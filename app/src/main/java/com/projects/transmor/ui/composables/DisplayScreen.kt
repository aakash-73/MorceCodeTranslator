package com.projects.transmor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DisplayScreen(translatedInput: String) {

    Text(
        text = translatedInput,
        modifier = Modifier
            .border(width = 1.dp, color = colorResource(com.projects.transmor.R.color.black), shape = RoundedCornerShape(15.dp))
            .background(color = colorResource(com.projects.transmor.R.color.white), shape = RoundedCornerShape(15.dp))
            .fillMaxSize()
            .padding(20.dp)
    )
}

@Preview
@Composable
fun Displaycall() {
    DisplayScreen("..-..")
}
