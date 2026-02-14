package org.example.core

import java.io.InputStream

interface Response: HttpMessage {
    val status: Status

    override fun body(body: String): Response
    override fun body(body: InputStream, length: Long?): Response
    override fun headers(headers: Headers): Response

    companion object{
        operator fun invoke(status: Status): Response = MemoryResponse(status)
    }
}
