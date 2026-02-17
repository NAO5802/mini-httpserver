package org.example.core

abstract class TemplatedRoute<R,F: ((Request)->R) -> (Request)->R,Self: RouteMatcher<R,F>>(
    protected val uriTemplate: UriTemplate,
    protected val handler: (Request)->R,
    protected val router: Router,
    protected val filter: F,
): RouteMatcher<R,F> {
    // NOTE: temporary implementation
    override fun match(request: Request): RoutingMatch<R> = RoutingMatch(2, handler)
}
