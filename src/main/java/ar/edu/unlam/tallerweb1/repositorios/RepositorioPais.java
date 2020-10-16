package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Pais;

import java.util.List;

public interface RepositorioPais {
    List <Pais> buscarPaisesPorCantidad(Integer cantidadDeHabitantes); //
    List <Pais> buscarPaisesPorIdioma(String idioma);
    List<Pais> buscarPaisPorContinente(String continente);
    List<Pais> buscarPaisPorContinentePorIdiomaCantidadMaximaDeHabitantes(String continente,String idioma, Integer cantidadDeHabitantes);
}
