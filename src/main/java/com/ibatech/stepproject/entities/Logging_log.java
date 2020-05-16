package com.ibatech.stepproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shafa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logging_log")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Logging_log.findAll", query = "SELECT l FROM Logging_log l")
        , @NamedQuery(name = "Logging_log.findById", query = "SELECT l FROM Logging_log l WHERE l.id = :id")
        , @NamedQuery(name = "Logging_log.findByLogDate", query = "SELECT l FROM Logging_log l WHERE l.logDate = :logDate")})
public class Logging_log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;

    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private Users idUser;


}
