package com.mt.sample.test;

import com.mt.sample.HelloWorldController;
import com.mt.sample.MainApplication; // Add the main application class import
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MainApplication.class) // Specify the main application class here
public class HelloWorldControllerTest {

    private final HelloWorldController controller = new HelloWorldController();

    @Test
    public void testHelloWorld() {
        String result = controller.helloWorld();
        assertEquals("Hello, DevOps World!", result);
    }
}


