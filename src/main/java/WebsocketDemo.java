import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketendpoint")
public class WebsocketDemo {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Session " + session + "opened.");
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("Session " + session + "closed.");
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("Received message: " + message);

        try{
            JsonObject messageObject = new JsonParser().parse(message).getAsJsonObject();
            String response = String.format("Your name is %s, and your occupation is %s.",
                                                messageObject.get("name"),
                                                messageObject.get("occupation"));
            messageObject.addProperty("response",response);
            message = messageObject.toString();
        }catch (Exception e){
            e.printStackTrace();
            return "JSON syntax exception occurred.";
        }

        return message;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }


}
