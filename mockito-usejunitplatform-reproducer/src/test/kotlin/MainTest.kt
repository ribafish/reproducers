import com.nhaarman.mockito_kotlin.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.example.Logger
import org.example.RepositoryImpl
import org.example.Request
import org.example.Service
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MainTest {
    private val service: Service = mock()
    private lateinit var  repository: RepositoryImpl
    private val logger = Logger("Test Stuff")

    @BeforeEach
    fun setUp() {
        repository = RepositoryImpl(service)
    }

    @Test
    fun test1() = runBlocking {
        Mockito.`when`(
            service.getValue(
                logger = logger,
                request = Request(1, "Test")
            )
        ).thenReturn("Mocked value")
        assertEquals(
            "Mocked value",
            repository.getValueFromService(
                Request(1, "Test")
            )
        )
    }
}