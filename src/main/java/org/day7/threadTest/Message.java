package org.day7.threadTest;

import java.time.LocalTime;

public class Message {
    private String type;
    private String message;
    private LocalTime time;

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message, LocalTime time) {
        this.message = message;
        this.time = time;
    }
}
