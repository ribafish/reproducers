package org.example

interface Service {
    suspend fun getValue(logger: Logger, request: Request): String
}