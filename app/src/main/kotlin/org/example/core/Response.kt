package org.example.core

interface Response: HttpMessage {
    val status: Status

    override fun body(body: String): Response

    companion object{
        operator fun invoke(status: Status): Response = MemoryResponse(status)
    }
}
