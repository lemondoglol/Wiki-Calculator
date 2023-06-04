package com.example.wikicalculator.apps.tax_calculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.wikicalculator.R
import com.example.wikicalculator.apps.tax_calculator.TaxCalculatorViewModel.Companion.USER_ID_1
import com.example.wikicalculator.apps.tax_calculator.TaxCalculatorViewModel.Companion.USER_ID_2
import com.example.wikicalculator.apps.tax_calculator.model.IncomeTaxInfo
import com.example.wikicalculator.apps.tax_calculator.model.TaxResult
import com.example.wikicalculator.apps.tax_calculator.model.UserTaxInfo
import com.example.wikicalculator.core.extensions.formatToString
import com.example.wikicalculator.core.model.FontSize
import com.example.wikicalculator.core.model.Padding
import com.example.wikicalculator.core.ui.*

@Composable
internal fun TaxCalculatorScreen(
    modifier: Modifier = Modifier,
    user1TaxInfo: UserTaxInfo,
    user2TaxInfo: UserTaxInfo,
    onIncomeInputRowDataChanged: (userId: Int, rowIndex: Int, incomeTaxInfo: IncomeTaxInfo) -> Unit,
    onAddMoreIncomeButtonClick: (userId: Int) -> Unit,
    onCalculateClick: () -> Unit,
    calculatedResult: TaxResult,
    currentUserId: Int,
    onNextButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    onResultDismissButtonClicked: () -> Unit,
    isShowingResult: Boolean,
) {
    when (currentUserId) {
        USER_ID_1 -> {
            UserSection(
                modifier = modifier.padding(Padding.paddingS),
                userTaxInfo = user1TaxInfo,
                onIncomeInputRowDataChanged = onIncomeInputRowDataChanged,
                onAddMoreIncomeButtonClick = onAddMoreIncomeButtonClick,
                onNavigationButtonClick = onNextButtonClick,
                onCalculateClick = onCalculateClick,
                navigationText = stringResource(R.string.next),
                onResultDismissButtonClicked = onResultDismissButtonClicked,
                calculatedResult = calculatedResult,
                isShowingResult = isShowingResult,
            )
        }
        USER_ID_2 -> {
            UserSection(
                modifier = modifier.padding(Padding.paddingS),
                userTaxInfo = user2TaxInfo,
                onIncomeInputRowDataChanged = onIncomeInputRowDataChanged,
                onAddMoreIncomeButtonClick = onAddMoreIncomeButtonClick,
                onNavigationButtonClick = onBackButtonClick,
                onCalculateClick = onCalculateClick,
                navigationText = stringResource(R.string.back),
                onResultDismissButtonClicked = onResultDismissButtonClicked,
                calculatedResult = calculatedResult,
                isShowingResult = isShowingResult,
            )
        }
    }
}

@Composable
private fun UserSection(
    modifier: Modifier = Modifier,
    userTaxInfo: UserTaxInfo,
    onIncomeInputRowDataChanged: (userId: Int, rowIndex: Int, incomeTaxInfo: IncomeTaxInfo) -> Unit,
    onAddMoreIncomeButtonClick: (userId: Int) -> Unit,
    onNavigationButtonClick: () -> Unit,
    navigationText: String,
    onCalculateClick: () -> Unit,
    onResultDismissButtonClicked: () -> Unit,
    calculatedResult: TaxResult,
    isShowingResult: Boolean,
) {
    if (isShowingResult) {
        CustomDialog(
            title = "Your Tax Result",
            content = calculatedResult.toString(),
            isDialogClicked = isShowingResult,
            onDismissButtonClicked = onResultDismissButtonClicked,
        )
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            fontSize = FontSize.fontSizeM,
            text = "User ${userTaxInfo.userId}",
        )
        HorizontalSpacer()

        // User Incomes Input Section
        repeat(userTaxInfo.incomeInfoList.size) {
            IncomeInputRow(
                userId = userTaxInfo.userId,
                rowIndex = it,
                taxInfo = userTaxInfo.incomeInfoList[it],
                onIncomeInputRowDataChanged = onIncomeInputRowDataChanged,
            )
            HorizontalSpacerAndDivider()
        }

        // Add More User Income Button
        ButtonWithIcon(
            onClick = {
                onAddMoreIncomeButtonClick(userTaxInfo.userId)
            },
            text = stringResource(R.string.Add_More_Income),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Padding.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Calculation and Result Section
            Button(
                onClick = onCalculateClick,
            ) {
                Text(text = stringResource(R.string.Calculate))
            }

            Button(
                onClick = onNavigationButtonClick,
            ) {
                Text(navigationText)
            }
        }
    }

}

@Composable
private fun IncomeInputRow(
    modifier: Modifier = Modifier,
    userId: Int,
    rowIndex: Int,
    taxInfo: IncomeTaxInfo,
    onIncomeInputRowDataChanged: (userId: Int, rowIndex: Int, incomeTaxInfo: IncomeTaxInfo) -> Unit,
) {
    var income by remember { mutableStateOf(taxInfo.income) }
    var federalTaxWithHold by remember { mutableStateOf(taxInfo.taxFederalWithHold) }
    var stateTaxWithHold by remember { mutableStateOf(taxInfo.taxStateWithHold) }

    DecimalOutLinedInputTextField(
        hint = stringResource(R.string.IncomeHint),
        label = stringResource(R.string.IncomeLabel),
        initialValue = taxInfo.income.formatToString(),
        onValueChange = {
            income = it
        }
    )

    DecimalOutLinedInputTextField(
        label = stringResource(R.string.FederalTaxWithHold),
        hint = stringResource(R.string.FederalTaxWithHoldHint),
        initialValue = taxInfo.taxFederalWithHold.formatToString(),
        onValueChange = {
            federalTaxWithHold = it
        }
    )

    DecimalOutLinedInputTextField(
        label = stringResource(R.string.StateTaxWithHold),
        hint = stringResource(R.string.StateTaxWithHoldHint),
        initialValue = taxInfo.taxStateWithHold.formatToString(),
        onValueChange = {
            stateTaxWithHold = it
        }
    )

    onIncomeInputRowDataChanged(
        userId,
        rowIndex,
        IncomeTaxInfo(
            income = income,
            taxFederalWithHold = federalTaxWithHold,
            taxStateWithHold = stateTaxWithHold,
        )
    )
}

@Composable
private fun CalculationResult(
    modifier: Modifier = Modifier,
    calculatedResult: TaxResult,
) {
    // TODO FORMAT THIS
    Text(
        text = "Result $calculatedResult"
    )
}

