package org.example.core

fun interface Filter: (HttpHandler)-> HttpHandler {
    companion object
}

val Filter.Companion.NoOp: Filter get() = Filter{it}

fun Filter.then(next: HttpHandler): HttpHandler = this(next)