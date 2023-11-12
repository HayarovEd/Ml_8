package com.zaim.metr.dokm.domzaem.presentation

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
import androidx.compose.ui.draw.shadow
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
import com.zaim.metr.dokm.domzaem.R
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.Reconnect
import com.zaim.metr.dokm.domzaem.ui.theme.baseBackground
import com.zaim.metr.dokm.domzaem.ui.theme.baseText
import com.zaim.metr.dokm.domzaem.ui.theme.secondText
import com.zaim.metr.dokm.domzaem.ui.theme.yellow

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
                modifier = modifier.size(80.dp),
                painter = painterResource(
                id = R.drawable.no_connection),
                contentDescription = "")
            Spacer(modifier = modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.not_connect),
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                fontStyle = FontStyle(R.font.roboto),
                color = baseText,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.try_internet),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle(R.font.roboto),
                color = secondText,
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 0.dp, spotColor = baseText, ambientColor = baseText)
                .align(alignment = Alignment.BottomCenter),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(
                vertical = 17.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow,
                contentColor = baseBackground,
            ),
            onClick = { onEvent(Reconnect) }
        ) {
            Text(
                text = stringResource(id = R.string.reconnect),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
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
