package com.proyecto.CostaBuses.Repository;

import com.proyecto.CostaBuses.Model.Usuario;
import com.proyecto.CostaBuses.Model.dto.Usuariodto;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<Usuario, Integer>
{
    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    Usuario getById(Integer id);

    boolean existsById(Integer id);

    Usuario getByName(String name);

    boolean existsByCorreo(String correo);

   Optional<Usuario>  findByCorreo(String correo);

    Usuario findById(int id);

    boolean existsByPassword(String password);

     Usuario getByCorreo(String correo);
}
