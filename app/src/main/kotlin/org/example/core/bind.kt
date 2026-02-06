package org.example.core

infix fun String.bind(method: Method): PathMethod = PathMethod(this, method)