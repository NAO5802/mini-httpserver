package org.example.core

data class RoutingMatch<R>(
    private val priority: Int,
    private val handler: (Request)->R
) : Comparable<RoutingMatch<R>>, (Request)->R by handler{
    override fun compareTo(other: RoutingMatch<R>): Int = priority.compareTo(other.priority)
}
