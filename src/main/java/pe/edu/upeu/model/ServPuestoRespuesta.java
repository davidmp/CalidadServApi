/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "serv_puesto_respuesta")
public class ServPuestoRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto_respuesta")
    private Integer idPuestoRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "num_movil")
    private String numMovil;
    @JoinColumn(name = "id_categoria_cliente", referencedColumnName = "id_categoria_cliente")
    @ManyToOne(optional = false)
    private ServCategoriaCliente idCategoriaCliente;
    @JoinColumn(name = "id_persona_puesto", referencedColumnName = "id_persona_puesto")
    @ManyToOne(optional = false)
    private ServPersonaPuesto idPersonaPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuestoRespuesta")
    @JsonIgnore
    private Collection<ServDetalleRespuesta> servDetalleRespuestaCollection;

}
