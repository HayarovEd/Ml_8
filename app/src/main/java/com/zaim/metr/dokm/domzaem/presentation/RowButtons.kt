
package com.zaim.metr.dokm.domzaem.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaim.metr.dokm.domzaem.R
import com.zaim.metr.dokm.domzaem.domain.model.ElementOffer
import com.zaim.metr.dokm.domzaem.domain.model.StatusApplication.Offer
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.OnChangeStatusApplication
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.OnGoToWeb
import com.zaim.metr.dokm.domzaem.ui.theme.baseBackground
import com.zaim.metr.dokm.domzaem.ui.theme.baseText
import com.zaim.metr.dokm.domzaem.ui.theme.yellow

@Composable
fun RowButtons(
    modifier: Modifier = Modifier,
    titleOffer: String,
    currentBaseState: BaseState,
    onEvent: (MainEvent) -> Unit,
    name: String,
    pathImage: String,
    rang: String,
    description: String,
    amount: String,
    bet: String,
    term: String,
    showMir: String,
    showVisa: String,
    showMaster: String,
    showQiwi: String,
    showYandex: String,
    showCache: String,
    showPercent: String,
    showTerm: String,
    order:String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .weight(1f)
                //.border(width = 2.dp, color = blue, shape = RoundedCornerShape(10.dp))
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = baseBackground)
                .clickable(onClick = {
                    onEvent(
                        OnChangeStatusApplication(
                            Offer(
                                currentBaseState = currentBaseState,
                                ElementOffer(
                                    name = name,
                                    pathImage = pathImage,
                                    rang = rang,
                                    description = description,
                                    amount = amount,
                                    bet = bet,
                                    term = term,
                                    showMir = showMir,
                                    showVisa = showVisa,
                                    showMaster = showMaster,
                                    showQiwi = showQiwi,
                                    showYandex = showYandex,
                                    showCache = showCache,
                                    showPercent = showPercent,
                                    showTerm = showTerm,
                                    nameButton = titleOffer,
                                    order = order
                                )
                            )
                        )
                    )
                })
                .padding(vertical = 16.dp)
        ) {
            Text(
                modifier = modifier.align(alignment = Alignment.Center),
                color = baseText,
                fontStyle = FontStyle(R.font.roboto),
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                text = stringResource(id = R.string.details),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = modifier.width(9.dp))
        Box(
            modifier = modifier
                .weight(1f)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(10.dp),
                    spotColor = baseText,
                    ambientColor = baseText
                )
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = yellow)
                .clickable(onClick = {
                    onEvent(
                        OnGoToWeb(
                            urlOffer = order,
                            nameOffer = name
                        )
                    )
                })
                .padding(vertical = 17.dp)
        ) {
            Text(
                modifier = modifier.align(alignment = Alignment.Center),
                color = baseBackground,
                fontStyle = FontStyle(R.font.roboto),
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                text = stringResource(id = R.string.checkout),
                textAlign = TextAlign.Center
            )
        }
    }
}
