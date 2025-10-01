package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.Archivo.Archivo;
import ar.edu.unahur.Carpeta.Carpeta;
import ar.edu.unahur.obj2.IElemento.IElemento;





public class FileSystemTest {

    @Test
    void testTamanioTotalConSubCarpetas() {
        FileSystem fs = new FileSystem("Root");

        Archivo a1 = new Archivo("txt", "Notas", 120);
        Archivo a2 = new Archivo("mp3", "Cancion", 300);

        Carpeta carpetaA = new Carpeta("Carpeta A");
        carpetaA.getElementos().add(new Archivo("jpg", "Imagen-A", 150));
        carpetaA.getElementos().add(new Archivo("mp3", "Rock", 390));

        Carpeta carpetaB = new Carpeta("Carpeta B");
        carpetaB.getElementos().add(new Archivo("mp4", "Video-II", 1330));

        Carpeta subCarpeta = new Carpeta("Carpeta B1");
        subCarpeta.getElementos().add(new Archivo("txt", "Notas-Rapidas", 50));
        subCarpeta.getElementos().add(new Archivo("mp3", "Rap", 370));

        carpetaB.getElementos().add(subCarpeta);
        carpetaB.getElementos().add(new Archivo("mp4", "Video-I", 800));

        fs.getCarpetaPrincipal().getElementos().add(a1);
        fs.getCarpetaPrincipal().getElementos().add(a2);
        fs.getCarpetaPrincipal().getElementos().add(carpetaA);
        fs.getCarpetaPrincipal().getElementos().add(carpetaB);

        // Tamaño total esperado
        int esperado = 120 + 300 + 150 + 390 + 1330 + 50 + 370 + 800;
        assertEquals(3510, fs.tamanioTotal());
    }

    @Test
    void testArchivoMasPesado() {
        FileSystem fs = new FileSystem("Root");

        Archivo a1 = new Archivo("txt", "Notas", 120);
        Archivo a2 = new Archivo("mp3", "Cancion", 300);
        Carpeta carpeta = new Carpeta("Carpeta1");
        carpeta.getElementos().add(new Archivo("jpg", "Imagen", 150));

        fs.getCarpetaPrincipal().getElementos().add(a1);
        fs.getCarpetaPrincipal().getElementos().add(a2);
        fs.getCarpetaPrincipal().getElementos().add(carpeta);

        IElemento pesado = fs.archivoMasPesado();
        assertEquals(a2, pesado); // el más pesado es "Cancion.mp3"
    }

    @Test
    void testMostrar() {
        FileSystem fs = new FileSystem("Root");
        fs.getCarpetaPrincipal().getElementos().add(new Archivo("txt", "Notas", 50));
        fs.mostrar(); // salida manual para ver estructura
    }
}

