package com.pedromihael.cellphonedatabase;

public class Model {
//    private String id, modelo, marcaId;
    private String modelo, marca;
    public Model(){}

    /* Os IDs vão vir do banco

    public String getId(){ return this.id; }
    public void setId(String id){ this.id = id; }

    public String getMarcaId(){ return this.marcaId; }
    public void setMarcaId(String marcaId){ this.marcaId = marcaId; }

     */

    public String getModelo(){ return this.modelo; }
    public void setModelo(String modelo){ this.modelo = modelo; }

    public String getMarca(){ return this.marca; }
    public void setMarca(String marca){ this.marca = marca; }

    @Override
    public String toString(){
//        return "Modelo: " + getModelo() + " - Marca: " + getMarcaId() + " - ID: " + getId();
        return "Modelo: " + getModelo() + " - Marca: " + getMarca();
    }
}
