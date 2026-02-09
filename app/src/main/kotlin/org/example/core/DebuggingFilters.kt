package org.example.core

import java.io.PrintStream


object DebuggingFilters {

    object PrintRequest {
        operator fun invoke(out: PrintStream = System.out): Filter = RequestFilters.Tap{req->
            out.println(
                "****REQUEST: ${req.method}: ${req.uri} ****",
            )
        }
    }
}