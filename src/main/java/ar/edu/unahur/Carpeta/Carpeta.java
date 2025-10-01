package ar.edu.unahur.Carpeta;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.IElemento.IElemento;

public class Carpeta implements IElemento{

    private String nombre;

    private List<IElemento> elementos = new ArrayList<IElemento>();

    public List<IElemento> getElementos() {
    return elementos;
}

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String nombre() {
       return this.nombre;
    }

    @Override
    public Integer tamanio() {

        Integer tamanio = 0;
        for (IElemento elemento : elementos){
            tamanio += elemento.tamanio();
        }
        return tamanio;
        
    }

    @Override
public void mostrar(Integer identacion) {
    // Mostramos la carpeta con su tamaño total
    System.out.println("   ".repeat(identacion) + "└ " + this.nombre() + " ( " + this.tamanio() + " Bytes )");

    // Ahora mostramos el contenido, con +1 nivel de identación
    for (IElemento e : elementos) {
        e.mostrar(identacion + 1);
    }
}

   public IElemento archivoMasPesado() {

        IElemento masPesado = null;

        for(IElemento elemento : elementos){
            
            if(elemento instanceof Carpeta) {

            
            //recursion
            IElemento candidato = ((Carpeta) elemento).archivoMasPesado();

            masPesado = compararPesos(masPesado, candidato);
            } else {
                masPesado = compararPesos(masPesado, elemento);
            }

        }


        return masPesado;
        
    }

    private IElemento compararPesos(IElemento masPesado, IElemento candidato) {
        if(masPesado == null || candidato.tamanio() > masPesado.tamanio()){
            return candidato;
        } else {
            return masPesado;
        }
    }

    // Removed duplicate getElementos() method to resolve compilation error.
 
    
    
}