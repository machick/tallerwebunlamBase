package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ServicioUsuariosImpl implements ServicioUsuarios{
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public List<Usuario> buscarUsuarioConRol(String rol) {

        final List<Usuario>lista= repositorioUsuario.todos();

        if (lista.isEmpty()){
            throw new RuntimeException("No hay usuarios en la base");
        }

        List<Usuario>listaFiltrada = new LinkedList<>();
        for (Usuario usuario: lista){
           if (usuario.getRol().equals(rol)){
               listaFiltrada.add(usuario);
           }
        }
        return listaFiltrada;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return repositorioUsuario.consultarUsuarioPorId(id);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return repositorioUsuario.todos();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        repositorioUsuario.actualizarUsuario(usuario);
    }
}
