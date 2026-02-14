package org.example.core

import org.example.core.Body.Companion.EMPTY
import java.io.InputStream

data class MemoryResponse(
    override val status: Status,
    override val body: Body = EMPTY,
    override val headers: Headers = listOf()
) : Response {

    override fun body(body: String) = copy(body = Body(body))
    override fun body(body: InputStream, length: Long?) = copy(body= Body(body,length))
    override fun headers(headers: Headers) =copy(headers= this.headers + headers)


}
