package org.example.core

interface ServerConfig {
    fun toServer(http: HttpHandler): MyServer
}
