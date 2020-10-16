package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPais;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{
    private RepositorioPais repositorioPais;

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

    @Test
    @Transactional @Rollback
    public void testQueTraeLosPaisesConMasHabitantes(){
        Pais paisConMenos2000Habitantes = new Pais();
        paisConMenos2000Habitantes.setNombre("Argetina");
        paisConMenos2000Habitantes.setCapital("capital federal");
        paisConMenos2000Habitantes.setContinente("america");
        paisConMenos2000Habitantes.setHabitantes(1800L);
        session().save(paisConMenos2000Habitantes);

        Pais paisCon2000Habitantes = new Pais();
        paisCon2000Habitantes.setNombre("Argetina");
        paisCon2000Habitantes.setCapital("capital federal");
        paisCon2000Habitantes.setContinente("america");
        paisCon2000Habitantes.setHabitantes(2000L);
        session().save(paisCon2000Habitantes);

        Pais paisConMas2000Habitantes = new Pais();
        paisConMas2000Habitantes.setNombre("Argetina");
        paisConMas2000Habitantes.setCapital("capital federal");
        paisConMas2000Habitantes.setContinente("america");
        paisConMas2000Habitantes.setHabitantes(2100L);
        session().save(paisConMas2000Habitantes);

        Long cantidad = 2000L;


        List<Pais> paisesConMasDe2000Habitantes = session().createCriteria(Pais.class).add(Restrictions.gt("habitantes",cantidad)).list();

        Assert.assertEquals(paisesConMasDe2000Habitantes.size(), 1 );
        Assert.assertEquals(paisesConMasDe2000Habitantes.get(0), paisConMas2000Habitantes);
    }



}
