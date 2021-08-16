#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

//definimos las variables que vamos a usar
FILE *ptr;

int transicion[50][50];

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

//declaramos los metodos que nos serán utiles
void mostrarTodo();
void mostrarTabla();
void proceso(char[]);
void obtenerDatos();
int obtenerDato(int);
char *obtenerCadena();

int main(){
	int opc;
	do{
		system("cls");
		printf("\n\n*********Programa Primera Evaluacion**********\n");
		printf("Ejecucion de un AFD\n\n");
    	printf("Seleccione el archivo que desea analizar:\n");
    	printf("1.- Configuracion 1\n");
    	printf("2.- Configuracion 2\n");
    	printf("3.- Configuracion 3\n");
    	printf("4.- Salir\n");
    	scanf("%d",&opc);
    	
    	switch(opc){
    		case 1:
    			printf("\n//////////////Configuracion1.txt\\\\\\\\\\\\\\\\\\\n");
    			strcpy(ruta,"Configuracion1.txt");
    			proceso(ruta);
    			fclose(ptr);
    			break;
    		case 2:
    			printf("\n//////////////Configuracion2.txt\\\\\\\\\\\\\\\\\\\n");
    			strcpy(ruta,"Configuracion2.txt");
    			proceso(ruta);
    			fclose(ptr);
    			break;
    		case 3:
    			printf("\n//////////////Configuracion3.txt\\\\\\\\\\\\\\\\\\\n");
    			strcpy(ruta,"Configuracion3.txt");
    			proceso(ruta);
    			fclose(ptr);
				break;
			case 4:
				printf("\nSaliendo....");
				break;
			default:
				printf("\nEsa opción no es valida\n");
				break;			
		}
    	
	}while(opc != 4);
return 0;
}

void mostrarTodo(){
	int i;
	mostrarTabla();
	printf("\n\nQ={");
	for(i=0;i<numEstados;i++){
		printf("q%d",i);
	}
	printf("}");
	printf("\n\nSimbolos={");
	for(i=0;i<numSimbolos;i++){
		printf("%c",desSimbolos[i]);
	}
	printf("}\n");
}

void mostrarTabla(){
	int i;
	int j;
	
	for(i=0;i<numSimbolos;i++){
		printf("     %c",desSimbolos[i]);
	}
	printf("\n");
	for(i=0;i<numEstados;i++){
		printf("q%d| ",i);
		for(j=0;j<numSimbolos;j++){
			printf("q%d    ",transicion[i][j]);
		}
		printf("\n");
	}
}
void obtenerDatos(char ruta[]){
	int i;
	int j;
	int k=0;
	char titulo[100];
	char estados[3];
	char simbolos[3];
	char edoinicial[3];
	char edofinal[3];
	char funcion[100];
	
	
	ptr=fopen(ruta,"r+");
	fgets (titulo,100, ptr);
	fgets (desSimbolos,100, ptr);
	fgets (estados,3, ptr);
	fgets (simbolos,3, ptr);
	fgets (edoinicial,3, ptr);
	fgets (edofinal,3, ptr);
	fgets (funcion,100, ptr);
	
	printf("%s\n",titulo);
	numEstados=atoi(estados);
	numSimbolos=atoi(simbolos);
	edoInicial=atoi(edoinicial);
	edoFinal=atoi(edofinal);
	
	
		for(i=0;i<numEstados;i++){
			for(j=0;j<numSimbolos;j++){
					transicion[i][j]=(funcion[k]-'0');
					k++;
		}
	}

}
int obtenerDato(int b){
	int dato;
	dato=transicion[a][b];
	return(dato);
}

char *obtenerCadena(){
	printf("\nIngrese la cadena que desea comparar:\n");
	scanf("%s",cadena);
	return cadena;
}

void proceso(char ruta[]){
	int i;
	printf("Proceso: %s\n",ruta);
	obtenerDatos(ruta);
	mostrarTodo();
	obtenerCadena();
	tamCadena=strlen(cadena);
	a=0;
	for(i=0;i<tamCadena;i++){
		c=cadena[i];
		q=atoi(&c);
		a=obtenerDato(q);
	}
	if(a==edoFinal){
		printf("La cadena ingresada es admitida");
		getch();
	}else{
		printf("La cadena ingresada no es admitida");
		getch();
	}
}
