/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Debt;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface DebtFacadeRemote {

    void create(Debt debt);

    void edit(Debt debt);

    void remove(Debt debt);

    Debt find(Object id);

    List<Debt> findAll();

    List<Debt> findRange(int[] range);

    int count();
    
}
