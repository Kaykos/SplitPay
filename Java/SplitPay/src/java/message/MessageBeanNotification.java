/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import integration.NetClient;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author sala_a
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QueueNotifications")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageBeanNotification implements MessageListener {
    
    public MessageBeanNotification() {
    }
    
    @Override
    public void onMessage(Message message) {
        NetClient nc = new NetClient();
        nc.translate();
    }
    
}
