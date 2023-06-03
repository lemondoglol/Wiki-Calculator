package com.example.wikicalculator.core.extensions

fun Float.formatToString(): String {
    return if (this == 0f) "" else this.toString()
}