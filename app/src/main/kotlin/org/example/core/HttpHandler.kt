package org.example.core

typealias HttpHandler = (request: Request)->Response

fun HttpHandler.asServer(config: ServerConfig): MyServer = config.toServer(this)