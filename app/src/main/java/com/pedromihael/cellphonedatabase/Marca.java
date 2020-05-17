package com.pedromihael.cellphonedatabase;

public class Marca {
    private String marca, id;

    public Marca(){}

    public String getMarca(){ return this.marca; }
    public void setMarca(String marca){ this.marca = marca; }

    /* O ID vai vir do banco

    public String getId(){ return this.id; }
    public void setId(){ this.id = id; }

     */

    @Override
    public String toString(){
//        return "Marca: " + getMarca() + " - ID: " + getId();
        return "Marca: " + getMarca();
    }
}
