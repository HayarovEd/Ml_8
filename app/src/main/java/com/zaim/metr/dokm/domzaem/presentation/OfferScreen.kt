package com.zaim.metr.dokm.domzaem.presentation

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import com.zaim.metr.dokm.domzaem.R
import com.zaim.metr.dokm.domzaem.R.string
import com.zaim.metr.dokm.domzaem.data.VALUE_ONE
import com.zaim.metr.dokm.domzaem.domain.model.ElementOffer
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.OnGoToWeb
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.Reconnect
import com.zaim.metr.dokm.domzaem.ui.theme.baseBackground
import com.zaim.metr.dokm.domzaem.ui.theme.baseText
import com.zaim.metr.dokm.domzaem.ui.theme.yellow

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(
    modifier: Modifier = Modifier,
    elementOffer: ElementOffer,
    baseState: BaseState,
    onEvent: (MainEvent) -> Unit,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = baseBackground
                ),
                title = {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = modifier
                                .clickable { onEvent(Reconnect) },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_new_14),
                                tint = baseText,
                                contentDescription = ""
                            )
                            Spacer(modifier = modifier.width(5.dp))
                            Text(
                                color = baseText,
                                fontStyle = FontStyle(R.font.roboto),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                text = stringResource(id = R.string.back)
                            )
                        }
                        Spacer(modifier = modifier.height(15.dp))
                        Text(
                            color = baseText,
                            fontStyle = FontStyle(R.font.roboto),
                            fontSize = 24.sp,
                            fontWeight = FontWeight(600),
                            text = elementOffer.name
                        )
                        Spacer(modifier = modifier.height(15.dp))
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = baseBackground
            ) {
                Button(
                    modifier = modifier
                        .fillMaxWidth()
                        .shadow(elevation = 0.dp, spotColor = baseText, ambientColor = baseText),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(
                        vertical = 17.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = yellow,
                        contentColor = baseBackground,
                    ),
                    onClick = {
                        onEvent(
                            OnGoToWeb(
                                urlOffer = elementOffer.order,
                                nameOffer = elementOffer.name
                            )
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.checkout),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(600),
                        )
                    )
                }
                Spacer(modifier = modifier.height(15.dp))
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = baseBackground)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            AsyncImage(
                modifier = modifier
                    .fillMaxWidth(),
                model = elementOffer.pathImage,
                contentScale = ContentScale.FillWidth,
                contentDescription = ""
            )
            Spacer(modifier = modifier.height(10.dp))
            RowCard(
                showVisa = elementOffer.showVisa,
                showMaster = elementOffer.showMaster,
                showYandex = elementOffer.showYandex,
                showMir = elementOffer.showMir,
                showQivi = elementOffer.showQiwi,
                showCache = elementOffer.showCache
            )
            Spacer(modifier = modifier.height(15.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                RowData(
                    modifier = modifier.weight(1f),
                    title = stringResource(id = string.amount),
                    content = elementOffer.amount
                )
                if (elementOffer.showPercent == VALUE_ONE) {
                    Spacer(modifier = modifier.height(8.dp))
                    RowData(
                        modifier = modifier.weight(1f),
                        title = stringResource(id = string.bet),
                        content = elementOffer.bet
                    )
                }
            }
            /*if (elementOffer.showTerm == VALUE_ONE) {
                Spacer(modifier = modifier.height(8.dp))
                RowData(
                    title = stringResource(id = string.term),
                    content = elementOffer.term
                )
            }*/
            Spacer(modifier = modifier.height(15.dp))
            AndroidView(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = baseBackground),
                factory = { context -> TextView(context) },
                update = {
                    it.setTextColor(R.color.white)
                    it.text = HtmlCompat.fromHtml(
                        elementOffer.description,
                        HtmlCompat.FROM_HTML_MODE_COMPACT
                    )
                }
            )
        }
    }
}