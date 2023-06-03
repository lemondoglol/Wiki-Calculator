package com.example.wikicalculator.apps.tax_calculator.util

import com.example.wikicalculator.apps.tax_calculator.model.TaxBracketKey
import com.example.wikicalculator.apps.tax_calculator.model.TaxBracketValue

fun getSingleBracketTaxMap(): Map<TaxBracketKey, TaxBracketValue> {
    return mapOf(
        TaxBracketKey(
            lowerBound = 0,
            upperBound = 10275
        ) to TaxBracketValue(
            bracketBaseLine = 0f,
            bracketPercentage = 0.1f,
            bracketOverAmount = 0,
        ),

        TaxBracketKey(
            lowerBound = 10275,
            upperBound = 41775
        ) to TaxBracketValue(
            bracketBaseLine = 1027.5f,
            bracketPercentage = 0.12f,
            bracketOverAmount = 10275,
        ),

        TaxBracketKey(
            lowerBound = 41775,
            upperBound = 89075
        ) to TaxBracketValue(
            bracketBaseLine = 4807.5f,
            bracketPercentage = 0.22f,
            bracketOverAmount = 41775,
        ),

        TaxBracketKey(
            lowerBound = 89075,
            upperBound = 170050
        ) to TaxBracketValue(
            bracketBaseLine = 15213.5f,
            bracketPercentage = 0.24f,
            bracketOverAmount = 89075,
        ),

        TaxBracketKey(
            lowerBound = 170050,
            upperBound = 215950
        ) to TaxBracketValue(
            bracketBaseLine = 34647.5f,
            bracketPercentage = 0.32f,
            bracketOverAmount = 170050,
        ),

        TaxBracketKey(
            lowerBound = 215950,
            upperBound = 539900
        ) to TaxBracketValue(
            bracketBaseLine = 49335.50f,
            bracketPercentage = 0.35f,
            bracketOverAmount = 215950,
        ),

        TaxBracketKey(
            lowerBound = 539900,
            upperBound = Int.MAX_VALUE
        ) to TaxBracketValue(
            bracketBaseLine = 162718f,
            bracketPercentage = 0.37f,
            bracketOverAmount = 539900,
        ),
    )
}

fun getMarriedJointBracketTaxMap(): Map<TaxBracketKey, TaxBracketValue> {
    return mapOf(
        TaxBracketKey(
            lowerBound = 0,
            upperBound = 20550
        ) to TaxBracketValue(
            bracketBaseLine = 0f,
            bracketPercentage = 0.1f,
            bracketOverAmount = 0,
        ),

        TaxBracketKey(
            lowerBound = 20550,
            upperBound = 83550
        ) to TaxBracketValue(
            bracketBaseLine = 2055f,
            bracketPercentage = 0.12f,
            bracketOverAmount = 20550,
        ),

        TaxBracketKey(
            lowerBound = 83550,
            upperBound = 178150
        ) to TaxBracketValue(
            bracketBaseLine = 9615f,
            bracketPercentage = 0.22f,
            bracketOverAmount = 83550,
        ),

        TaxBracketKey(
            lowerBound = 178150,
            upperBound = 340100
        ) to TaxBracketValue(
            bracketBaseLine = 30427f,
            bracketPercentage = 0.24f,
            bracketOverAmount = 178150,
        ),

        TaxBracketKey(
            lowerBound = 340100,
            upperBound = 431900
        ) to TaxBracketValue(
            bracketBaseLine = 69295f,
            bracketPercentage = 0.32f,
            bracketOverAmount = 340100,
        ),

        TaxBracketKey(
            lowerBound = 431900,
            upperBound = 647850
        ) to TaxBracketValue(
            bracketBaseLine = 98671f,
            bracketPercentage = 0.35f,
            bracketOverAmount = 431900,
        ),

        TaxBracketKey(
            lowerBound = 647850,
            upperBound = Int.MAX_VALUE
        ) to TaxBracketValue(
            bracketBaseLine = 174235.5f,
            bracketPercentage = 0.37f,
            bracketOverAmount = 647850,
        ),
    )
}

fun getMarriedSeparateBracketTaxMap(): Map<TaxBracketKey, TaxBracketValue> {
    return mapOf(
        TaxBracketKey(
            lowerBound = 0,
            upperBound = 10275
        ) to TaxBracketValue(
            bracketBaseLine = 0f,
            bracketPercentage = 0.1f,
            bracketOverAmount = 0,
        ),

        TaxBracketKey(
            lowerBound = 10275,
            upperBound = 41775
        ) to TaxBracketValue(
            bracketBaseLine = 1027.5f,
            bracketPercentage = 0.12f,
            bracketOverAmount = 10275,
        ),

        TaxBracketKey(
            lowerBound = 41775,
            upperBound = 89075
        ) to TaxBracketValue(
            bracketBaseLine = 4807.5f,
            bracketPercentage = 0.22f,
            bracketOverAmount = 41775,
        ),

        TaxBracketKey(
            lowerBound = 89075,
            upperBound = 170050
        ) to TaxBracketValue(
            bracketBaseLine = 15213.5f,
            bracketPercentage = 0.24f,
            bracketOverAmount = 89075,
        ),

        TaxBracketKey(
            lowerBound = 170050,
            upperBound = 215950
        ) to TaxBracketValue(
            bracketBaseLine = 34647.5f,
            bracketPercentage = 0.32f,
            bracketOverAmount = 170050,
        ),

        TaxBracketKey(
            lowerBound = 215950,
            upperBound = 323925
        ) to TaxBracketValue(
            bracketBaseLine = 49335.50f,
            bracketPercentage = 0.35f,
            bracketOverAmount = 215950,
        ),

        TaxBracketKey(
            lowerBound = 323925,
            upperBound = Int.MAX_VALUE
        ) to TaxBracketValue(
            bracketBaseLine = 87126.75f,
            bracketPercentage = 0.37f,
            bracketOverAmount = 323925,
        ),
    )
}

// for single parent
fun getHeadOfHouseholdBracketTaxMap(): Map<TaxBracketKey, TaxBracketValue> {
    return mapOf(
        TaxBracketKey(
            lowerBound = 0,
            upperBound = 14650
        ) to TaxBracketValue(
            bracketBaseLine = 0f,
            bracketPercentage = 0.1f,
            bracketOverAmount = 0,
        ),

        TaxBracketKey(
            lowerBound = 14650,
            upperBound = 55900
        ) to TaxBracketValue(
            bracketBaseLine = 1465f,
            bracketPercentage = 0.12f,
            bracketOverAmount = 14650,
        ),

        TaxBracketKey(
            lowerBound = 55900,
            upperBound = 89050
        ) to TaxBracketValue(
            bracketBaseLine = 6415f,
            bracketPercentage = 0.22f,
            bracketOverAmount = 55900,
        ),

        TaxBracketKey(
            lowerBound = 89050,
            upperBound = 170050
        ) to TaxBracketValue(
            bracketBaseLine = 13708f,
            bracketPercentage = 0.24f,
            bracketOverAmount = 89050,
        ),

        TaxBracketKey(
            lowerBound = 170050,
            upperBound = 215950
        ) to TaxBracketValue(
            bracketBaseLine = 33148f,
            bracketPercentage = 0.32f,
            bracketOverAmount = 170050,
        ),

        TaxBracketKey(
            lowerBound = 215950,
            upperBound = 539900
        ) to TaxBracketValue(
            bracketBaseLine = 47836f,
            bracketPercentage = 0.35f,
            bracketOverAmount = 215950,
        ),

        TaxBracketKey(
            lowerBound = 539900,
            upperBound = Int.MAX_VALUE
        ) to TaxBracketValue(
            bracketBaseLine = 161218.50f,
            bracketPercentage = 0.37f,
            bracketOverAmount = 539900,
        ),
    )
}

const val SINGLE_SD = 13850f
const val MARRIED_SEPARATE_SD = 13850f
const val MARRIED_JOINTLY_SD = 27700f
const val HEAD_OF_HOUSEHOLD_SD = 20800f
