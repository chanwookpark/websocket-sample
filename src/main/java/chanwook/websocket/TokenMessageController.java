package chanwook.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chanwook
 */
@Controller
public class TokenMessageController {

    private final Logger logger = LoggerFactory.getLogger(TokenMessageController.class);

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public TokenMessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @RequestMapping(value = "/token/send-request", method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus sendRequest(@RequestParam String userId, @RequestParam String token) {
        logger.info("[Receive token]userId: " + userId + ", token: " + token);

        //TODO convertAndSendToUser()로 해보기..
        messagingTemplate.convertAndSend("/queue/token-" + userId, token);

        return HttpStatus.OK;
    }
}
