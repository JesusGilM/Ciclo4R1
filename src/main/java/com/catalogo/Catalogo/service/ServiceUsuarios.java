package com.catalogo.Catalogo.service;

import com.catalogo.Catalogo.model.Usuarios;
import com.catalogo.Catalogo.repository.RepositoryUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @JGil @version 1
 */

@Service
public class ServiceUsuarios {
    /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired    
    private RepositoryUsuarios mCrUsuarios;
    
    /**
     * metodo para obtener todos los datos de la tabla Usuarios
     *
     * @return List de clase Reservacion
     */
    public List<Usuarios> getAll(){
        return mCrUsuarios.getAll();
    }
    
    /**
     * metodo para obtener dato de la tabla Usuarios por Id
     *
     * @param idUser
     * @return Optional de clase Reservacion
     */
    public Optional<Usuarios> getUser(int idUser){
        return mCrUsuarios.getUser(idUser);
    }
    
    /**
     * metodo para registrar valores en la tabla reservaciones
     *
     * @param user
     * @return valor de calse Reservacion
     */    
    public Usuarios save(Usuarios user){
        if (user.getId()== null) {
            return mCrUsuarios.save(user);
        }else{
            Optional<Usuarios> evt = mCrUsuarios.getUser(user.getId());
            if(evt.isEmpty()){
                return mCrUsuarios.save(user);
            }else{
                return user;
            }
        }
    }
    
    /**
     * metodo para actualizar un dato de la tabla Reservaciones
     * @param user
     * @return valor de calse Reservacion
     */
    public Usuarios update(Usuarios user){
        if(user.getId()!= null){
            Optional<Usuarios> evt = mCrUsuarios.getUser(user.getId());
            if(!evt.isEmpty()){
                if(user.getEmail() != null){
                    evt.get().setEmail(user.getEmail());
                }
                
                if(user.getPassword() != null){
                    evt.get().setPassword(user.getPassword());
                }
                
                if(user.getName() != null){
                    evt.get().setName(user.getName());
                }
            }
            
            return mCrUsuarios.save(evt.get());
        }
        return user;
    }
    
    /**
     * metodo para borrar un dato de la tabla Reservaciones por Id
     * @param idUser
     * @return boolean
     */
    public boolean delete(int idUser){
        Optional<Usuarios> evt = mCrUsuarios.getUser(idUser);
        if(!evt.isEmpty()){
            mCrUsuarios.delete(idUser);
            return true;
        }
        
        return false;
    }
    
    /**
     * Metodo para adquirir status
     * @param email
     * @return boolean
     */
    public boolean getUserEmail(String email){
        Optional<Usuarios> evt = mCrUsuarios.getUserByEmail(email);
        return !evt.isEmpty();
    }
    
    /**
     * metodo para reporte de Usuarios
     * @param email
     * @param password
     * @return boolean
     */
    public Optional<Usuarios> getUserEmailPass(String email, String password){
        
        //JsonObject json =
        
        Optional<Usuarios> evt = mCrUsuarios.getUserEmailPass(email, password);
        if(!evt.isEmpty()){
            return mCrUsuarios.getUserEmailPass(email, password);
        }else{
            Usuarios usuario = new Usuarios();
            usuario.setId(null);
            usuario.setEmail("corazondeleon@gmail.com");
            usuario.setPassword("Demo123.");
            usuario.setName("NO DEFINIDO");
            
            Optional<Usuarios> evt1 = Optional.of(usuario);
            
            return evt1;
        }
    }
}