package chanwook.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author chanwook
 */
@Controller
public class GreetingMessageController {

    private final Logger logger = LoggerFactory.getLogger(GreetingMessageController.class);

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingRepresentation greeting(HelloMessage message) {

        logger.info("Receive message: " + message + " -> send to greeting!");

        return new GreetingRepresentation("Greeting ~ " + message);
    }
}
