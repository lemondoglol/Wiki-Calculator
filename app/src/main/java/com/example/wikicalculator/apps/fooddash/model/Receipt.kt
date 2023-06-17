package com.example.wikicalculator.apps.fooddash.model

data class Receipt(
    val name: String,
    val seasonings: Map<Seasoning, String>,
    val veggies: Map<Veggies, String>,
    val meatAndDiary: Map<MeatAndDiary, String>,
)

enum class Seasoning(
    override val itemName: String,
    override val itemLink: String,
    override val imageLink: String = "",
): Ingredient {
    BlackPepper(
        itemName = "Black Pepper",
        itemLink = "https://www.amazon.com/s?k=black+peppers&i=wholefoods&crid=6J06V10NTF43&sprefix=black+peppers%2Cwholefoods%2C80&ref=nb_sb_noss_1",
        imageLink = ""
    ),
    WhitePepper(
        itemName = "White Pepper",
        itemLink = "https://www.amazon.com/s?k=white+pepper&i=wholefoods&crid=2YNKHGJLO73QI&sprefix=white+pepper%2Cwholefoods%2C76&ref=nb_sb_noss_2",
        imageLink = ""
    ),
    Ketchup(
        itemName = "Ketchup",
        itemLink = "https://www.amazon.com/s?k=ketchup&i=wholefoods&sprefix=ket%2Cwholefoods%2C78&ref=nb_sb_ss_ts-doa-p_1_3",
    ),
    Garlic(
        itemName = "Garlic",
        itemLink = "https://www.amazon.com/s?k=Garlic&i=wholefoods&crid=3AAW0HWXKM30Z&sprefix=garlic%2Cwholefoods%2C80&ref=nb_sb_noss_1",
    ),
    Salt(
        itemName = "Salt",
        itemLink = "https://www.amazon.com/s?k=salt&i=wholefoods&crid=1VBHWP8W8IFW9&sprefix=salt%2Cwholefoods%2C232&ref=nb_sb_noss_1",
    ),
    SoySauce(
        itemName = "Soy Sauce",
        itemLink = "https://www.amazon.com/s?k=soy+sauce&i=wholefoods&sprefix=soy%2Cwholefoods%2C89&ref=nb_sb_ss_ts-doa-p_1_3",
    ),
}

enum class Veggies(
    override val itemName: String,
    override val itemLink: String,
    override val imageLink: String = "",
): Ingredient {
    Lettuce(
        itemName = "Lettuce",
        itemLink = "https://www.amazon.com/s?k=lettuce&i=wholefoods&sprefix=lettu%2Cwholefoods%2C85&ref=nb_sb_ss_ts-doa-p_1_5",
    ),
    Cabbage(
        itemName = "Cabbage",
        itemLink = "https://www.amazon.com/s?k=cabbage&i=wholefoods&sprefix=Cabbage%2Cwholefoods%2C84&ref=nb_sb_ss_ts-doa-p_1_7",
    ),
    Broccoli(
        itemName = "Broccoli",
        itemLink = "https://www.amazon.com/s?k=broccoli&i=wholefoods&crid=3JFTPTJD9RPWV&sprefix=broccoli%2Cwholefoods%2C80&ref=nb_sb_noss_1",
    ),
    Tomato(
        itemName = "Tomato",
        itemLink = "https://www.amazon.com/s?k=Tomato&i=wholefoods&crid=1323TBHIOPXH1&sprefix=tomato%2Cwholefoods%2C88&ref=nb_sb_noss_1",
    ),
    GreenOnion(
        itemName = "Green Onion",
        itemLink = "https://www.amazon.com/s?k=green+onions&i=wholefoods&sprefix=green+o%2Cwholefoods%2C81&ref=nb_sb_ss_ts-doa-p_1_7",
    )
}

enum class MeatAndDiary(
    override val itemName: String,
    override val itemLink: String,
    override val imageLink: String = "",
): Ingredient {
    Shrimp(
        itemName = "Shrimp",
        itemLink = "https://www.amazon.com/s?k=shrimp&i=wholefoods&crid=I5A5WZO3A6Z4&sprefix=shrimp%2Cwholefoods%2C89&ref=nb_sb_noss_1",
    ),
    Chicken(
        itemName = "Chicken",
        itemLink = "https://www.amazon.com/s?k=Chicken&i=wholefoods&crid=17J6FP40OIVH8&sprefix=chicken%2Cwholefoods%2C84&ref=nb_sb_noss_1",
    ),
    Eggs(
        itemName = "eggs",
        itemLink = "https://www.amazon.com/s?k=egg&i=wholefoods&crid=J19GRCLMU28P&sprefix=egg%2Cwholefoods%2C86&ref=nb_sb_noss_1",
    ),
    Beef(
        itemName = "Beef",
        itemLink = "https://www.amazon.com/s?k=beef&i=wholefoods&crid=271IQ6Z07ZLYB&sprefix=beef%2Cwholefoods%2C132&ref=nb_sb_noss_1",
    ),
}

interface Ingredient {
    val itemName: String
    val itemLink: String
    val imageLink: String
}
