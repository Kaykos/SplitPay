/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Bill;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface BillFacadeRemote {

    void create(Bill bill);

    void edit(Bill bill);

    void remove(Bill bill);

    Bill find(Object id);

    List<Bill> findAll();

    List<Bill> findRange(int[] range);

    int count();
    
}
