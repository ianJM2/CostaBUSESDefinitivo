package com.proyecto.CostaBuses.Service;

import com.proyecto.CostaBuses.Model.Usuario;
import com.proyecto.CostaBuses.Model.dto.Usuariodto;
import com.proyecto.CostaBuses.Repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService
{
    @Autowired
    private UserJpaRepository userJpaRepository;

    public List<Usuario> findAll()
    {
        return userJpaRepository.findAll();
    }

    public Usuario add(Usuariodto usuariodto)
    {
        if(userJpaRepository.existsByCorreo(usuariodto.getCorreo()))
        {
            return null;
        }
        else {
            if (usuariodto.getName() == null || usuariodto.getCorreo() == null || usuariodto.getPassword() == null) {
                return null;
            }
        }

        Usuario userTemp = new Usuario();
        userTemp.setName(usuariodto.getName());
        userTemp.setCorreo(usuariodto.getCorreo());
        userTemp.setPassword(usuariodto.getPassword());

        return userJpaRepository.save(userTemp);


    }

    public Usuario getById(Integer id) {
        Usuario user = userJpaRepository.findById(id.intValue());
        if (user != null) {
            return user;
        }
        /*if (repository.existsById(id)) {
            return repository.findById(id).get();
        }*/
        return null;
    }

    public Usuario update(Usuariodto usuariodto) {
        Optional<Usuario> userExits = userJpaRepository.findByCorreo(usuariodto.getCorreo());
        System.out.println(userExits.get().getCorreo());
        Usuario nuevoUser = new Usuario();
        if (userExits.isPresent()) {
            if (usuariodto.getName() != null) {
                nuevoUser.setName(usuariodto.getName());
            }
            if (usuariodto.getPassword() != null) {
                nuevoUser.setPassword(usuariodto.getPassword());
            }

        } else {
            return null;
        }

        return userJpaRepository.save(nuevoUser);
    }

    public Usuario delete(Integer id) {
        Optional<Usuario> userExits = userJpaRepository.findById(id);
        if (userExits.isPresent()) {
            userJpaRepository.deleteById(id);
            return (Usuario) userExits.get();
        } else {
            return null;
        }
    }

    public Usuario changePassword(String correo, String newPassword) {
        Usuario userExits = userJpaRepository.getByCorreo(correo);
        if (userExits != null) {
            userExits.setPassword(newPassword);
            return userJpaRepository.save(userExits);
        } else {
            return null;
        }



    }

    public String login(String correo, String password) {
        Usuario userLogin = userJpaRepository.getByCorreo(correo);
        userLogin.setPassword(password);
        if (userJpaRepository.existsByCorreo(userLogin.getCorreo())) {
            if (userJpaRepository.existsByPassword(userLogin.getPassword())) ;
            {
                userJpaRepository.getByCorreo(correo);
                return "Secion iniciada";

            }
            // return "contrsena p correo incorrecto";
        }
        return "Contrasena o correo incorrecto";
    }

}
