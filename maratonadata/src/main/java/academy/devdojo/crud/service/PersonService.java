package academy.devdojo.crud.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import academy.devdojo.crud.dominio.Person;

public class PersonService {
    public boolean isAdult(Person person) {
        // Objects.requireNonNull(person, "Person can't be null");
        if (person == null) {
            throw new IllegalArgumentException();
        }
        return person.getAge() >= 18;
    }

    public List<Person> filterRemovingNotAdult(List<Person> personList) {
        return personList.stream().filter(this::isAdult).collect(Collectors.toList());
    }
}
