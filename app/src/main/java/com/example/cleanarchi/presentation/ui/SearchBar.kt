package com.example.cleanarchi.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanarchi.R

@Composable
fun Searchbar(modifier: Modifier) {

    Box(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "BlaBla",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Mexico City")
                Text(text = "in Europe")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    Searchbar(modifier = Modifier)
}