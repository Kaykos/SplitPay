/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Usersxgrp;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface UsersxgrpFacadeRemote {

    void create(Usersxgrp usersxgrp);

    void edit(Usersxgrp usersxgrp);

    void remove(Usersxgrp usersxgrp);

    Usersxgrp find(Object id);

    List<Usersxgrp> findAll();

    List<Usersxgrp> findRange(int[] range);

    int count();
    
}
