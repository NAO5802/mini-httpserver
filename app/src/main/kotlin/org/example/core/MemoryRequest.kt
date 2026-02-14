package org.example.core

import org.example.core.Body.Companion.EMPTY
import java.io.InputStream

data class MemoryRequest(
    override val method: Method,
    override val uri: Uri,
    override val headers: Headers = listOf(),
    override val body: Body = EMPTY
) : Request {
    override fun body(body: InputStream, length: Long?): Request = copy(body = Body(body, length))
    override fun headers(headers: Headers): Request = copy(headers = this.headers + headers)
}
