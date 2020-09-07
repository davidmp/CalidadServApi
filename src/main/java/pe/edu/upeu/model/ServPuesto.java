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
@Table(name = "serv_puesto")
public class ServPuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto")
    private Integer idPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_p")
    private String nombreP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado_p")
    private String estadoP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion_p")
    private String descripcionP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo_p")
    private String codigoP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coord_x")
    private double coordX;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coord_y")
    private double coordY;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuesto")
    @JsonIgnore
    private Collection<ServPuestoPeriodo> servPuestoPeriodoCollection;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private ServNivel idNivel;
    @JoinColumn(name = "id_subarea", referencedColumnName = "id_subarea")
    @ManyToOne(optional = false)
    private ServSubarea idSubarea;

}
