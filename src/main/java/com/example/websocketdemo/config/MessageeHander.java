package com.example.websocketdemo.config;

import com.alibaba.fastjson.JSON;
import com.example.websocketdemo.pojo.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageeHander extends TextWebSocketHandler {

    public static final Map<String,WebSocketSession> SESSION_MAP = new HashMap<>();

    //刚进入websocket的方法
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String name = session.getAttributes().get("name").toString();
        SESSION_MAP.put(name,session);

    }
    //关闭websocket
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
    //推送消息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Message msg = JSON.parseObject(payload, Message.class);
        String to = msg.getTo();
        WebSocketSession webSocketSession = SESSION_MAP.get(to);
        if (webSocketSession != null){
            webSocketSession.sendMessage(new TextMessage(msg.getMsg()));
        }

















        //System.out.println(message.getPayload());
//        WebSocketSession aabb = SESSION_MAP.get("aabb");
//        if (aabb !=null){
//            session.sendMessage(new TextMessage("aabbccdd"));
//        }
    }
}
