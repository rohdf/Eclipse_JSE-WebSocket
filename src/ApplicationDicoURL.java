public class ApplicationDicoURL{
	
 public static void main(String[] args){
	 
 DicoURL dico = new DicoURL(args[0]);
 dico.charger();
 
 for (int i=1 ; i<args.length ; i++)
	 System.out.println(args[i] +" : "+
	dico.get(args[i]).toString());
 }
}