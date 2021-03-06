package com.ivk23.lms.msg.components;

import com.ivk23.lms.commons.models.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Message message) {
        System.out.println("Received <" + message + ">");
    }

}
