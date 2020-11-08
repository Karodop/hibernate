package hibernateRelations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
class HibernateTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AdressRepository adressRepository;

    @BeforeEach
    void init (){

        Person person1 = new Person("Jacek","Kowalski","00000000",25);
        Person person2 = new Person("Karolina","Dopart","00000001",21);
        Person person3 = new Person("Przemek","Enty","00000002",28);
        Person person4 = new Person("Magda","Enta","00000003",33);
        Person person5 = new Person("Ania","Perska","00000004",23);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);

        Adress adres1 = new Adress("Katowice","Bazantowa",43,"43-200",person4);
        Adress adres2 = new Adress("Pszczyna","Akacjowa",23,"43-210",person4);
        Adress adres3 = new Adress("Bielsko","Lukrecji",67,"43-220",person3);
        Adress adres4 = new Adress("Warszawa","Dolna",23,"43-202",person2);
        Adress adres5 = new Adress("Gdansk","Zlota",67,"43-203",person5);

        adressRepository.save(adres1);
        adressRepository.save(adres2);
        adressRepository.save(adres3);
        adressRepository.save(adres4);
        adressRepository.save(adres5);

    }

    @Test
    //person4 zamieszkuje katowice i pszczyne
    public void person4HaveTwoFlats(){

        List<Adress> result = adressRepository.findAll();
        System.out.println("result adress: " + result);

    }



}