package hibernateRelations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PersonTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AdressRepository adressRepository;

    @Test
    public void shouldSavePersonAndAdress(){

        //given
        Person person1 = new Person("Person1", "Kowalski", "11111111111", 20);
        Person person2 = new Person("Person2", "Kowalski", "22222222222", 30);

        Adress adress1 = new Adress("Katowice", "Twarda", 5, "40-123");
        Adress adress2 = new Adress("Katowice", "Miekka", 15, "40-123");

        Person savedPerson1 = personRepository.save(person1);
        Person savedPerson2 = personRepository.save(person2);

        Adress savedAdres1 = adressRepository.save(adress1);
        Adress savedAdres2 = adressRepository.save(adress2);


        Optional<Person> byId = personRepository.findById(savedPerson1.getId());
        Optional<Adress> byId1 = adressRepository.findById(savedAdres1.getId());

        // when
        if(byId.isPresent() && byId1.isPresent()) {
            Person person = byId.get();
            Adress adress = byId1.get();
            person.setAdress(adress);
            adress.setPerson(person);
            personRepository.save(person);
        }

        //then
        List<Person> all = personRepository.findAll();
        System.out.println("result person: " + all);

    }
}
