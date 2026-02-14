package org.example.core

import java.io.InputStream
import java.nio.ByteBuffer

class StreamBody(
    override val stream: InputStream,
    override val length: Long? = null
) : Body {
    override val payload: ByteBuffer by lazy {stream.use{ ByteBuffer.wrap(it.readBytes()) }}
    override fun close() {
        stream.close()
    }
}
