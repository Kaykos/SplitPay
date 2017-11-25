/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Debtpayroll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class DebtpayrollFacade extends AbstractFacade<Debtpayroll> implements facades.DebtpayrollFacadeRemote {

    @PersistenceContext(unitName = "SplitPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DebtpayrollFacade() {
        super(Debtpayroll.class);
    }
    
}
