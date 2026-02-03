package org.example.core

interface Filter: (HttpHandler)-> HttpHandler {
    companion object
}
