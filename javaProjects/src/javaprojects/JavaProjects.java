/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author xivitoo
 */
public class JavaProjects {

    //By xivitoo on NetBeans (JAVA)
    public static void main(String[] args) {
        // EJECUCION DEL PROGRAMA
        
        
        
    }
    
    public static void Fecha() {

        String fecha;
        Scanner leer = new Scanner(System.in);
        boolean res = true;
        System.out.println("Dame la fecha (dd/mm/yyyy): ");
        fecha = leer.next();
        res = validarFecha(fecha);
        if (res == true) {
            System.out.println("La fecha es valida");
        } else {
            System.out.println("La fecha no es valida");
        }

    }
    
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public static void calculadoraBasica() {

        Scanner entrada = new Scanner(System.in);
        double a, b, result;
        String op;

        System.out.print("Ingresa primer numero: ");
        a = entrada.nextDouble();
        System.out.print("Ingresa segundo numero: ");
        b = entrada.nextDouble();
        System.out.println("Que operador desea usar con estos numeros?: ");
        System.out.println("S._suma R._resta M._multiplicacion D._Division");
        op = entrada.next();

        switch (op) {
            case "s":
            case "S":
                result = a + b;
                System.out.println("La suma es igual a: " + result);
                break;
            case "r":
            case "R":
                result = a - b;
                System.out.println("La resta es igual a: " + result);
                break;
            case "m":
            case "M":
                result = a * b;
                System.out.println("La multiplicacion es igual a: " + result);
                break;
            case "d":
            case "D":
                result = a / b;
                System.out.println("La division es igual a: " + result);
                break;
            default:
                System.out.println("Syntax error.......");

        }
    }
    
    public static void adivinaNum() {

        Scanner entrada = new Scanner(System.in);
        int numAlea;
        int intent;
        int cont = 10;

        numAlea = (int) (Math.random() * 100 + 1);
        System.out.println(numAlea);

        System.out.println("Adivina un numero entre 1 y 100, "
                + "tienes 10 intentos. Suerte!!");

        do {
            System.out.println("Te quedan " + cont + " intentos");
            System.out.print("Introduce un numero: ");
            intent = entrada.nextInt();
            if (intent > numAlea) {
                System.out.println("El número que buscas es menor, te quedan "
                        + (cont - 1) + " intentos: ");
            } else if (intent < numAlea) {
                System.out.println("El número que buscas es mayor, te quedan "
                        + (cont - 1) + " intentos: ");
            } else {
                System.out.print("VAMOOOOS!! " + numAlea + " era el numero correcto"
                        + ", has gastado " + (10 - (cont - 1)) + " intentos. Muy bien!!");
            }
            cont--;
        } while (intent != numAlea && cont >= 0);
        if (cont < 0) {
            System.out.println("Has perdido. El numero aleatorio era " + numAlea + " :( ");
        }
    }
    
    public static void javaAdivinaNum() {

        Scanner entrada = new Scanner(System.in);
        int principio = 0, fin = 100, num = (fin - principio) / 2, acot = num, contador = 0;
        String eleccion;
        System.out.println("Piensa un numero del " + principio + " a " + fin + ". Voy a adivinarlo.");

        do {
            System.out.println("Es el numero mayor o igual que " + num + "?. (SI o NO)");
            eleccion = entrada.next();
            contador++;

            if (eleccion.equals("SI") || eleccion.equals("Si") || eleccion.equals("si")) {
                principio = num;

                if (acot / 2 == 0) {
                    num = num + 1;
                }
                num = num + acot / 2;
                acot = acot / 2;
            } else {
                fin = num - 1;

                if (acot / 2 == 0) {
                    num = num - 1;
                }
                num = num - acot / 2;
                acot = acot / 2;
            }
            if (principio != fin) {
                System.out.println("El principio es " + principio + " y el final es " + fin);
            } else {
                System.out.println("Tu numero es el " + principio + " SIUUUU");
                System.out.println("He gastado " + contador + " intento/s");
            }

        } while (principio != fin);
    }
    
    public static void fibonacci() {

        Scanner entrada = new Scanner(System.in);

        int i, a = 0, b = 1, serie, op = 1;

        System.out.print("Escriba cuanta logintud quiere que tenga Fibonacci: ");
        serie = entrada.nextInt();

        System.out.println(a);
        for (i = 0; i < serie; i++) {

            System.out.println(op);
            op = a + b;
            a = b;
            b = op;
        }

    }
    
    public static void productos() {

        HashMap<String, Float> listaProductos = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int opcionElegida = 0;
        float precio;
        String codigo;

        while (opcionElegida != 5) {
            System.out.println("Introduce el numero de la opción que quieras:");
            System.out.println("1.- Introducir producto");
            System.out.println("2.- Modificar precio");
            System.out.println("3.- Mostrar todos los productos");
            System.out.println("4.- Eliminar producto");
            System.out.println("5.- Salir");
            opcionElegida = sc.nextInt();

            switch (opcionElegida) {
                case 1:
                    System.out.println("Introduce el códido del producto:");
                    codigo = sc.next();
                    System.out.println("Introduce el precio del producto:");
                    precio = sc.nextFloat();
                    guardarProducto(codigo, precio, listaProductos);
                    break;
                case 2:
                    System.out.println("Introduce el códido del producto del que quieres cambiar el precio:");
                    codigo = sc.next();
                    modificaPrecio(codigo, listaProductos);
                    break;
                case 3:
                    mostrarProductos(listaProductos);
                    break;
                case 4:
                    System.out.println("Introduce el códido del producto que quieres eliminar:");
                    codigo = sc.next();
                    eliminaProducto(codigo, listaProductos);
                    break;
                case 5:
                    break;   // Si la opcion es 5 no se hace nada
                default:
                    System.out.println("Tienes que introducir una opción valida");
            }

        }


    }

    public static void modificaPrecio(String codigo, HashMap<String, Float> listaProductos) {
        Scanner sc = new Scanner(System.in);
        if (listaProductos.containsKey(codigo)) {
            System.out.println("Introduce el precio del producto:");
            listaProductos.put(codigo, sc.nextFloat());
        } else {
            System.out.println("No hay ningun producto con ese código.");
        }
    }    

    public static void eliminaProducto(String codigo, HashMap<String, Float> listaProductos) {
        if (listaProductos.containsKey(codigo)) {
            listaProductos.remove(codigo);
        } else {
            System.out.println("No hay ningun producto con ese código.");
        }
    }

    public static void mostrarProductos2(HashMap<String, Float> listaProductos) {
        Iterator iterador = listaProductos.entrySet().iterator();
        //Iterator<Map.Entry<String, Float>> iterador = listaProductos.entrySet().iterator();
        Map.Entry producto;
        while (iterador.hasNext()) {
            producto = (Map.Entry) iterador.next();
            //producto = iterador.next(); Si se usase tambien la otra linea comentada.
            System.out.println(producto.getKey() + " - " + producto.getValue());
        }
    }  

    public static void guardarProducto(String codigo, float precio, HashMap<String, Float> listaProductos) {
        if (listaProductos.containsKey(codigo)) {
            System.out.println("No se puede introducir el producto. El código esta repetido.");
        } else {
            listaProductos.put(codigo, precio);
        }
    }

    public static void mostrarProductos(HashMap<String, Float> listaProductos) {
        String clave;
        Iterator<String> productos = listaProductos.keySet().iterator();
        System.out.println("Hay los siguientes productos:");
        while (productos.hasNext()) {
            clave = productos.next();
            System.out.println(clave + " - " + listaProductos.get(clave));
        }
    }
    
}
