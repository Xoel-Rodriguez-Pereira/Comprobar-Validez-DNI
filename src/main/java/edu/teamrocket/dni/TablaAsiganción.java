package edu.teamrocket.dni;


class TablaAsignacion {
    private char[] tabla = {'T' ,'R' ,'W' ,'A' ,'G' ,'M' ,'Y' ,'F' ,'P' ,'D' ,
                            'X' ,'B' ,'N' ,'J' ,'Z' ,'S' ,'Q' ,'V' ,'H' ,'L' ,
                            'C' ,'K' ,'E'};


TablaAsignacion () {};  

public char clacularLetra (String DNI) {

int numero = Integer.parseInt(DNI);
int resto = numero % 23; 
return getletra(resto);

}

public char getletra (int posicion){
    return tabla[posicion];



}
}