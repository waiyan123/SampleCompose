package com.example.cleanarchi.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cleanarchi.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
val BnbTypo = Typography(
    defaultFontFamily = FontFamily(Font(R.font.roboto_regular)),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.alkalami)),
        fontWeight = FontWeight.W600
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.alkalami)),
        fontWeight = FontWeight.W500
    )
)