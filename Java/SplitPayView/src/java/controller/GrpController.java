/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Grp;
import facades.GrpFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import jsf.util.JsfUtil;

/**
 *
 * @author guerrerojosedario
 */
@Named(value = "grpController")
@SessionScoped
public class GrpController implements Serializable {

    @EJB
    private GrpFacadeRemote grpFacade;

    
    /**
     * Creates a new instance of GrpController
     */
    public GrpController() {
    }
    
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(grpFacade.findAll(), true);
    }
    
    public Grp getGrp(java.lang.Integer id) {
        return grpFacade.find(new BigDecimal(id));
    }
    
    @FacesConverter(forClass = Grp.class)
    public static class GrpControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GrpController controller = (GrpController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "grpController");
            return controller.getGrp(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Grp) {
                Grp o = (Grp) object;
                return getStringKey(o.getId().intValue());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Grp.class.getName());
            }
        }

    }
}
