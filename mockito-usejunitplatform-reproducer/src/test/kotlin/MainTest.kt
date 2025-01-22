import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.anyOrNull
import com.nhaarman.mockito_kotlin.eq
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
import kotlin.test.Ignore
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MainTest {
    private val service: Service = mock()
    private lateinit var  repository: RepositoryImpl
    private val logger = Logger(Logger.MESSAGE)

    @BeforeEach
    fun setUp() {
        repository = RepositoryImpl(service)
    }

    @Test
    @Ignore
    fun `Initial test implementation`() = runBlocking {
        Mockito.`when`(
            service.getValue(
                logger = any(),
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

    @Test
    fun `Fixed test with any() when mocking`() = runBlocking {
        Mockito.`when`(
            service.getValue(
                logger = any(), //you can also use anyOrNull() here, if you're expecting a null for whatever reason
                request = any()
            )
        ).thenReturn("Mocked value")
        assertEquals(
            "Mocked value",
            repository.getValueFromService(
                Request(1, "Test")
            )
        )
    }

    @Test
    fun `Fixed test with equal checks when mocking`() = runBlocking {
        Mockito.`when`(
            service.getValue(
                logger = eq(logger),
                request = eq(Request(1, "Test"))
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