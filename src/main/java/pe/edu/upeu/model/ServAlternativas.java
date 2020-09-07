/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author davidmp
 */
@Data
@Entity
@Table(name = "serv_alternativas")
public class ServAlternativas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alternativas")
    private Integer idAlternativas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_al")
    private String nombreAl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_al")
    private int valorAl;
    @JoinColumn(name = "id_tipo_alternativa", referencedColumnName = "id_tipo_alternativa")
    @ManyToOne(optional = false)
    private ServTipoalternativa idTipoAlternativa;


}
