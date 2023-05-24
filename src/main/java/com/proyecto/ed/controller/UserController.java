package com.proyecto.ed.controller;


import com.proyecto.ed.dto.Mensaje;
import com.proyecto.ed.model.Casa;
import com.proyecto.ed.model.User;
import com.proyecto.ed.repository.UserRepository;
import com.proyecto.ed.service.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/show")
    public ResponseEntity<List<User>> list(){

        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user = userService.getOne(id).get();
        return new ResponseEntity(user, HttpStatus.OK );
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user){
        if(StringUtils.isBlank(user.getEmail())){
            return new ResponseEntity(new Mensaje("email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByEmail(user.getEmail())){
            return new ResponseEntity(new Mensaje("Ese email ya existe"),HttpStatus.BAD_REQUEST);
        }
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFecha(user.getFecha());
        newUser.setEdad(user.getEdad());
        newUser.setPais(user.getPais());
        newUser.setCiudad(user.getCiudad());
        newUser.setTipo_u(user.getTipo_u());

        userService.save(newUser);
        return new ResponseEntity(new Mensaje("Gracias Por Registrarte en EDEN LIFE!!!"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id")int id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity(new Mensaje("Useruai Eliminado"),HttpStatus.OK);
    }

    @GetMapping("/detail/{id}/casas")
    public ResponseEntity<List<Casa>> listCasasUser(@PathVariable("id")int id){
        User user = userService.getOne(id).get();
        return new ResponseEntity(user.getCasas(), HttpStatus.OK );
    }




}
