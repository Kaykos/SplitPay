/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "BILLSXUSERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billsxusers.findAll", query = "SELECT b FROM Billsxusers b")
    , @NamedQuery(name = "Billsxusers.findById", query = "SELECT b FROM Billsxusers b WHERE b.id = :id")
    , @NamedQuery(name = "Billsxusers.findByUsr", query = "SELECT b FROM Billsxusers b WHERE b.usr = :usr")})
public class Billsxusers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "USR")
    private BigInteger usr;
    @JoinColumn(name = "BILL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bill bill;

    public Billsxusers() {
    }

    public Billsxusers(BigDecimal id) {
        this.id = id;
    }

    public Billsxusers(BigDecimal id, BigInteger usr) {
        this.id = id;
        this.usr = usr;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getUsr() {
        return usr;
    }

    public void setUsr(BigInteger usr) {
        this.usr = usr;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billsxusers)) {
            return false;
        }
        Billsxusers other = (Billsxusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Billsxusers[ id=" + id + " ]";
    }
    
}
