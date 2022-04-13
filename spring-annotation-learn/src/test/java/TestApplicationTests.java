import org.hx.annotation.Client;
import org.hx.annotation.bean.Car;
import org.hx.annotation.bean.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Client.class)
public class TestApplicationTests {
    @Autowired
    private Car car;

    @Autowired
    private Driver driver;

    @Test
    public void contextLoads() {
        boolean result = driver.getCar() == car;
        assertTrue(! result);
    }
}
