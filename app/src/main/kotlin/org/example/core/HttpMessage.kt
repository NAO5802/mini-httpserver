package org.example.core

import java.io.Closeable

interface HttpMessage: Closeable {
    val body: Body

    fun body(body: String): HttpMessage

    // do nothing
    override fun close() = Unit
}
