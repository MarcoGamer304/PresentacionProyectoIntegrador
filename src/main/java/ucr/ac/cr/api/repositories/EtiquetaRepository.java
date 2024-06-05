/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.api.models.EtiquetaModel;

/**
 *
 * @author Marco
 */
@Repository
public interface EtiquetaRepository extends CrudRepository<EtiquetaModel,Long> {
    
}
