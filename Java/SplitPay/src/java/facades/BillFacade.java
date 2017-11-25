/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Bill;
import integration.NetClient;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class BillFacade extends AbstractFacade<Bill> implements BillFacadeRemote {

    @Resource(mappedName = "jms/QueueNotifications")
    private Queue queueNotifications;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

   

    @PersistenceContext(unitName = "SplitPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillFacade() {
        super(Bill.class);
    }
    
    @Override
    public void create(Bill entity) {
        
        getEntityManager().persist(entity);
        sendJMSMessageToQueueNotifications(entity);
    }
    
    private void sendJMSMessageToQueueNotifications(Bill bill) {
        context.createProducer().send(queueNotifications, bill);
    }
    
   
    
    
}
