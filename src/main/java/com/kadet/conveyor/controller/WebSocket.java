package com.kadet.conveyor.controller;

import com.kadet.conveyor.AppBundle;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;

@ServerEndpoint("/websocket")
public class WebSocket {

    private Logger logger = Logger.getLogger(WebSocket.class.getName());

    @OnOpen
    public void onOpen (Session session) {
        logger.info("Client connected: " + session.getId());
        AppBundle.initState();
        SessionManager.getInstance().addSession(session);
    }

	@OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {
        AppBundle.start();
    }

    @OnClose
    public void onClose (Session session, CloseReason closeReason) {
        SessionManager.getInstance().removeSession(session);
        logger.info("Connection closed: " + closeReason.getReasonPhrase());
    }
}
