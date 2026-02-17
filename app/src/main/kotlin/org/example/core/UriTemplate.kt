package org.example.core

@ConsistentCopyVisibility
data class UriTemplate private constructor(private val template: String) {

    fun prefixed(prefix: String): UriTemplate = from("$prefix/$template")

    companion object{
        fun from(template: String): UriTemplate = UriTemplate(template.trimSlashes())
        private fun String.trimSlashes(): String = "^(/+)?(.*?)(/+)?$".toRegex().replace(this) { result -> result.groupValues[2] }
    }
}


