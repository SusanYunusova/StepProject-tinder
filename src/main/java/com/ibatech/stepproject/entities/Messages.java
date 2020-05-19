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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Suzy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m")
        , @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id")
        , @NamedQuery(name = "Messages.findByFromTo", query = "SELECT m FROM Messages m WHERE (m.idUserFrom = :userFrom " +
        "and m.idUserTo = :userTo ) or (m.idUserFrom = :userTo  and m.idUserTo = :userFrom) ")
        , @NamedQuery(name = "Messages.findByDate", query = "SELECT m FROM Messages m WHERE m.date = :date")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob//large database object
    @Column(name = "message")
    private String message;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @JoinColumn(name = "id_user_from", referencedColumnName = "id")
    @ManyToOne
    private Users idUserFrom;
    @JoinColumn(name = "id_user_to", referencedColumnName = "id")
    @ManyToOne
    private Users idUserTo;


}
