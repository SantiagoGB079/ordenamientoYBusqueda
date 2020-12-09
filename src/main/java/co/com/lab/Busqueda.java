package co.com.lab;

public class Busqueda {

    static Integer[] arreglo = {2, 5, 9, 58, 36, 78, 84, 85, 86, 3, 4};

    static Integer clave = 4;

    public int secuencial() {
        int resultado = -1;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(clave)) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }

    public int binaria(Integer[] arreglo, int clave, int alto, int bajo) {

        if (bajo > alto) {
            return -1;
        }

        int central = (bajo + alto) / 2;

        if (clave == arreglo[central]) {
            return central;
        }

        if (clave > arreglo[central]) {
            bajo = central + 1;
            return binaria(arreglo, clave, alto, bajo);
        } else {
            alto = central - 1;
            return binaria(arreglo, clave, alto, bajo);
        }
    }

    public static void main(String[] args) {

        int aux;
        for (int i = 0; i < arreglo.length; i++) { //Se ordena el arreglo
            for (int j = i + 1; j < arreglo.length; j++) {

                if (arreglo[j] < arreglo[i]) {
                    aux = arreglo[j];

                    for (int k = j; k > i; k--) {
                        arreglo[k] = arreglo[k - 1];
                    }
                    arreglo[i] = aux;
                }
            }
        }

        for (int i = 0; i < arreglo.length; i++) { //Se imprime el arreglo ordenado
            System.out.println("Arreglo posicion " + i + " valor " + arreglo[i]);
        }
        Busqueda busqueda = new Busqueda();
        int alto = arreglo.length - 1;
        int bajo = 0;

        int posicion = busqueda.binaria(arreglo, clave, alto, bajo);

        if (posicion == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("El valor clave " + clave + " encontrado en posicion " + posicion);
        }
    }
}
