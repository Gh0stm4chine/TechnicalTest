package test.domain.services;

import test.domain.model.Personne;

import java.util.List;

public interface PersonneServices {

    List<Personne> getAll();

    void save(Personne personne);
}
