package org.example

import com.sun.net.httpserver.HttpExchange
import org.example.core.HttpHandler
import org.example.core.Method
import org.example.core.Request
import org.example.core.Response
import org.example.core.Status.Companion.NOT_IMPLEMENTED
import org.example.core.Uri
import org.example.core.supportedOrNull

class HttpExchangeHandler(private val handler: HttpHandler): com.sun.net.httpserver.HttpHandler {
    override fun handle(exchange: HttpExchange) {
       with(exchange){
           try {
               populate(toRequest()?.let(handler) ?: Response(NOT_IMPLEMENTED))
           }catch (e: Exception){
                e.printStackTrace()
                sendResponseHeaders(500, -1)
           }
           finally {
               close()
           }
       }
    }

    private fun HttpExchange.populate(httpResponse: Response) {
        httpResponse.headers.forEach{(key, value)-> responseHeaders.add(key, value?: "")}
        sendResponseHeaders(httpResponse.status.code,httpResponse.body.length ?: 0)
        httpResponse.body.stream.use{input -> responseBody.use{input.copyTo(it)}}
    }

    private fun HttpExchange.toRequest() : Request? =
        Method.supportedOrNull(requestMethod)?.let{
            Request(it, Uri.of(requestURI.rawPath))
            .body(requestBody, requestHeaders.getFirst("Content-Length")?.toLongOrNull())
                .headers(requestHeaders.toList().flatMap { (key, values) -> values.map{key to it} })
        }


}
