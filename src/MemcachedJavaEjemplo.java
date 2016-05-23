import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;


public class MemcachedJavaEjemplo {
   public static void main(String[] args) {
      try{
         // Connecting to Memcached server on localhost
         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
         System.out.println("Conexión con el servidor correcta.");
     
         Future fo;
         System.out.println("------ EJEMPLO DE MEMCACHED EN JAVA --------");
         System.out.println("Vida de 30 segundos a cada par clave/valor");
 		System.out.println("1 - Introducir datos");
 		System.out.println("2 - Ver datos");
 		System.out.println("0 - Salir");
 		System.out.println("Introduce opción: "); 
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in);
		entradaTeclado = entradaEscaner.nextLine (); 
		while(!entradaTeclado.equalsIgnoreCase("0")){
		if(entradaTeclado.equalsIgnoreCase("1")){
         String aux ="ej";
         for(int i = 0; i < 5; i++){
        	 System.out.println("Introduciendo: ");
        	 fo = mcc.set(aux+i, 30, "Ejemplo "+i+" java");
        	 System.out.println("clave: ej"+i + "   valor: Ejemplo"+i+" java");
        	 Thread.sleep(2800);
         }
		}
		if(entradaTeclado.equalsIgnoreCase("2")){
	         String aux ="ej";
	         int c = 0;
	         for(int i = 0; i < 5; i++){
	        	 Object o = mcc.get(aux+i);
	        	 if(o!= null){
	        	 System.out.println("clave: "+ aux+i+"  valor: " + o);
	        	 c++;
	        	 }
	         }
	         if(c == 0)
        		 System.out.println("¡Memcached está vacía! :(");
			}
		System.out.println();
		System.out.println("------ EJEMPLO DE MEMCACHED EN JAVA --------");
		System.out.println("Vida de 30 segundos a cada par clave/valor");
		System.out.println("1 - Introducir datos");
		System.out.println("2 - Ver datos");
		System.out.println("0 - Salir");
		System.out.println("Introduce opción: ");
		entradaEscaner = new Scanner (System.in);
		entradaTeclado = entradaEscaner.nextLine (); 
		}
		
        // Shutdowns the memcached client
         mcc.shutdown();
         System.out.println("HASTA LUEGO!");
      }catch(Exception ex){
         System.out.println( ex.getMessage() );
      }
   }
}