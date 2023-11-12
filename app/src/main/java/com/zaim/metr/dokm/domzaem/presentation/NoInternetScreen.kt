package com.kredit.onlain.merca.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kredit.onlain.merca.R
import com.kredit.onlain.merca.ui.theme.baseBackground
import com.kredit.onlain.merca.ui.theme.baseText
import com.kredit.onlain.merca.ui.theme.blue
import com.kredit.onlain.merca.ui.theme.white
import com.zaim.metr.dokm.domzaem.presentation.MainEvent
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.Reconnect

@Composable
fun NoInternetScreen(
    modifier: Modifier = Modifier,
    onEvent: (MainEvent) -> Unit
) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(color = baseBackground)
            .padding(25.dp)
    ) {
        Column (
            modifier = modifier.align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier.size(90.dp),
                painter = painterResource(
                id = R.drawable.no_connect),
                contentDescription = "")
            Spacer(modifier = modifier.height(45.dp))
            Text(
                text = stringResource(id = R.string.not_connect),
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                fontStyle = FontStyle(R.font.baloo2),
                color = baseText,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.try_internet),
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle(R.font.baloo2),
                color = baseText,
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            shape = RoundedCornerShape(15.dp),
            contentPadding = PaddingValues(
                vertical = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = blue,
                contentColor = white,
            ),
            onClick = { onEvent(Reconnect) }
        ) {
            Text(
                text = stringResource(id = R.string.reconnect),
                style = TextStyle(
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(R.font.baloo2)),
                    fontWeight = FontWeight(600),
                )
            )
        }
    }
}
@Preview
@Composable
fun SampleNoInternetScreen() {
    NoInternetScreen(onEvent = {})
}
