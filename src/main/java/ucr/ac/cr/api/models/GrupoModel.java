/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Marco
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "grupo")
public class GrupoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String cupo;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String horario_entrada;

    @Column(nullable = false)
    private String horario_salida;

    @Column(nullable = false)
    private String fecha_creacion;

    @Column(nullable = false)
    private String dias;
}
