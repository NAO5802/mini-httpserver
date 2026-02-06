package org.example.core

interface RouteMatcher<R,F> {
    fun match(request: Request): RoutingMatch<R>
    fun withRouter(other: Router): RouteMatcher<R,F>
    fun withBasePath(prefix: String): RouteMatcher<R,F>
}
