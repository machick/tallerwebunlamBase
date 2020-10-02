package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.LabelUI;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorListar {

    //inyeccion de dependencia solo tiene sentido con interfaces
    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @RequestMapping(path="listar-usuarios/{rol}", method = RequestMethod.GET)

    public ModelAndView listarUsuariosPorRol(@PathVariable String rol){

        ModelMap modelo = new ModelMap();
        modelo.put("ROL_BUSCADO",rol);
        try {
            modelo.put("USUARIOS", servicioUsuarios.buscarUsuarioConRol(rol));
        } catch (Exception e){
            modelo.put("ERROR","Ha ocurrido un error inesperado, intente mas tarde.");
        }
        return new ModelAndView("listaUsuarios",modelo);
    }
    @RequestMapping(path = "listar-usuarios")
    public ModelAndView listarUsuarios(){
        ModelMap modelo = new ModelMap();
        modelo.put("USUARIOS",servicioUsuarios.todosUsuarios());
        return new ModelAndView("usuarios",modelo);
    }

}
