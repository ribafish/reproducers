package org.example

class RepositoryImpl(private val service: Service) {
    suspend fun getValueFromService(request: Request): String {
        return service.getValue(
            logger = Logger(Logger.MESSAGE),
            request = request,
        )
    }
}