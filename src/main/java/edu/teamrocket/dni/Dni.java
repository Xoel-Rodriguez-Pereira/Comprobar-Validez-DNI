package edu.teamrocket.dni;

class Dni {
    
    private final String dni;
    private Boolean numeroSano;
    private Boolean letraSana;
    private Boolean dniCifSano;
    private Byte LONGITUD_DNI;


    private TablaAsignacion tablaAsignacion = new TablaAsignacion();   


    Dni(String dni) {
        this.dni = dni;
    }

    private String getDni() {
        return this.dni;
    }

    private Boolean isNumeroSano() {
        return this.numeroSano;
    }

    private void setNumeroSano(Boolean valor) {
        this.numeroSano = valor;
    }

    private Boolean isLetraSana() {
        return this.letraSana;
    }

    private void setLetraSana(Boolean valor) {
        this.letraSana = valor;
    }

    private Boolean isDniCifSano() {
        return this.dniCifSano;
    }

    private void setDniCifSano(Boolean valor) {
        this.dniCifSano = valor;
    }

        private TablaAsignacion getTablaAsignacion() {
        return this.tablaAsignacion;
    }


    @Override
    public String toString() {
        return this.dni;
    }

    public Boolean checkDni() {
        setDniCifSano(checkNumero() && checkLetra());
        return isDniCifSano();
    }

    public Boolean checkNumero() {
        setNumeroSano(checkLongitudDni() && isDniNumero(extraerParteNumericaDni()));
        return isNumeroSano();
    }

    private Boolean checkLongitudDni() {
        return getDni().length() == this.LONGITUD_DNI;
    }

    public Boolean checkLetra() {
        checkNumero();
        if (isNumeroSano()) {
            setLetraSana(Character.isUpperCase(extraerParteAlfabeticaDni())
                            && checkLetraValida());
            return isLetraSana();
        }
        
        else {
            return false;
        }
    }
    
    public Character obtenerLetra (){

        checkNumero();
        if (isNumeroSano()) {
            return getTablaAsignacion().clacularLetra(extraerParteNumericaDni());} 
            else {
                return Character.MIN_VALUE;
            } 
        } 


    public String extraerParteNumericaDni() {
        return this.dni.substring(0, this.LONGITUD_DNI - 1);
    }

    Character extraerParteAlfabeticaDni() {
        return this.dni.charAt(this.LONGITUD_DNI - 1);
    }
    
    private Boolean checkLetraValida() {
        return extraerParteAlfabeticaDni().equals(obtenerLetra());

    }

    Boolean isDniNumero(String cadena) {
     
            for (int i = 0; i < cadena.length(); i++) {
                if (!Character.isDigit(cadena.charAt(i))) {
                    return false;
                }
            }
            return true;
    } 

    
}

