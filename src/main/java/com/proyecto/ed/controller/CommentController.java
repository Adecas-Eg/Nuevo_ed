package com.proyecto.ed.controller;

import com.proyecto.ed.dto.Mensaje;
import com.proyecto.ed.model.Casa;
import com.proyecto.ed.model.Comment;
import com.proyecto.ed.service.CommentService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/show")
    public ResponseEntity<List<Comment>> list(){
        return new ResponseEntity<>(commentService.list(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Comment comment ){
        if(StringUtils.isBlank(comment.getDescripcion())){
            return new ResponseEntity(new Mensaje("Campos invaidos"),HttpStatus.BAD_REQUEST);
        }
        if(commentService.existsByDescripcion(comment.getId())){
            return new ResponseEntity(new Mensaje("Campos invaidos"),HttpStatus.BAD_REQUEST);
        }
        return  null;
    }







}
