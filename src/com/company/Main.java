package com.company;

public class Main {

    public static void main (String[] args) {

        //Herencias
        System.out.println("Caracteristicas de Coches Normales:");
        Coche coche = new Coche();
        coche.VelocidadMaxima = 180;
        System.out.println("Velocidad Maxima: "+coche.VelocidadMaxima);
        coche.Matricula = "Abcd1234";
        System.out.println("Matricula: "+coche.Matricula);
        coche.setSonido("BRRR");
        System.out.println("El sonido del coche es: "+coche.getSonido());
        System.out.println("La Matricula es:");
        System.out.println(coche.compruebamatricula(coche.Matricula));
        System.out.println("Lo que imprime la Interface a traves de su implementacion es:");
        EjecutaAcelerar(coche);

        System.out.println("Caracteristicas de Coches Electricos:");
        CocheElectrico cochelectrico = new CocheElectrico();
        cochelectrico.VelocidadMaxima = 80;
        System.out.println("Velocidad Maxima: "+cochelectrico.VelocidadMaxima);
        cochelectrico.Matricula = "1234abcd";
        System.out.println("Matricula: "+cochelectrico.Matricula);
        cochelectrico.setSonido("ZZZZ");
        System.out.println("El sonido del coche electrico es: "+cochelectrico.getSonido());
        System.out.println("La Matricula es:");
        System.out.println(cochelectrico.compruebamatricula(cochelectrico.Matricula));
        EjecutaAcelerar(cochelectrico);
    }

    public static void EjecutaAcelerar(Funciones funciones) {
        funciones.Acelerar(50);
        funciones.Frenar(30);
    }
}

/*Una clase abstracta no se puede instanciar, pero si se puede acceder a ella a través de la extensión de
dicha clase a otras*/
abstract class Vehiculo {
    public int VelocidadMaxima;
    public String Matricula;
    private String sonido;

    //Herencias
    public boolean compruebamatricula(String matricula){
        if (matricula == "XXX"){
            return false;
        }
        return true;
    }

    /*Si las funciones se definen como abstractas, no podran ejecutarse por extensión a otras clases
    Se tiene que llamar en alguna de las clases que tiene extensión. */
    public Vehiculo() {
            System.out.println("Este es el Constructor de Vehiculo");
        }

    public String getSonido() {
        return this.sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }
}

interface Funciones {
    void Acelerar (int velocidad);
    void Frenar (int velocidad);
}

class Coche extends Vehiculo implements Funciones {

    public void Acelerar(int velocidad){
        System.out.println("Coche() -> Acelerar()");
    }

    public void Frenar(int velocidad){
        System.out.println("Coche() -> Frenar()");
    }
}

class CocheElectrico extends Vehiculo implements Funciones {

    public void Acelerar(int velocidad){
        System.out.println("Cochelectrico() -> Acelerar()");
    }

    public void Frenar(int velocidad){
        System.out.println("Cochelectrico() -> Frenar()");
    }
}
