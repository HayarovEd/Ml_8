package com.kredit.onlain.merca.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kredit.onlain.merca.R
import com.kredit.onlain.merca.ui.theme.blue
@Preview
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = blue)
    ) {
        Image(
            modifier = modifier
                .align(alignment = Alignment.Center),
            painter = painterResource(id = R.drawable.logo_no_fon),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
    }
}