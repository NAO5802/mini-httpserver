package org.example.core

class Status internal constructor(override val code: Int): ProtocolStatus {

    companion object {
        val OK = Status(200)
        val NOT_IMPLEMENTED = Status(501)
    }
}
