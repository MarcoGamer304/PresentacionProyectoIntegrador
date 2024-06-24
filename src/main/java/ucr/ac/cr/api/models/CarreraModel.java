/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name = "carrera")
public class CarreraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String careerCode;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String workingMarket;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String professionalProfile;
    
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UsuarioModel> usuarios;

}
