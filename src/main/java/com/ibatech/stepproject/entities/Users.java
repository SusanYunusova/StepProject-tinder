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

    @OneToMany(mappedBy = "idUser")
    private List<Logging_log> logging_logList;

    @OneToMany(mappedBy = "idUserFrom")
    private List<Messages> messagesList;

    @OneToMany(mappedBy = "idUserTo")
    private List<Messages> messagesList1;

    @OneToMany(mappedBy = "idUserFrom")
    private List<Likes> likesListFrom;

    @OneToMany(mappedBy = "idUserTo")
    private List<Likes> likesListTo;







}