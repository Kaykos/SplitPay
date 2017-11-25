/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Usersxgrp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class UsersxgrpFacade extends AbstractFacade<Usersxgrp> implements facades.UsersxgrpFacadeRemote {

    @PersistenceContext(unitName = "SplitPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersxgrpFacade() {
        super(Usersxgrp.class);
    }
    
}
