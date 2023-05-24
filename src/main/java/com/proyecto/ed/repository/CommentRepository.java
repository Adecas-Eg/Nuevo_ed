package com.proyecto.ed.repository;

import com.proyecto.ed.model.Comment;
import com.proyecto.ed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    boolean existsByDescripcion(String descripcion);
}
