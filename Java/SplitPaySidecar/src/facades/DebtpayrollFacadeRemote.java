/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Debtpayroll;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface DebtpayrollFacadeRemote {

    void create(Debtpayroll debtpayroll);

    void edit(Debtpayroll debtpayroll);

    void remove(Debtpayroll debtpayroll);

    Debtpayroll find(Object id);

    List<Debtpayroll> findAll();

    List<Debtpayroll> findRange(int[] range);

    int count();
    
}
