package in.prakharsaxena.lifesparkTech;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.data.mongodb.host=localhost",
    "spring.data.mongodb.port=27017",
    "spring.data.mongodb.database=lifesparktech_test"
})
class LifesparkTechApplicationTests {

	@Test
	void contextLoads() {
	}

}