package com.tfg.ocupaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tfg.ocupaciones.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}