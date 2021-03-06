public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Si es maquina con premio o no
    private boolean tipoMaquina;
    // Contador para el numero de billetes expedidos
    private int nBilletes;
    // Numero de billetes vendidos
    private int contador;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int numeroBilletesExpedibles) {
        precioBillete = precioDelBillete;
        tipoMaquina = premio;
        nBilletes = numeroBilletesExpedibles;
        contador = 0;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(contador < nBilletes) {
        if(cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }
    }
        else{
        System.out.println("#################");
        System.out.println("No est� permitido introducir dinero ya que la maquina no tiene billetes dentro");
        System.out.println("#################");
        }
   
    
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if(balanceClienteActual >= precioBillete) {        
           if(tipoMaquina == true) {
             if(contador < nBilletes) {
               // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println("Enhorabuena, ha obtenido un billete EXTRA");
            System.out.println("##################");
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            contador = contador + 1;
        }
            else{
             System.out.println("##################");
             System.out.println("# ERROR, Maquina Vacia de Billetes");
             System.out.println("# Si ha introducido dinero en la maquina, por favor retirelo");
             System.out.println("##################");
            }
        }
         
         else{
            if(contador < nBilletes) {
             // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            contador = contador + 1;
            }
            else{
            System.out.println("##################");
             System.out.println("# ERROR, Maquina Vacia de Billetes");
             System.out.println("# Si ha introducido dinero en la maquina, por favor retirelo");
             System.out.println("##################");
            }
            }
        }
        else {
            System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");
                    
        }            
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero()
    {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public void vaciarDineroDeLaMaquina()
    {       
          
        if(balanceClienteActual <= 0) {        
                int dineroRetiradoMaquina;
                dineroRetiradoMaquina = totalDineroAcumulado;
                totalDineroAcumulado = 0;
            
                System.out.println("##################");
                System.out.println("# Dinero Extraido de la Maquina:");
                System.out.println("# " + dineroRetiradoMaquina + "� ");
                System.out.println("##################");
                System.out.println();         

        }
        else {
                System.out.println("##################");
                System.out.println("ERROR ");
                System.out.println("Operaci�n en cuerso");
                System.out.println(balanceClienteActual + "� introducidos ");
                System.out.println("Retire el dinero para continuar ");
                System.out.println("##################");
                System.out.println();
        }            
      }         
    }
    


