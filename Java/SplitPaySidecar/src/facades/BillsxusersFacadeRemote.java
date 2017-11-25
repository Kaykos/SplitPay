/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Billsxusers;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface BillsxusersFacadeRemote {

    void create(Billsxusers billsxusers);

    void edit(Billsxusers billsxusers);

    void remove(Billsxusers billsxusers);

    Billsxusers find(Object id);

    List<Billsxusers> findAll();

    List<Billsxusers> findRange(int[] range);

    int count();
    
}
