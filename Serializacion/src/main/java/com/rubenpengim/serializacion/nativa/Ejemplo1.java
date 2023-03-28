package com.rubenpengim.serializacion.nativa;

import com.rubenpengim.serializacion.modelo.Product;
import java.io.*;

public class Ejemplo1 {

    public static void main(String[] args) {

        System.out.println("Vamos a serializar el producto anterior");
        Product p = new Product(2, "prueba", 3);
        System.out.println(p.toString());
        serializar(p);

        System.out.println("Vamos a deserializar el producto anterior");
        Product newProd = null;
        newProd = deserializar();
        System.out.println(newProd.toString());
    }

    static void serializar(Product p) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(".\\Product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            System.out.println("El producto ha sido serializado en Product.ser");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra la ruta del fichero. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Ha surgido un error serializando. " + ex.getMessage());
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                System.out.println("Ha surgido un error cerrando el fichero. " + ex.getMessage());
            }
        }
    }

    static Product deserializar() {
        FileInputStream fileIn = null;
        Product p = null;
        try {
            fileIn = new FileInputStream(".\\Product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Product) in.readObject();
            System.out.println("El producto ha sido deserializado en Product.ser");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra la ruta del fichero. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Ha surgido un error deserializando. " + ex.getMessage());
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                System.out.println("Ha surgido un error cerrando el fichero. " + ex.getMessage());
            }
            return p;
        }
    }
}
