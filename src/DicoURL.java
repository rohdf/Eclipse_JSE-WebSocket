import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class DicoURL extends Hashtable<String, String>{
 URLConnection urlConnection;
 
 public DicoURL(String unURL){
 try{
 URL url = new URL(unURL);
 urlConnection = url.openConnection();
 }
 catch(IOException e) {
    System.out.println("Pas de connexion");
 }
 }
 
 public void charger(){
	 try{
	 info();
	 System.out.println("***** Elements du dictionnaire *****");
	 BufferedReader flux = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	 String elementDuDico;
	 while((elementDuDico = flux.readLine()) != null){
	 StringTokenizer st ;
	st = new StringTokenizer(elementDuDico,"/");
	 put(st.nextToken(),st.nextToken());
	 }
	 flux.close();
	 } catch(IOException e) {e.printStackTrace();}

	}
 
 public void info() { 

	 System.out.println("Type de doc : " + urlConnection.getContentType()); 

	 System.out.println("Taille du doc : " + urlConnection.getContentLength()); 

	 System.out.println("Droit lecture : " + urlConnection.getDoInput()); 

	 System.out.println("Droit écriture: " +

	 urlConnection.getDoOutput());

	 }

}