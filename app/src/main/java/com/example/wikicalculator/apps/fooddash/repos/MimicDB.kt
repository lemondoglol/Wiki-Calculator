package com.example.wikicalculator.apps.fooddash.repos

import com.example.wikicalculator.apps.fooddash.model.MeatAndDiary
import com.example.wikicalculator.apps.fooddash.model.Receipt
import com.example.wikicalculator.apps.fooddash.model.Seasoning
import com.example.wikicalculator.apps.fooddash.model.Veggies

fun buildReceipt(): List<Receipt> {
    val tomatoEgg = Receipt(
        name = "Tomato Egg",
        seasonings = mapOf(
            Seasoning.Salt to "1g for egg, 4g for others",
            Seasoning.SoySauce to "5g",
        ),
        veggies = mapOf(
            Veggies.Tomato to "3",
            Veggies.GreenOnion to "2"
        ),
        meatAndDiary = mapOf(
            MeatAndDiary.Eggs to "3",
        ),
    )

    return listOf(tomatoEgg)
}