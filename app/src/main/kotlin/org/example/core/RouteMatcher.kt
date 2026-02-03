package org.example.core

interface RouteMatcher<R,F> {
    fun match(request: Request): RoutingMatch<R>
}
