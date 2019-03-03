
public class Solution {
    public static void main(String[] args) {

        Person person = new Person(true, "Bob");
        Person person1 = new Person(false,"Sara");
        Person person2 = new Person(false,"Maria");


        person.marry(person1);
        person.marry(person2);
        person.marry(person);

        System.out.println(person);
    }
}
