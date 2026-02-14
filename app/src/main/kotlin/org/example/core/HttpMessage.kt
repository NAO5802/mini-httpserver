package org.example.core

import java.io.Closeable
import java.io.InputStream

interface HttpMessage: Closeable {
    val headers: Headers
    val body: Body

    fun body(body: InputStream, length: Long? = null): HttpMessage
    fun headers(headers: Headers): HttpMessage

    // do nothing
    override fun close() = Unit
}
