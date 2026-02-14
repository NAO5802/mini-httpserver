package org.example.core

data class Uri(val path: String) {

    companion object{
        private val RFC3986 = Regex("^(?:([^:/?#]+):)?(?://([^/?#]*))?([^?#]*)(?:\\?([^#]*))?(?:#(.*))?")

        fun of(value: String): Uri {
            val result = RFC3986.matchEntire(value) ?: throw RuntimeException("Invalid URI: $value")
            val (_,_,path,_,_) = result.destructured
            return Uri(path)
        }
    }
}
