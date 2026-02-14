package org.example.core

import java.io.Closeable
import java.io.InputStream
import java.nio.ByteBuffer

interface Body: Closeable {
    val payload: ByteBuffer
    val length: Long?
    val stream: InputStream

    companion object{
        val EMPTY: Body = MemoryBody(ByteBuffer.allocate(0))
        operator fun invoke(body: String): Body = MemoryBody(body)
        operator fun invoke(body: InputStream, length: Long? = null): Body = StreamBody(body,length)
    }
}
