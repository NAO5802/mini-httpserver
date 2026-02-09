package org.example.core

fun interface Filter: (HttpHandler)-> HttpHandler {
    companion object
}

fun Filter.then(next: HttpHandler): HttpHandler = this(next)