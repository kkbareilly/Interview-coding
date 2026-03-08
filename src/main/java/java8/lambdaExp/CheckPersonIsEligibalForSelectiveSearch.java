package java8.lambdaExp;

public class CheckPersonIsEligibalForSelectiveSearch implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.getGender()== Person.SEX.MALE&& p.getAge()>30;
    }
}
