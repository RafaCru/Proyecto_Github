package Peticiones;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;


public class RepositorioGitHub {
    public static void main (String [] args) {

        DireccionHttp peticion=new DireccionHttp();

        try{
            int opcion=2;
            String[] usrorg ={"users","orgs"};
            Scanner sc =new Scanner(System.in);

            while (opcion >1){
                System.out.println("Pulsa 0 para un Usuario  1 para una organización de GitHub ");
                opcion = sc.nextInt();
            }

            sc =new Scanner(System.in);
            System.out.println("Introduce el nombre de la organizacion o usuario de GitHub");
            String nombre= sc.nextLine();

            String str = peticion.PeticionGet("https://api.github.com/"+usrorg[opcion]+"/"+nombre+"/repos");

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(str);
            JSONArray json = (JSONArray) obj;

            for (int i = 0; i < json.size(); i++) {
                JSONObject object =(JSONObject) json.get(i);
                String name = object.get("name").toString();
                String fullName = object.get("full_name").toString();
                System.out.println("name: " +name+ "        Full name: "+fullName);
            }

            System.out.println();
            System.out.println("Total: " +json.size());

        }catch (Exception e){

        }




    }
}
