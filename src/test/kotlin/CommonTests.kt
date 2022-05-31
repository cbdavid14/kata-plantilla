import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
abstract class CommonTests {

    @Autowired
    protected lateinit var mockMvc: MockMvc
}
