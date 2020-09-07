/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author davidmp
 */
@Data
@Entity
@Table(name = "serv_persona_puesto")
public class ServPersonaPuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona_puesto")
    private Integer idPersonaPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado_persona_puesto")
    private String estadoPersonaPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonaPuesto")
    @JsonIgnore
    private Collection<ServPuestoRespuesta> servPuestoRespuestaCollection;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private ServPersona idPersona;
    @JoinColumn(name = "id_puesto_periodo", referencedColumnName = "id_puesto_periodo")
    @ManyToOne(optional = false)
    private ServPuestoPeriodo idPuestoPeriodo;

}
