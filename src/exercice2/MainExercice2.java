package exercice2;

import java.util.List;

import datamocklib.Person;
import datamocklib.TxtHelper;
import exercice2.models.*;

public class MainExercice2 implements Exo2 {

    /* EXO 2
     * Recupérez depuis le serveur la liste des gens qui sont nés à Chambéry.
     * La récupération de Data se fait dans l'ordre :
     *  - Récupération de data sur le server grâce à TxtHelper.getDataFromTxt("server.txt");
     *  - Vider la base de données locale grâce à la fonction TxtHelper.clearDataLocal();
     *  - Insérer les données dans la database locale grâce à la fonction TxtHelper.insertDataInTxt(line, "local.txt")
     *  - Afficher les données locale grace à TxtHelper.getDataFromTxt("local.txt")
     */
    @Override
    public void displayPersonFromChambery() {
        List<String> data = TxtHelper.getDataFromTxt("server.txt");
        try {
            TxtHelper.clearDataLocal();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for (String line : data) {
            if (line.contains("Chambéry")) {
                TxtHelper.insertDataInTxt(line, "local.txt");
            }
        }
        System.out.println(TxtHelper.getDataFromTxt("local.txt"));
    }

    /*
     * Recupérez depuis le serveur la liste des gens qui ont plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     * Tips : Vous avez dans la class Person la fonction getAge();
     */
    @Override
    public void displayBoomers() {
        List<String> data = TxtHelper.getDataFromTxt("server.txt");
        try {
            TxtHelper.clearDataLocal();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for (String line : data) {
            Person person = new Person(line);
            if (person.getAge() > 25) {
                TxtHelper.insertDataInTxt(line, "local.txt");
            }
        }
        System.out.println(TxtHelper.getDataFromTxt("local.txt"));
    }

    /*
     * Recupérez depuis le serveur la liste des gens de sexe féminin.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemales() {
        List<String> data = TxtHelper.getDataFromTxt("server.txt");
        try {
            TxtHelper.clearDataLocal();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for (String line : data) {
            Person person = new Person(line);
            if (person.getGender().equals("f")) {
                TxtHelper.insertDataInTxt(line, "local.txt");
            }
        }
        System.out.println(TxtHelper.getDataFromTxt("local.txt"));
    }

    /*
     * Recupérez depuis le serveur la liste des femmes de plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemaleBoomers() {
        List<String> data = TxtHelper.getDataFromTxt("server.txt");
        try {
            TxtHelper.clearDataLocal();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for (String line : data) {
            Person person = new Person(line);
            if (person.getGender().equals("f") && person.getAge() > 25) {
                TxtHelper.insertDataInTxt(line, "local.txt");
            }
        }
        System.out.println(TxtHelper.getDataFromTxt("local.txt"));
    }

    public static void main(String[] args) {
        Exo2 exo2 = new MainExercice2();
        exo2.displayBoomers();
    }
}
