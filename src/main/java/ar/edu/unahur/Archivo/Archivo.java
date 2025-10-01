package ar.edu.unahur.Archivo;

import ar.edu.unahur.obj2.IElemento.IElemento;

public class Archivo implements IElemento{

    private String nombre;

    private Integer tamanio;

    private String extension;

    public Archivo(String extension, String nombre, Integer tamanio) {
        this.extension = extension;
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    @Override
    public String nombre() {
        return this.nombre + "." + this.extension;
    }

    public String extension(){
        return this.extension;
    }

    @Override
    public Integer tamanio() {
      return this.tamanio;
    }

    @Override
    public void mostrar(Integer identacion) {
        String espacio = " ".repeat(identacion);
        System.out.println(espacio + "- " + this.nombre() + " (" + this.tamanio() + "kb)");
    }

    @Override
    public IElemento archivoMasPesado() {
        return this;
    }

    
    
    
  



    

}
