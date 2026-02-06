package org.example.core

import java.io.Closeable
import java.nio.ByteBuffer

interface Body: Closeable {
    val payload: ByteBuffer

    companion object{
        operator fun invoke(body: String): Body = MemoryBody(body)
        val EMPTY: Body = MemoryBody(ByteBuffer.allocate(0))
    }
}
