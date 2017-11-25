/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Billsxusers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class BillsxusersFacade extends AbstractFacade<Billsxusers> implements facades.BillsxusersFacadeRemote {

    @PersistenceContext(unitName = "SplitPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillsxusersFacade() {
        super(Billsxusers.class);
    }
    
}
