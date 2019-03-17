package com.sbt.lesson6.beanutils;


import java.lang.reflect.InvocationTargetException;

import static com.sbt.lesson6.beanutils.BeanUtils.assign;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        To receiver = new To("Sample", 200, false);
        From sender = new From("USER", 100, true);

        System.out.println("-------------Before---------------");
        System.out.println(receiver);
        System.out.println(sender);
        System.out.println("-----------------------------");

        assign(receiver, sender);


        System.out.println("-------------After---------------");
        System.out.println(receiver);
        System.out.println(sender);
        System.out.println("-----------------------------");
    }

}
