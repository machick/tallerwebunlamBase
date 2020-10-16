package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarios;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorUsuario {
    private ServicioUsuarios servicioUsuarios;

    @Autowired
    public ControladorUsuario(ServicioUsuarios servicioUsuarios){
        this.servicioUsuarios = servicioUsuarios;
    }

    @RequestMapping(path = "/crear-usuario", method =  RequestMethod.GET)
    public ModelAndView crearUsuario(@RequestParam("email")String emailRecibido, @RequestParam ("contraseña") String contraseñaRecibida){
        ModelMap modelo = new ModelMap();

        Usuario usuario = new Usuario();

        modelo.put("email",emailRecibido);
        modelo.put("contraseña", contraseñaRecibida);

        return new ModelAndView("mostrar-creado",modelo);
    }
    @RequestMapping("/update/{id}")
    public ModelAndView actualizarUsuario(@PathVariable Long id){
        ModelMap modelo = new ModelMap();
        Usuario usuarioTraido = servicioUsuarios.buscarUsuarioPorId(id);
        Usuario usuario = new Usuario();
        modelo.put("usuarioTraido",usuarioTraido);
        modelo.put("usuario", usuario);
        if (usuarioTraido==null){
            // anda mal
        }else {

        }
        return new ModelAndView("actualizarUsuario",modelo);
    }

    @RequestMapping(path = "/actualizar-usuario", method = RequestMethod.POST )
    public ModelAndView actualizarUsuarioPost(@RequestParam("id") String id, @RequestParam("email") String email, @RequestParam("password") String password ){
        Usuario usuario = new Usuario();
        Long idParseado = new Long(id);

        usuario.setId(idParseado);
        usuario.setEmail(email);
        usuario.setPassword(password);
        servicioUsuarios.actualizarUsuario(usuario);

        return new ModelAndView("redirect:/listar-usuarios");
    }

}
