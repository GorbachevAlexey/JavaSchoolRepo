package com.sbt.lesson6.beanutils;

public class From {
    private Integer id;
    private String name;
    private boolean isUser;

    public From(String name, Integer id, boolean isUser) {
        this.id = id;
        this.name = name;
        this.isUser = isUser;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    @Override
    public String toString() {
        return "Sender: \n id(id)=" + this.id +
                "\nname(String)=" + this.name +
                "\nisUser(boolean)=" + this.isUser + "\n";
    }
}
