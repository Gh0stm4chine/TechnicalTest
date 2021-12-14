package test.adapters.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.adapters.dto.PersonneDTO;
import test.domain.model.Personne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class PersonneMapper {

    @Autowired
    private ModelMapper mapper;

    public PersonneDTO convertPersonneToPersonneDTO(Personne personne) throws ParseException {
        PersonneDTO personneDTO = mapper.map(personne, PersonneDTO.class);
        personneDTO.setAge(computeAge(personne.getNaissance()));

        return personneDTO;
    }

    public Personne convertPersonneDTOToPersonne(PersonneDTO personneDTO) {
        return mapper.map(personneDTO, Personne.class);
    }

    private Integer computeAge(String dateDeNaissance) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar naissance = Calendar.getInstance();
        naissance.setTimeInMillis(new Date().getTime() - dateFormat.parse(dateDeNaissance).getTime());
        return naissance.get(Calendar.YEAR) - 1970;
    }

}
