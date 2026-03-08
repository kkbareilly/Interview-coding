package java8.lambdaExp;

import java.util.List;

public class Main {

    public void printPeople(List<Person> p,CheckPerson person){
        for(Person persons:p){
            if(person.test(persons))
                p.toString();
        }
    }
}
