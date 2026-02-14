package org.example.core

import java.io.InputStream
import java.nio.ByteBuffer

data class MemoryBody(override val payload: ByteBuffer) : Body {
    constructor(payload: String): this(payload.asByteBuffer())
    override val length: Long
        get() = payload.length().toLong()
    override val stream: InputStream
        get() = payload.array().inputStream(payload.position(),payload.length())
    // do nothing
    override fun close() {}
}

private fun ByteArray.asByteBuffer(): ByteBuffer = ByteBuffer.wrap(this)
private fun String.asByteBuffer() : ByteBuffer = toByteArray().asByteBuffer()
private fun ByteBuffer.length(): Int = limit() - position()