package com.kredit.onlain.merca.presentation

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.kredit.onlain.merca.R
import com.zaim.metr.dokm.domzaem.data.VALUE_ONE
import com.zaim.metr.dokm.domzaem.domain.model.ElementOffer
import com.zaim.metr.dokm.domzaem.domain.model.StatusApplication.Connect
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState
import com.kredit.onlain.merca.ui.theme.baseBackground
import com.kredit.onlain.merca.ui.theme.baseText
import com.kredit.onlain.merca.ui.theme.blue
import com.kredit.onlain.merca.ui.theme.white
import com.zaim.metr.dokm.domzaem.presentation.MainEvent
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.OnChangeStatusApplication
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.OnGoToWeb

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
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            onEvent(
                                OnChangeStatusApplication(
                                    Connect(baseState)
                                )
                            )
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_20),
                                tint = blue,
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = modifier.width(5.dp))
                        Text(
                            color = baseText,
                            fontStyle = FontStyle(R.font.baloo2),
                            fontSize = 22.sp,
                            fontWeight = FontWeight(500),
                            text = elementOffer.name
                        )
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
                        .padding(horizontal = 24.dp),
                    shape = RoundedCornerShape(15.dp),
                    contentPadding = PaddingValues(
                        vertical = 16.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = blue,
                        contentColor = white,
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
                            fontSize = 26.sp,
                            fontFamily = FontFamily(Font(R.font.baloo2)),
                            fontWeight = FontWeight(600),
                        )
                    )
                }
                Spacer(modifier = modifier.height(24.dp))
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
            Spacer(modifier = modifier.height(20.dp))
            AndroidView(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = white),
                factory = { context -> TextView(context) },
                update = {
                    it.setTextColor(R.color.white)
                    it.text = HtmlCompat.fromHtml(
                        elementOffer.description,
                        HtmlCompat.FROM_HTML_MODE_COMPACT
                    )
                }
            )
            Spacer(modifier = modifier.height(31.dp))
            RowData(
                title = stringResource(id = R.string.amount),
                content = elementOffer.amount
            )
            if (elementOffer.showPercent == VALUE_ONE) {
                Spacer(modifier = modifier.height(8.dp))
                RowData(
                    title = stringResource(id = R.string.bet),
                    content = elementOffer.bet
                )
            }
            if (elementOffer.showTerm == VALUE_ONE) {
                Spacer(modifier = modifier.height(8.dp))
                RowData(
                    title = stringResource(id = R.string.term),
                    content = elementOffer.term
                )
            }
            Spacer(modifier = modifier.height(21.dp))
            RowCard(
                showVisa = elementOffer.showVisa,
                showMaster = elementOffer.showMaster,
                showYandex = elementOffer.showYandex,
                showMir = elementOffer.showMir,
                showQivi = elementOffer.showQiwi,
                showCache = elementOffer.showCache
            )
        }
    }
}