package org.example.core

abstract class RoutingHandler<R,F,Self: RouteMatcher<R,F>>(
    val routes: List<RouteMatcher<R,F>>,
    private val copy: (List<RouteMatcher<R,F>>) -> Self
)
    :(Request)->R, RouteMatcher<R,F> {
    override fun invoke(request: Request): R = match(request)(request)
    override fun match(request: Request): RoutingMatch<R> = routes.minOf{it.match(request)}
}