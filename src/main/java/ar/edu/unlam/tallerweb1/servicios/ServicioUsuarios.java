package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioUsuarios {

    List<Usuario> buscarUsuarioConRol(String rol);
}
