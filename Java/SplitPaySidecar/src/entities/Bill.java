/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "BILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
    , @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id")
    , @NamedQuery(name = "Bill.findByTitle", query = "SELECT b FROM Bill b WHERE b.title = :title")
    , @NamedQuery(name = "Bill.findByCost", query = "SELECT b FROM Bill b WHERE b.cost = :cost")
    , @NamedQuery(name = "Bill.findByLocation", query = "SELECT b FROM Bill b WHERE b.location = :location")
    , @NamedQuery(name = "Bill.findByType", query = "SELECT b FROM Bill b WHERE b.type = :type")
    , @NamedQuery(name = "Bill.findByNote", query = "SELECT b FROM Bill b WHERE b.note = :note")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "COST")
    private BigInteger cost;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "NOTE")
    private String note;
    @JoinColumn(name = "GRP", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Grp grp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<Billsxusers> billsxusersList;

    public Bill() {
    }

    public Bill(BigDecimal id) {
        this.id = id;
    }

    public Bill(BigDecimal id, String title, BigInteger cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Grp getGrp() {
        return grp;
    }

    public void setGrp(Grp grp) {
        this.grp = grp;
    }

    @XmlTransient
    public List<Billsxusers> getBillsxusersList() {
        return billsxusersList;
    }

    public void setBillsxusersList(List<Billsxusers> billsxusersList) {
        this.billsxusersList = billsxusersList;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bill[ id=" + id + " ]";
    }
    
}
