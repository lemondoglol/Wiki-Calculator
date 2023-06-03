package com.example.wikicalculator.apps.tax_calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.wikicalculator.apps.tax_calculator.model.*
import com.example.wikicalculator.apps.tax_calculator.util.*
import com.example.wikicalculator.data.datainterface.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaxCalculatorViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository,
) : ViewModel() {

    internal var totalSalary by mutableStateOf(0f)
        private set

    internal var totalIncome: Float = 0f

    internal var user1 by mutableStateOf(UserTaxInfo(USER_ID_1, mutableStateListOf(IncomeTaxInfo())))
        private set
    internal var user2 by  mutableStateOf(UserTaxInfo(USER_ID_2, mutableStateListOf(IncomeTaxInfo())))
        private set

    internal var currentUserId by mutableStateOf(USER_ID_1)
        private set

    internal var calculatedResult by mutableStateOf(TaxResult())
        private set

    internal fun onIncomeInputRowDataChanged(
        userId: Int,
        rowIndex: Int,
        incomeTaxInfo: IncomeTaxInfo,
    ) {
        when (userId) {
            USER_ID_1 -> {
                user1.incomeInfoList[rowIndex] = incomeTaxInfo
            }
            USER_ID_2 -> user2.incomeInfoList[rowIndex] = incomeTaxInfo
        }
    }

    internal fun onAddMoreIncomeButtonClick(
        userId: Int,
    ) {
        when (userId) {
            USER_ID_1 -> user1.incomeInfoList.add(IncomeTaxInfo())
            USER_ID_2 -> user2.incomeInfoList.add(IncomeTaxInfo())
        }
    }

    internal var userTotalIncome = 0f

    //
    internal fun clickCalculateButton() {
        totalIncome = 0f
        var user1TotalIncome = 0f
        var user2TotalIncome = 0f
        user1.incomeInfoList.forEach {
            user1TotalIncome += it.income
            totalIncome += it.income
        }
        user2.incomeInfoList.forEach {
            user2TotalIncome += it.income
            totalIncome += it.income
        }

        calculatedResult = TaxResult(
            fileSingleUser1 = calculateTaxForSingle(user1TotalIncome),
            fileSingleUser2 = calculateTaxForSingle(user2TotalIncome),
            fileSingleCombined = calculateTaxForSingle(totalIncome),
            fileMarriedSeparately = calculateTaxForMarriedSeparate(totalIncome),
            fileMarriedJointly = calculateTaxForMarriedJoint(totalIncome),
            fileHouseHold = calculateTaxForHouseHold(totalIncome),
        )
    }

    /**
     * When prev button is clicked, since it is only happen on User 2 page
     * */
    internal fun switchToUser1() {
        currentUserId = USER_ID_1
    }

    /**
     * When next button is clicked, since it is only happen on User 1 page
     * */
    internal fun switchToUser2() {
        currentUserId = USER_ID_2
    }

    private fun calculateTaxForSingle(totalIncome: Float): Float {
        return calculateTax(
            totalIncome = totalIncome,
            bracketMap = getSingleBracketTaxMap(),
            deduction = SINGLE_SD,
        )
    }

    private fun calculateTaxForMarriedJoint(totalIncome: Float): Float {
        return calculateTax(
            totalIncome = totalIncome,
            bracketMap = getMarriedJointBracketTaxMap(),
            deduction = MARRIED_JOINTLY_SD,
        )
    }

    private fun calculateTaxForMarriedSeparate(totalIncome: Float): Float {
        return calculateTax(
            totalIncome = totalIncome,
            bracketMap = getMarriedSeparateBracketTaxMap(),
            deduction = MARRIED_SEPARATE_SD,
        )
    }

    private fun calculateTaxForHouseHold(totalIncome: Float): Float {
        return calculateTax(
            totalIncome = totalIncome,
            bracketMap = getHeadOfHouseholdBracketTaxMap(),
            deduction = HEAD_OF_HOUSEHOLD_SD,
        )
    }

    private fun calculateTax(
        totalIncome: Float,
        bracketMap: Map<TaxBracketKey, TaxBracketValue>,
        deduction: Float,
    ): Float {
        val incomeAfterDeduction = totalIncome - deduction
        bracketMap.forEach {
            if (incomeAfterDeduction >= it.key.lowerBound && incomeAfterDeduction < it.key.upperBound) {
                val taxBracketValue = it.value
                return taxBracketValue.bracketBaseLine +
                        taxBracketValue.bracketPercentage * (incomeAfterDeduction - taxBracketValue.bracketOverAmount)
            }
        }
        return 0f
    }

    companion object {
        internal const val USER_ID_1 = 1
        internal const val USER_ID_2 = 2
    }

}
