/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@Table(name = "curso")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String blockBelonging;

    @Column(nullable = false)
    private String teachingHours;

    @Column(nullable = false)
    private String modality;

    @Column(nullable = false)
    private String independentWorkHours;

    @Column(nullable = false)
    private String creditQuantity;

    @Column(unique = true, nullable = false)
    private String initials;
    
    //@JsonIgnore
    @JsonIgnoreProperties("cursos")
    @ManyToMany(mappedBy = "cursos")
    private List<PlanEstudioModel> planesEstudio = new ArrayList<>();
}
