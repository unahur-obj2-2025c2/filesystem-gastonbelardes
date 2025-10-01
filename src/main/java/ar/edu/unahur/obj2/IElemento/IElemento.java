package ar.edu.unahur.obj2.IElemento;

public interface IElemento {
    String nombre();

    Integer tamanio();

    void mostrar(Integer identacion);

    IElemento archivoMasPesado();

}
