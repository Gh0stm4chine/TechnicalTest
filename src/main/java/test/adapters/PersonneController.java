package test.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.adapters.dto.PersonneDTO;
import test.adapters.mapper.PersonneMapper;
import test.domain.model.Personne;
import test.domain.services.PersonneServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonneController {

    @Autowired
    private PersonneServices personneServices;

    @Autowired
    private PersonneMapper personneMapper;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping("/person")
    public ResponseEntity save(@RequestBody PersonneDTO personneDTO) {
        if (personneDTO.getAge() > 150) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try {
            dateFormat.parse(personneDTO.getNaissance());
            personneServices.save(personneMapper.convertPersonneDTOToPersonne(personneDTO));

            return new ResponseEntity(HttpStatus.CREATED);
        } catch (ParseException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonneDTO>> getAll() {
        List<Personne> personneList = personneServices.getAll();


        List<PersonneDTO> personneDTOList = personneList.stream()
                .map(personne -> {
                    try {
                        return personneMapper.convertPersonneToPersonneDTO(personne);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    }
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(personneDTOList, HttpStatus.OK);
    }
}
