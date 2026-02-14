package org.example.core

enum class Method {
    GET;

    companion object
}

fun Method.asRouter() = Router()

fun Method.Companion.supportedOrNull(method: String): Method? = runCatching { Method.valueOf(method) }.getOrNull()