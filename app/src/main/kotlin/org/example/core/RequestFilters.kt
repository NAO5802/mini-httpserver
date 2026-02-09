package org.example.core

object RequestFilters {
    object Tap{
        operator fun invoke(fn: (Request)->Unit):Filter = Filter {next -> {
                fn(it)
                next(it)
            }
        }
    }
}
