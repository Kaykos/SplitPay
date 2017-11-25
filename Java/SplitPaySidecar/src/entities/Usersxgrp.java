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
@Table(name = "USERSXGRP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersxgrp.findAll", query = "SELECT u FROM Usersxgrp u")
    , @NamedQuery(name = "Usersxgrp.findById", query = "SELECT u FROM Usersxgrp u WHERE u.id = :id")
    , @NamedQuery(name = "Usersxgrp.findByUsr", query = "SELECT u FROM Usersxgrp u WHERE u.usr = :usr")})
public class Usersxgrp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "USR")
    private BigInteger usr;
    @JoinColumn(name = "GRP", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Grp grp;

    public Usersxgrp() {
    }

    public Usersxgrp(BigDecimal id) {
        this.id = id;
    }

    public Usersxgrp(BigDecimal id, BigInteger usr) {
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
        if (!(object instanceof Usersxgrp)) {
            return false;
        }
        Usersxgrp other = (Usersxgrp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usersxgrp[ id=" + id + " ]";
    }
    
}
