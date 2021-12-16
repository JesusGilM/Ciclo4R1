package com.catalogo.Catalogo.repository.crud;

import com.catalogo.Catalogo.model.Usuarios;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @JGil @version 1
 */

public interface InterfaceUsuarios extends CrudRepository<Usuarios, Integer>{
    
    public Optional <Usuarios> findByEmail(String email);
    
    public Optional <Usuarios> findByEmailAndPassword(String email, String password);
}
