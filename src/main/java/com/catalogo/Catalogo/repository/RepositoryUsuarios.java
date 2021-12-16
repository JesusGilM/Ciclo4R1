package com.catalogo.Catalogo.repository;

import com.catalogo.Catalogo.model.Usuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.catalogo.Catalogo.repository.crud.InterfaceUsuarios;

/**
 *
 * @JGil @version 1
 */

@Repository
public class RepositoryUsuarios {
    @Autowired
    private InterfaceUsuarios crUsuarios;
    
    public List<Usuarios> getAll(){
        return (List<Usuarios>) crUsuarios.findAll();
    }
    
    public Optional <Usuarios> getUser(int id){
        return crUsuarios.findById(id);
    }
    
    public Usuarios save(Usuarios user){
        return crUsuarios.save(user);
    }
    
    public void delete(int idUser){
        crUsuarios.deleteById(idUser);
    }
    
    public Optional <Usuarios> getUserByEmail(String email){
        return crUsuarios.findByEmail(email);
    }
    
    public Optional <Usuarios> getUserEmailPass(String email, String password){
        return crUsuarios.findByEmailAndPassword(email, password);
    }
}
