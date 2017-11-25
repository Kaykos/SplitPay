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
@Table(name = "GRP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grp.findAll", query = "SELECT g FROM Grp g")
    , @NamedQuery(name = "Grp.findById", query = "SELECT g FROM Grp g WHERE g.id = :id")
    , @NamedQuery(name = "Grp.findByLeader", query = "SELECT g FROM Grp g WHERE g.leader = :leader")
    , @NamedQuery(name = "Grp.findByName", query = "SELECT g FROM Grp g WHERE g.name = :name")
    , @NamedQuery(name = "Grp.findByStatus", query = "SELECT g FROM Grp g WHERE g.status = :status")})
public class Grp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "LEADER")
    private BigInteger leader;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grp")
    private List<Usersxgrp> usersxgrpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grp")
    private List<Bill> billList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grp")
    private List<Debt> debtList;

    public Grp() {
    }

    public Grp(BigDecimal id) {
        this.id = id;
    }

    public Grp(BigDecimal id, BigInteger leader, String name, String status) {
        this.id = id;
        this.leader = leader;
        this.name = name;
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getLeader() {
        return leader;
    }

    public void setLeader(BigInteger leader) {
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Usersxgrp> getUsersxgrpList() {
        return usersxgrpList;
    }

    public void setUsersxgrpList(List<Usersxgrp> usersxgrpList) {
        this.usersxgrpList = usersxgrpList;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @XmlTransient
    public List<Debt> getDebtList() {
        return debtList;
    }

    public void setDebtList(List<Debt> debtList) {
        this.debtList = debtList;
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
        if (!(object instanceof Grp)) {
            return false;
        }
        Grp other = (Grp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
        //return "entities.Grp[ id=" + id + " ]";
    }
    
}
