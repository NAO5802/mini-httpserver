package org.example.core

interface Router {

    companion object{
        operator fun invoke() = object: Router {
        // empty class
        }
    }
}
