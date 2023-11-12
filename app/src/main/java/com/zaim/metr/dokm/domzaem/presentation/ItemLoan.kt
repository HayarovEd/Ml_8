
package com.zaim.metr.dokm.domzaem.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zaim.metr.dokm.domzaem.R
import com.zaim.metr.dokm.domzaem.R.string
import com.zaim.metr.dokm.domzaem.data.VALUE_ONE
import com.zaim.metr.dokm.domzaem.domain.model.ElementOffer
import com.zaim.metr.dokm.domzaem.domain.model.StatusApplication.Offer
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState
import com.zaim.metr.dokm.domzaem.domain.model.basedto.Loan
import com.zaim.metr.dokm.domzaem.presentation.MainEvent.OnChangeStatusApplication
import com.zaim.metr.dokm.domzaem.ui.theme.baseBackground
import com.zaim.metr.dokm.domzaem.ui.theme.baseText
import com.zaim.metr.dokm.domzaem.ui.theme.borderColor

@Composable
fun ItemLoan(
    modifier: Modifier = Modifier,
    loan: Loan,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = baseText,
                ambientColor = baseText
            )
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = baseBackground)
            .padding(16.dp)
    ) {
        Text(
            color = baseText,
            fontStyle = FontStyle(R.font.roboto),
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            text = loan.name
        )
        Spacer(modifier = modifier.height(20.dp))
        Divider(
            modifier = modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = borderColor
        )
        Spacer(modifier = modifier.height(20.dp))
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onEvent(
                        OnChangeStatusApplication(
                            Offer(
                                currentBaseState = baseState,
                                ElementOffer(
                                    nameButton = loan.orderButtonText,
                                    name = loan.name,
                                    pathImage = loan.screen,
                                    rang = loan.score,
                                    description = loan.description,
                                    amount = loan.summPrefix + " " + loan.summMin + " " + loan.summMid + " " + loan.summMax + " " + loan.summPostfix,
                                    bet = loan.percentPrefix + " " + loan.percent + " " + loan.percentPostfix,
                                    term = loan.termPrefix + " " + loan.termMin + " " + loan.termMid + " " + loan.termMax + " " + loan.termPostfix,
                                    showMir = loan.showMir,
                                    showVisa = loan.showVisa,
                                    showMaster = loan.showMastercard,
                                    showQiwi = loan.showQiwi,
                                    showYandex = loan.showYandex,
                                    showCache = loan.showCash,
                                    showPercent = loan.hidePercentFields,
                                    showTerm = loan.hideTermFields,
                                    order = loan.order
                                )
                            )
                        )
                    )
                },
            model = loan.screen,
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(10.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            RowData(
                modifier = modifier.weight(1f),
                title = stringResource(id = string.amount),
                content = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix
            )
            if (loan.hidePercentFields == VALUE_ONE) {
                Spacer(modifier = modifier.height(8.dp))
                RowData(
                    modifier = modifier.weight(1f),
                    title = stringResource(id = string.bet),
                    content = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix
                )
            }
        }
        /*RowData(
            title = stringResource(id = string.amount),
            content = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix
        )
        if (loan.hidePercentFields == VALUE_ONE) {
            RowData(
                title = stringResource(id = string.bet),
                content = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix
            )
        }
        if (loan.hideTermFields == VALUE_ONE) {
            RowData(
                title = stringResource(id = string.term),
                content = loan.termPrefix +" "+ loan.termMin +" " + loan.termMid +" " + loan.termMax +" " + loan.termPostfix
            )
        }*/
        Spacer(modifier = modifier.height(15.dp))
        RowCard(
            showVisa = loan.showVisa,
            showMaster = loan.showMastercard,
            showYandex = loan.showYandex,
            showMir = loan.showMir,
            showQivi = loan.showQiwi,
            showCache = loan.showCash
        )
        Spacer(modifier = modifier.height(15.dp))
        RowButtons(
            titleOffer = loan.orderButtonText,
            onEvent = onEvent,
            currentBaseState = baseState,
            name = loan.name,
            pathImage = loan.screen,
            rang = loan.score,
            description = loan.description,
            amount = loan.summPrefix +" " + loan.summMin +" " + loan.summMid +" " + loan.summMax +" " + loan.summPostfix,
            bet  = loan.percentPrefix +" " + loan.percent +" " + loan.percentPostfix,
            term = loan.termPrefix +" "+ loan.termMin +" " + loan.termMid +" " + loan.termMax +" " + loan.termPostfix,
            showMir = loan.showMir,
            showVisa = loan.showVisa,
            showMaster = loan.showMastercard,
            showQiwi = loan.showQiwi,
            showYandex = loan.showYandex,
            showCache = loan.showCash,
            showPercent = loan.hidePercentFields,
            showTerm = loan.hideTermFields,
            order = loan.order,
        )
    }
}
