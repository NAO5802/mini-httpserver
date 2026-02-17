package org.example.core

class TemplatedHttpRoute(
    uriTemplate: UriTemplate, handler: HttpHandler, router: Router = ALL, filter: Filter = Filter.NoOp
    ): TemplatedRoute<Response, Filter, TemplatedHttpRoute>(
    uriTemplate = uriTemplate,
    handler = handler,
    router = router,
    filter = filter
    )
 {
     override fun withBasePath(prefix: String): RouteMatcher<Response, Filter> = TemplatedHttpRoute(uriTemplate.prefixed(prefix), handler,router,filter)
     override fun withRouter(other: Router): RouteMatcher<Response, Filter> = TemplatedHttpRoute(uriTemplate, handler,router.and(other), filter)
 }
