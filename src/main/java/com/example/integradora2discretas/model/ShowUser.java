package com.example.integradora2discretas.model;

public class ShowUser {

    private static ShowUser instance;
    private ShowUser(){

        user = new User("");
    }
    public static ShowUser getInstance(){
        if(instance == null){
            instance = new ShowUser();
        }
        return instance;
    }
    //Los atributos de la clase
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
