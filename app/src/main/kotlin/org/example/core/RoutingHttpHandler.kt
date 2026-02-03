package org.example.core

class RoutingHttpHandler(
    routes: List<RouteMatcher<Response, Filter>>
): RoutingHandler<Response, Filter, RoutingHttpHandler>(routes, ::RoutingHttpHandler) {
}
