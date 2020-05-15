package com.ibatech.stepproject.entities;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.ws.rs.ext.ParamConverter;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Suzy
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "likes")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l")
        , @NamedQuery(name = "Likes.findByIdLikes", query = "SELECT l FROM Likes l WHERE l.idLikes = :idLikes")
        , @NamedQuery(name = "Likes.findByLikeStatus", query = "SELECT l FROM Likes l WHERE l.likeStatus = :likeStatus")
        , @NamedQuery(name = "Likes.findByDate", query = "SELECT l FROM Likes l WHERE l.date = :date")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLikes")
    private Integer idLikes;
    @Column(name = "like_status")
    private Integer likeStatus;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    @JoinColumn(name = "id_user_from", referencedColumnName = "id")
    @ManyToOne
    private Users idUserFrom;
    @JoinColumn(name = "id_user_to", referencedColumnName = "id")
    @ManyToOne
    private Users idUserTo;






}

