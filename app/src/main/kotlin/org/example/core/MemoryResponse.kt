package org.example.core

import org.example.core.Body.Companion.EMPTY

data class MemoryResponse(
    override val status: Status,
    override val body: Body = EMPTY,
) : Response {
    override fun body(body: String) = copy(body = Body(body))

}
