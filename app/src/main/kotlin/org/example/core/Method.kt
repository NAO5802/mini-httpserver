package org.example.core

enum class Method {
    GET;
}

fun Method.asRouter() = Router()
