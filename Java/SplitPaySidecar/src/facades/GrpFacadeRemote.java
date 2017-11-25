/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Grp;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface GrpFacadeRemote {

    void create(Grp grp);

    void edit(Grp grp);

    void remove(Grp grp);

    Grp find(Object id);

    List<Grp> findAll();

    List<Grp> findRange(int[] range);

    int count();
    
}
