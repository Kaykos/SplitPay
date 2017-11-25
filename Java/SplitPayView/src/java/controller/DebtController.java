/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Debt;
import integration.NetClient;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import jsf.util.JsfUtil;

/**
 *
 * @author sala_a
 */
@Named(value = "debtController")
@SessionScoped
public class DebtController implements Serializable {

    private Debt current;
    
    public String prepareCreate() {
        current = new Debt();
        return "Create";
    } 
    
    
    
    public void pay(){
        
    }
}
