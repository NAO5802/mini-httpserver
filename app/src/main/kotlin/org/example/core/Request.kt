package org.example.core

import java.io.InputStream

interface Request: HttpMessage {
    val method: Method
    val uri: Uri

    override fun body(body: InputStream, length: Long?): Request
    override fun headers(headers: Headers): Request

    companion object {
        operator fun invoke(method: Method, uri: Uri): Request =
            MemoryRequest(method, uri)
    }
}
