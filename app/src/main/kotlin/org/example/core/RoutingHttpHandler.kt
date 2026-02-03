package org.example.core

class RoutingHttpHandler(
    routes: List<RouteMatcher<Response, Filter>>
): RoutingHandler<Response, Filter, RoutingHttpHandler>(routes, ::RoutingHttpHandler) {
}

fun routes(vararg list: RoutingHttpHandler): RoutingHttpHandler = routes(list.toList())
fun routes(routers: List<RoutingHttpHandler>): RoutingHttpHandler = RoutingHttpHandler(routers.flatMap { it.routes })