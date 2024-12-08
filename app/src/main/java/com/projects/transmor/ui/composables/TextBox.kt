package com.projects.transmor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun TextBox(data: String, onValueChange: (String) -> Unit) {

    TextField(
        value = data,
        onValueChange = onValueChange,
        label = { Text("ENTER DATA") },
        modifier = Modifier
            .border(width = 1.dp, color = colorResource(com.projects.transmor.R.color.black), shape = RoundedCornerShape(15.dp))
            .background(color = colorResource(com.projects.transmor.R.color.white), shape = RoundedCornerShape(15.dp))
    )
}


