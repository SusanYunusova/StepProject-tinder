package com.ibatech.stepproject.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author heisenberg
 */

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
        , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
        , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
        , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
        , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
        , @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname")
        , @NamedQuery(name = "Users.findByAge", query = "SELECT u FROM Users u WHERE u.age = :age")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @OneToMany(mappedBy = "idUser")
    private List<Logging_log> logging_logList;
    @OneToMany(mappedBy = "idUserFrom")
    private List<Messages> messagesList;
    @OneToMany(mappedBy = "idUserTo")
    private List<Messages> messagesList1;
    @OneToMany(mappedBy = "idUserFrom")
    private List<Likes> likesList;
    @OneToMany(mappedBy = "idUserTo")
    private List<Likes> likesList1;

    public Users(Integer id) {
        this.id = id;
    }



    @XmlTransient
    public List<Logging_log> getLoggingLogList() {
        return logging_logList;
    }

    public void setLoggingLogList(List<Logging_log> logging_logList) {
        this.logging_logList = logging_logList;
    }

    @XmlTransient
    public List<Messages> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    @XmlTransient
    public List<Messages> getMessagesList1() {
        return messagesList1;
    }

    public void setMessagesList1(List<Messages> messagesList1) {
        this.messagesList1 = messagesList1;
    }

    @XmlTransient
    public List<Likes> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<Likes> likesList) {
        this.likesList = likesList;
    }

    @XmlTransient
    public List<Likes> getLikesList1() {
        return likesList1;
    }

    public void setLikesList1(List<Likes> likesList1) {
        this.likesList1 = likesList1;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


}