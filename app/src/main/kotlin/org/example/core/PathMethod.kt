package org.example.core

data class PathMethod(val path: String, val method: Method) {
    infix fun to(handler: HttpHandler): RoutingHttpHandler =
        when(handler){
            is RoutingHttpHandler -> handler.withRouter(method.asRouter()).withBasePath(path)
            else -> RoutingHttpHandler(listOf(TemplatedHttpRoute(UriTemplate.from(path),handler,method.asRouter())))
        }

}
