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
@Table(name = "DEBT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Debt.findAll", query = "SELECT d FROM Debt d")
    , @NamedQuery(name = "Debt.findById", query = "SELECT d FROM Debt d WHERE d.id = :id")
    , @NamedQuery(name = "Debt.findByRecipient", query = "SELECT d FROM Debt d WHERE d.recipient = :recipient")
    , @NamedQuery(name = "Debt.findByDebtor", query = "SELECT d FROM Debt d WHERE d.debtor = :debtor")
    , @NamedQuery(name = "Debt.findByValue", query = "SELECT d FROM Debt d WHERE d.value = :value")})
public class Debt implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "RECIPIENT")
    private BigInteger recipient;
    @Basic(optional = false)
    @Column(name = "DEBTOR")
    private BigInteger debtor;
    @Basic(optional = false)
    @Column(name = "VALUE")
    private BigInteger value;
    @JoinColumn(name = "GRP", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Grp grp;

    public Debt() {
    }

    public Debt(BigDecimal id) {
        this.id = id;
    }

    public Debt(BigDecimal id, BigInteger recipient, BigInteger debtor, BigInteger value) {
        this.id = id;
        this.recipient = recipient;
        this.debtor = debtor;
        this.value = value;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRecipient() {
        return recipient;
    }

    public void setRecipient(BigInteger recipient) {
        this.recipient = recipient;
    }

    public BigInteger getDebtor() {
        return debtor;
    }

    public void setDebtor(BigInteger debtor) {
        this.debtor = debtor;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Grp getGrp() {
        return grp;
    }

    public void setGrp(Grp grp) {
        this.grp = grp;
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
        if (!(object instanceof Debt)) {
            return false;
        }
        Debt other = (Debt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Debt[ id=" + id + " ]";
    }
    
}
