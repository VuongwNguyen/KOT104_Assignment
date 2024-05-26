package com.example.kot104_assignmentfinal.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.kot104_assignmentfinal.R
import com.example.kot104_assignmentfinal.constant.AppConstant

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.merriweather_bold)),
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 45.sp,
        fontStyle = FontStyle.Normal,
        color = HomeBeautiColor
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.merriweather_regular)),
        fontWeight = FontWeight(400),
        fontSize = 30.sp,
        lineHeight = 45.sp,
        fontStyle = FontStyle.Normal,
        color = GreyColor,
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(AppConstant.FONT_NUNITO_SANS_SEMI_BOLD)),
        fontWeight = FontWeight(600),
        fontSize = 18.sp,
        fontStyle = FontStyle.Normal,
        color = HomeBeautiColor,
        textAlign = TextAlign.Center
    ),

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)