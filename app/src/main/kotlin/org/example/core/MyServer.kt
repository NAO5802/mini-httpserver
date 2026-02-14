package org.example.core

interface MyServer: AutoCloseable {
    fun start(): MyServer
    fun port(): Int
    override fun close(){}
}
