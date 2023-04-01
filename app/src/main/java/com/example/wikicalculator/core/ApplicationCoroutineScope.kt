package com.example.wikicalculator.core

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class ApplicationCoroutineScope(context: CoroutineContext) : CoroutineScope {
    override val coroutineContext: CoroutineContext = context
}