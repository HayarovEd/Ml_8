package com.kredit.onlain.merca.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kredit.onlain.merca.R
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseDto
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState
import com.zaim.metr.dokm.domzaem.domain.model.basedto.BaseState.Loans
import com.kredit.onlain.merca.ui.theme.baseBackground
import com.kredit.onlain.merca.ui.theme.baseText
import com.zaim.metr.dokm.domzaem.presentation.MainEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    db: BaseDto,
    baseState: BaseState,
    onEvent: (MainEvent) -> Unit,
    loanLazyState: LazyListState,
) {
    val title = when (baseState) {
        Loans -> stringResource(id = R.string.loans)
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            color = baseText,
                            fontStyle = FontStyle(R.font.baloo2),
                            fontSize = 24.sp,
                            fontWeight = FontWeight(500),
                            text = title
                        )
                        /*IconButton(onClick = onClickRules) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.info),
                                tint = black,
                                contentDescription = "")
                        }*/
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = baseBackground
                )
            )
        }
    ) { valuePaddings ->
        when (baseState) {
            Loans -> {
                Loans(
                    valuePaddings = valuePaddings,
                    loans = db.loans,
                    onEvent = onEvent,
                    baseState = baseState,
                    loanLazyState = loanLazyState
                )
            }
        }
    }
}
