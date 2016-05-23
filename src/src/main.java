import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by FRANCIS CACERES on 20/5/16.
 */
public class main {
    public static void main(String[] args) throws Exception {
        int countParrafos = 0, countImagen = 0, countFormularios =0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Direccion url a la que quiere acceder: ");
        String name = br.readLine();

        Document doc = Jsoup.connect(name).get();

        int lines = doc.html().split("\n").length; //Convierto el doc en un string, luego separo a traves de \n en arreglo
                                                   // de strings y al final busco el tamano del arreglo para saber cuantas lineas

        System.out.println("Lineas: " + lines);

        Elements parrafos = doc.getElementsByTag("p");
        for (Element parrafo : parrafos) {
            countParrafos++;
        }

        System.out.println("Parrafos: " + countParrafos);

        Elements imagenes = doc.getElementsByTag("img");
        for (Element imagen : imagenes) {
            countImagen++;
        }

        System.out.println("Imagenes: " + countImagen);

        Elements formularios = doc.getElementsByTag("form");
        for (Element formulario : formularios) {
            countFormularios++;
        }

        System.out.println("Formularios: " + countFormularios);

        Elements forms = doc.getElementsByTag("form");
        for (Element form : forms) {
            Elements entradas = doc.getElementsByTag("input");
            for(Element entrada : entradas) {
                System.out.println();
                System.out.println("Nombre: " + entrada.attr("name"));
                System.out.println("Tipo: " + entrada.attr("type"));
            }
        }
    }
}
