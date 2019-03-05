
public class Solution {
    public static void main(String[] args) {

        Person person = new Person(true, "Bob");
        Person person1 = new Person(false,"Sara");
        Person person2 = new Person(false,"Maria");
        Person person3 = new Person(true,"Djeck");


        person.marry(person1);// bob sara
        person.marry(person2);//bob maria
        person.marry(person3);//bob djeck
        person1.marry(person3);//sara djeck
        person.marry(person1);//bob sara


    }
}
