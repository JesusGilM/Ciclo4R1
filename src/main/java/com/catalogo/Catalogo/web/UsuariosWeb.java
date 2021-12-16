package com.catalogo.Catalogo.web;

import com.catalogo.Catalogo.model.Usuarios;
import com.catalogo.Catalogo.service.ServiceUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @JGil @version 1
 */


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuariosWeb {
    
    @Autowired
    private ServiceUsuarios serUsuarios;
    
    @GetMapping("/all")
    public List<Usuarios> getUser(){
        return serUsuarios.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios save(@RequestBody Usuarios user){
        return serUsuarios.save(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios update(@RequestBody Usuarios user){
        return serUsuarios.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idUser){
        return serUsuarios.delete(idUser);
    }
    
    @GetMapping("/{email}")
    public boolean getValUserEmail(@PathVariable("email") String email){
        return serUsuarios.getUserEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public Optional<Usuarios> getValUserEmailPass(@PathVariable("email") String email, @PathVariable("password") String password){
        return serUsuarios.getUserEmailPass(email, password);
    }
}
