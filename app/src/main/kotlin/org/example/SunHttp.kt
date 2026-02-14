package org.example

import com.sun.net.httpserver.HttpServer
import org.example.core.HttpHandler
import org.example.core.MyServer
import org.example.core.ServerConfig
import java.net.InetSocketAddress
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors.newWorkStealingPool

class SunHttp(private val port: Int = 8000): ServerConfig {

    override fun toServer(http: HttpHandler): MyServer = sunHttpServer(http, port)
}

private fun sunHttpServer(
    http: HttpHandler,
    port: Int,
    executor: ExecutorService = newWorkStealingPool()
    ) = object : MyServer{
    private val server = HttpServer.create(InetSocketAddress(port), 1000)

    override fun start(): MyServer = apply {
        server.createContext("/", HttpExchangeHandler(http))
        server.executor = executor
        server.start()
    }

    override fun port(): Int = if(port > 0) port else server.address.port
}
