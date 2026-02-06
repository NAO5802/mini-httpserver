package org.example.core

import java.nio.ByteBuffer

data class MemoryBody(override val payload: ByteBuffer) : Body {
    constructor(payload: String): this(payload.asByteBuffer())
    // do nothing
    override fun close() {}
}

private fun ByteArray.asByteBuffer(): ByteBuffer = ByteBuffer.wrap(this)
private fun String.asByteBuffer() : ByteBuffer = toByteArray().asByteBuffer()