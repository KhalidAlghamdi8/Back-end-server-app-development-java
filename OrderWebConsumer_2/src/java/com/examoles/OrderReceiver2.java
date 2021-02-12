/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examoles;

import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author khali
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "client2")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myTopic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/myTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class OrderReceiver2 implements MessageListener {
    
    private final Logger logger = Logger.getLogger(OrderReceiver2.class);
    
    public OrderReceiver2() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            logger.log(Level.SEVERE, message.getBody(String.class));
        } catch (JMSException ex) {
            java.util.logging.Logger.getLogger(OrderReceiver2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
