package chanwook.websocket;

/**
 * @author chanwook
 */
public class GreetingRepresentation {

    private String content;

    public GreetingRepresentation() {
    }

    public GreetingRepresentation(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
