package com.zaim.metr.dokm.domzaem.presentation

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
import com.zaim.metr.dokm.domzaem.R
import com.zaim.metr.dokm.domzaem.ui.theme.blue

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
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
    }
}