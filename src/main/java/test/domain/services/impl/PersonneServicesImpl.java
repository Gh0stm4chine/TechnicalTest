package test.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.domain.model.Personne;
import test.domain.services.PersonneServices;
import test.repository.PersonneRepository;

import java.util.List;

@Component
public class PersonneServicesImpl implements PersonneServices {

    @Autowired
    private PersonneRepository repository;

    @Override
    public List<Personne> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Personne personne) {
        repository.save(personne);
    }
}
