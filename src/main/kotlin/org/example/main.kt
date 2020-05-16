package org.example

fun main() {
    do {
        val line = readLine()
        if (line != null) {
            val tokenizer = Tokenizer(line)
            do {
                val token = tokenizer.nextToken()
                println(token)
            } while (token !is EOFToken)
        }
    } while (line != null && line != "")
}