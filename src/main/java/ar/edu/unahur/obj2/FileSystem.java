package ar.edu.unahur.obj2;

import ar.edu.unahur.Carpeta.Carpeta;
import ar.edu.unahur.obj2.IElemento.IElemento;

public class FileSystem {

    private Carpeta carpetaPrincipal;

    public FileSystem(String nombre) {
        this.carpetaPrincipal = new Carpeta(nombre);
    }

    public Carpeta getCarpetaPrincipal() {
        return carpetaPrincipal;
    }

    public Integer tamanioTotal() {
        return carpetaPrincipal.tamanio();
    }

    public IElemento archivoMasPesado() {
        return carpetaPrincipal.archivoMasPesado();
    }

    public void mostrar() {
        carpetaPrincipal.mostrar(0);
    }
}