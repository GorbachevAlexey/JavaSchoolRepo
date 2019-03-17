package com.sbt.lesson6.beanutils;

public class To {
    private Object name;
    private Integer id;
    private boolean isUser;

    public To(String name, int id, boolean isUser) {
        this.name = name;
        this.id = id;
        this.isUser=isUser;
    }

    public Object getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Receiver: \n id(Integer)="+this.id+
                "\nname(Object)="+this.name+"\n"+
                "isUser(boolean)="+this.isUser;
    }
}
