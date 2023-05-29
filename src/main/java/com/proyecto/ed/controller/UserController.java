package com.proyecto.ed.controller;


import com.proyecto.ed.dto.Mensaje;
import com.proyecto.ed.dto.UserLogin;
import com.proyecto.ed.model.Casa;
import com.proyecto.ed.model.User;
import com.proyecto.ed.repository.UserRepository;
import com.proyecto.ed.service.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/detaile/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        User user = userService.getByEmail(email).get();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated  @RequestBody UserLogin log ){
        if(!userService.existsByEmail(log.getEmail())){
            return new ResponseEntity<>(new Mensaje("Este email no existe"),HttpStatus.BAD_REQUEST);
        }
        if(!userService.existsByPassword(log.getPassword())){
            return new ResponseEntity<>(new Mensaje("Contraseña incorrecta"),HttpStatus.BAD_REQUEST);
        }
        if(log.getEmail()== null){
            return new ResponseEntity<>(new Mensaje("Email requerido"),HttpStatus.BAD_REQUEST);
        }
        if(log.getPassword()== null){
            return new ResponseEntity<>(new Mensaje("Contraseña requerido"),HttpStatus.BAD_REQUEST);
        }
        if(log.getPassword().isBlank()){
            return new ResponseEntity<>(new Mensaje("Email requerido"),HttpStatus.BAD_REQUEST);
        }
        if(log.getEmail().isBlank()){
            return new ResponseEntity<>(new Mensaje("Email requerido"),HttpStatus.BAD_REQUEST);
        }
        User user = userService.getByEmail(log.getEmail()).get();
        return new ResponseEntity(new Mensaje("Bienvenido a Eden life "+ user.getNombre()),
                HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user){
        if(StringUtils.isBlank(user.getEmail())){
            return new ResponseEntity(new Mensaje("email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByEmail(user.getEmail())){
            return new ResponseEntity(new Mensaje("Ese email ya existe"),HttpStatus.BAD_REQUEST);
        }
//        ,@RequestParam("file")MultipartFile ima agregar vaira al contructor para las imagenes
//        if(!ima.isEmpty()){
//            Path directorioImagenes = Paths.get("src//main//resources//static/imagenes");
//            String rutaA = directorioImagenes.toFile().getAbsolutePath();
//
//            try {
//                byte[] bytesImg = ima.getBytes();
//                Path rutaCompleta = Paths.get(rutaA+"//"+ima.getOriginalFilename());
//                Files.write(rutaCompleta,bytesImg);
//                user.setFtPerfil(ima.getOriginalFilename());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFecha(user.getFecha());
        newUser.setEdad(user.getEdad());
        newUser.setNombre(user.getNombre());
        newUser.setPais(user.getPais());
        newUser.setCiudad(user.getCiudad());
        newUser.setTelefono(user.getTelefono());
        newUser.setFtPerfil(user.getFtPerfil());
        newUser.setEstado(user.getEstado());
        newUser.setTipo_u("user");
        newUser.setEstado(user.getEstado());
        userService.save(newUser);
        return new ResponseEntity(new Mensaje("Gracias Por Registrarte en EDEN LIFE!!!"), HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody User  user,@PathVariable("id")int id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        if(userService.existsByEmail(user.getEmail())){
            return new ResponseEntity(new Mensaje("El email ya esta registrado ingrese otro"),HttpStatus.NOT_FOUND);
        }
        User newUser = userService.getOne(id).get();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFecha(user.getFecha());
        newUser.setEdad(user.getEdad());
        newUser.setPais(user.getPais());
        newUser.setCiudad(user.getCiudad());
        newUser.setTipo_u(user.getTipo_u());
        newUser.setFtPerfil(user.getFtPerfil());
        newUser.setEstado(user.getEstado());
        userService.save(newUser);
        return new ResponseEntity<>(new Mensaje("Usuario modificado"),HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id")int id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity(new Mensaje("Useruai Eliminado"),HttpStatus.OK);
    }

    @GetMapping("/detail/{email}/casas")
    public ResponseEntity<List<Casa>> listCasasUser(@PathVariable("email")String email){
        if (!userService.existsByEmail(email)){
            return  new ResponseEntity(new Mensaje("No se encotro la persona"),HttpStatus.BAD_REQUEST);
        }
        User user = userService.getByEmail(email).get();
        return new ResponseEntity(user.getCasas(), HttpStatus.OK );
    }


}
