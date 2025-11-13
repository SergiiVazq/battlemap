import javax.swing.plaf.ActionMapUIResource;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int vidaJ = 3;
        int vidaE = 3;
        boolean acierto = false;


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Introduce cuantas filas y columnas tiene el campo de batalla");
        System.out.println("\n filas : ");
        Scanner entrada = new Scanner(System.in);
        int filas = entrada.nextInt();
        System.out.println(" columans : ");
        int columnas = entrada.nextInt();

        String[][] campo = new String[filas][columnas];
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                campo[i][j] = ".";
            }
        }
        campo[rand.nextInt(0, filas)][rand.nextInt(0, columnas)] = "J";
        campo[rand.nextInt(0, filas)][rand.nextInt(0, columnas)] = "E";

        actualizacion(vidaJ, vidaE, campo, filas, columnas);
        do {
            boolean semueve= false;

            int opcion = Funciones.menushort();




            switch (opcion){
                case 1 :
                    char movimiento = Funciones.pedirmovimiento();
                    semueve = Funciones.movimientojugador(movimiento, campo, filas, columnas, semueve);
                    if (semueve){
                        campo = Funciones.movimientoenemigo(campo,filas,columnas);
                        actualizacion(vidaJ, vidaE, campo, filas, columnas);

                    } else {
                        Funciones.showmap(campo,filas,columnas);
                    }

                    break;
                case 2 :
                    System.out.print("\n En que direccion quieres disparar? (wasd):");

                    char direcdisparo = Funciones.pedirdisparo();
                    campo = Funciones.movimientoenemigo(campo,filas,columnas);
                    acierto = Funciones.hacerdisparo(campo, filas , columnas ,direcdisparo);
                    if (acierto){

                        int prob = 0;
                        prob =rand.nextInt(0,100)+1;
                        if (prob<80){
                            vidaE --;
                            System.out.print("ACERTASTE le queda una vida menos a tu enemigo\n");
                            System.out.print("\n ======================\n");

                            actualizacion(vidaJ, vidaE, campo, filas, columnas);
                        }else {
                            System.out.print("TIENES UNA PUNTERIA NEFASTA Y FALLAS...\n");
                            System.out.print("\n ======================\n");

                            actualizacion(vidaJ, vidaE, campo, filas, columnas);

                        }
                    }else {

                        actualizacion(vidaJ, vidaE, campo, filas, columnas);
                    }


                    break;
            }




        }while (vidaE >0 && vidaJ >0);
    }

    public static void actualizacion(int x, int y, String [][] b,int filasmap, int columnasmap){
        // muestra el mapa actual
        for (int i = 0 ;i<filasmap;i++){
            System.out.print("\n|");
            for (int j=0;j<columnasmap;j++){
                System.out.print(b[i][j] + " ");
                if((j+1)==columnasmap){
                    System.out.print("|");
                }
            }
        }
        System.out.print("\n ======================\n");
        System.out.print( "\nVIDA DE J ==> " + x);
        System.out.print("\nVIDA DE ENEMIGO ==> "+y);
        System.out.print("\n J es tu posicion y E es el enemigo teclea W(NORTE), S(SUR), A(OESTE) o D(ESTE) para intentar atraparlo o dispara\n");


    }

}
//








/*// muestra el mapa actual
        for (int i = 0 ;i<filas;i++){
            System.out.print("\n|");
            for (int j=0;j<columnas;j++){
                System.out.print(campo[i][j] + " ");
                if((j+1)==columnas){
                    System.out.print("|");
                }
            }
        }
        System.out.print( "\nVIDA DE J ==> " + vidaJ);
        System.out.print("\nVIDA DE ENEMIGO ==> "+vidaE);*/