package com.kadet.conveyor.controller;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AlexSoroka on 4/21/2015.
 */
public class SessionManager {

    private static final SessionManager instance = new SessionManager();

    public static SessionManager getInstance () {
        return instance;
    }

    private SessionManager() {}

    private static final Set<Session> sessions =
            Collections.synchronizedSet(new HashSet<Session>());

    public void addSession (Session session) {
        sessions.add(session);
    }

    public void removeSession (Session session) {
        sessions.remove(session);
    }

    public void notifyAll (String message) throws IOException {
        synchronized(sessions) {
            for (Session session : sessions) {
                if (session.isOpen()) {
                    session.getBasicRemote().sendText(message);
                }
            }
        }
    }

    public void notify (Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

}
