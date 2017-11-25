/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Bill;
import facades.BillFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;

/**
 *
 * @author sala_a
 */
@Named(value = "billController")
@SessionScoped
public class BillController implements Serializable {

   private Bill current;
    
    private DataModel items = null;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    @EJB
    private BillFacadeRemote billFacade;

    private List<Bill> listBill;
    
    private BillFacadeRemote getFacade() {
        return billFacade;
    }

    public List<Bill> getListBill() {
        if(listBill == null)
            listBill = billFacade.findAll();
        return listBill;
    }

    public void setListBill(List<Bill> listBill) {
        this.listBill = listBill;
    }
    
    
    
    
    public List<Bill> listBill()
    {
        return this.getListBill();
    }
    
    public Bill billGetNew()
    {
        return new Bill();
    }
    
    
    /**
     * Creates a new instance of beanBill
     */
    public BillController() {
    }
    
    
    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }
    
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }
    
    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }
    
    public String prepareView() {
        current = (Bill) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Bill();
        selectedItemIndex = -1;
        return "Create";
    }
    
    public String prepareEdit() {
        current = (Bill) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }
    
    public String prepareList() {
        recreateModel();
        return "List";
    }
    
    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage("Succsess");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Persistence error ocurred");
        }
    }
    public String destroy() {
        current = (Bill) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }
    
    
    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage("Bill Created");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "PersistenceErrorOccured");
            return null;
        }
    }
    
    public Bill getSelected() {
        if (current == null) {
            current = new Bill();
            selectedItemIndex = -1;
        }
        return current;
    }
    
}
