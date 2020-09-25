package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{

    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void crearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("seba@gmail.com");
        usuario.setPassword("1234");
        usuario.setRol("ADMIN");
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
    }
    // test usuario update delete y buscar por id

    @Test
    @Transactional @Rollback
    public void queAlGuardarUnUsuarioDeberiaEstarEnLaBase(){
        Usuario usuario = new Usuario();
        usuario.setEmail("seba@gmail.com");
        usuario.setPassword("1234");
        usuario.setRol("ADMIN");
        session().save(usuario); // aca lo guardamos
        assertThat(usuario.getId()).isNotNull();

        Usuario usuario2 = session().get(Usuario.class,usuario.getId());
        assertThat(usuario2.getId().equals(usuario.getId()));

        usuario.setEmail("hola@gmail.com");
        session().update(usuario);

        assertThat(usuario.getEmail().equals("hola@gmail.com"));
    }
    @Test(expected = NullPointerException.class)
    @Transactional @Rollback
    public void borrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("seba@gmail.com");
        usuario.setPassword("1234");
        usuario.setRol("ADMIN");
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
        session().delete(usuario);
        Usuario user = session().get(Usuario.class,usuario.getId());
        user.getId();
    }


}
