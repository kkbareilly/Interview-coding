package java8.lambdaExp;

public class Person {
    int age;
    enum SEX{MALE,FEMALE}
    String name;
    int salary;

    SEX gender;

    public SEX getGender() {
        return gender;
    }

    public void setGender(SEX gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
