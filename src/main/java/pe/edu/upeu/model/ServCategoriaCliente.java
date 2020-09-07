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
@Table(name = "serv_categoria_cliente")
public class ServCategoriaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_cliente")
    private Integer idCategoriaCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_c")
    private String nombreC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado_c")
    private String estadoC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion_c")
    private String descripcionC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaCliente")
    @JsonIgnore
    private Collection<ServPuestoRespuesta> servPuestoRespuestaCollection;

}
