package com.zaim.metr.dokm.domzaem.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaim.metr.dokm.domzaem.R
import com.zaim.metr.dokm.domzaem.ui.theme.baseBackground
import com.zaim.metr.dokm.domzaem.ui.theme.baseText

@Composable
fun RowData(
    modifier: Modifier = Modifier,
    title: String,
    content: String
) {
    Column (
        modifier = modifier
            .background(color = baseBackground),
    ) {
        Text(
            color = baseText,
            fontStyle = FontStyle(R.font.roboto),
            fontSize = 11.sp,
            fontWeight = FontWeight(400),
            text = title,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(
            color = baseText,
            fontStyle = FontStyle(R.font.roboto),
            fontSize = 15.sp,
            fontWeight = FontWeight(700),
            text = content,
            textAlign = TextAlign.End
        )
    }
}
@Preview
@Composable
private fun SampleRowData () {
    RowData(
        title = stringResource(id = R.string.bet),
        content = "elementOffer.bet"
    )
}