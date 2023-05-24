package com.proyecto.ed.service;

import com.proyecto.ed.model.Comment;
import com.proyecto.ed.repository.CasaRepository;
import com.proyecto.ed.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment>list(){
        return commentRepository.findAll();
    }
    public void delete(int id){commentRepository.deleteById(id);}
    public boolean existsByDescripcion(int id){
        return commentRepository.existsById(id);
    }



}
