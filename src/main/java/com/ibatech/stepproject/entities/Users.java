package com.ibatech.stepproject.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Suzy&Shafa
 */

@Data
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
        , @NamedQuery(name = "Users.findByAge", query = "SELECT u FROM Users u WHERE u.age = :age")
        , @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
        , @NamedQuery(name = "Users.findAllByEmailAndPassword", query = "SELECT u from  Users u WHERE u.email = :email and u.password = :password")})
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
    @Column(name = "gender")
    private String gender;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "job_title")
    private String jobTitle;

    @OneToOne(mappedBy = "idUser")
    private Logging_log logging_log;

    @OneToMany(mappedBy = "idUserFrom")
    private List<Messages> messagesListFrom;

    @OneToMany(mappedBy = "idUserTo")
    private List<Messages> messagesListTo;

    @OneToMany(mappedBy = "idUserFrom")
    private List<Likes> likesListFrom;

    @OneToMany(mappedBy = "idUserTo")
    private List<Likes> likesListTo;


    public String getFullName(){
        return  name+" "+surname;
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