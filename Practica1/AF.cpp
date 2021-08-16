#include <iostream>
#include <cstring>

class Af{
    int numcaracteres;
    int tamCadena;
    int numcarac;
    int tamCadena;
    int numEstados;
    int edoInicial;
    int edoFinal;
    int numSimbolos;
    int a;
    int q;
    char c;
    char cadena[100];
    char desSimbolos[100];
    char ruta[50];
  public:
    void mostrar();
    void mostrarTabla();
    void proceso(char[]);
    void obtenerdato();
    char *obtenerCadena();
};

int main(){
  Af AFD;
  Af AFN;
  
  return 0;
}
