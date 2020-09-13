package com.localazy.collect

import io.javalin.Javalin
import java.io.File

fun main() {

    val app = Javalin.create().start(7000)

    app.post(":path") { ctx ->
        with(ctx) {
            File("data/${pathParam("path")}").apply {
                parentFile.mkdirs()
                writeBytes(bodyAsBytes())
            }
            result("OK")
        }
    }

    app.get(":path") { ctx ->
        val file = File("data/${ctx.pathParam("path")}")
        with(ctx) {
            if (file.exists()) {
                contentType("application/octet-stream")
                result(file.readBytes())
            } else {
                status(404)
                contentType("text/plain")
                result("Not Found.")
            }
        }
    }

}