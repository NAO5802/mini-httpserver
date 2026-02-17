package org.example.core

interface Router {

    companion object{
        operator fun invoke() = object: Router {
        // empty class
        }
    }
}

val ALL = Router()

fun Router.and(other: Router):Router = when(this){
    ALL -> other
    else -> when(other){
        ALL -> this
        else -> Router()
    }
}