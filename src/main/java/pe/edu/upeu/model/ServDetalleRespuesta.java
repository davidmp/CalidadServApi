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

/**
 *
 * @author davidmp
 */
@Data
@Entity
@Table(name = "serv_detalle_respuesta")
public class ServDetalleRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_respuesta")
    private Integer idDetalleRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_cal")
    private int valorCal;
    @JoinColumn(name = "id_preguntas", referencedColumnName = "id_preguntas")
    @ManyToOne(optional = false)
    private ServPreguntas idPreguntas;
    @JoinColumn(name = "id_puesto_respuesta", referencedColumnName = "id_puesto_respuesta")
    @ManyToOne(optional = false)
    private ServPuestoRespuesta idPuestoRespuesta;

 
}
