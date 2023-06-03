package com.example.wikicalculator.apps.tax_calculator.model

data class TaxBracketKey(
    val lowerBound: Int,
    val upperBound: Int,
)

data class TaxBracketValue(
    val bracketBaseLine: Float,
    val bracketPercentage: Float,
    val bracketOverAmount: Int,
)

data class UserTaxInfo(
    val userId: Int,
    val incomeInfoList: MutableList<IncomeTaxInfo>,
)

data class IncomeTaxInfo(
    val income: Float = 0f,
    val taxFederalWithHold: Float = 0f,
    val taxStateWithHold: Float = 0f,
)

data class TaxResult(
    val fileSingleUser1: Float = 0f,
    val fileSingleUser2: Float = 0f,
    val fileSingleCombined: Float = 0f,
    val fileMarriedSeparately: Float = 0f,
    val fileMarriedJointly: Float = 0f,
    val fileHouseHold: Float = 0f,
)
