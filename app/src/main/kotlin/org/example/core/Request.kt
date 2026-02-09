package org.example.core

interface Request: HttpMessage {
    val method: Method
    val uri: Uri
}
