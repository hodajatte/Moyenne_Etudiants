package présentation;

import dao.IDao;
import dao.daoVolatile.EtudDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.var;
import modèle.Etudiant;
import métier.EtudMétier;
import métier.IEtudiantMétier;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Data
@AllArgsConstructor
public class SimulatorEtudApp {
    static IEtudControleur Etudcontroleur;
    static Scanner clavier = new Scanner(System.in);
    private static boolean estUnNombre(String input){
        try
        {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    ////*****Instanciation des différents composants de l'application ******////
    public static void test1() throws  Exception{
        var dao = new EtudDao();
        var métier = new EtudMétier();
        var controleur = new EtudControleur();
        ///******** Injections des dépendances*********///
        métier.setEtudDao(dao);
        controleur.setEtuMétier(métier);
        ///*****Tester******///
        String rep="";
        do {
            System.out.println("=>[Test 1 ] Calcule de Moyenne <=\n");
            try {
                String input = "";
                while (true){
                    System.out.println("=> Veuillez entrer l'id du crédit:!!!!");
                    input = clavier.nextLine();
                    if(estUnNombre(input)) break;
                    System.err.println("Entréé non valide!!!!");
                }
                long id =Long.parseLong(input);
                controleur.afficher_Moyenne_Etud(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quittez (OUI/NON)? ");
            rep =clavier.nextLine();
        } while (!rep.equalsIgnoreCase("OUI"));
        System.out.println(" Au revoir ^_^ ");
    }
    public static void main(String[] args ) throws Exception {
        test1();

    }

    public static void test2(IEtudControleur etudControleur) throws Exception {

        String daoClass;
        String serviceClass;
        String controllerClass;
        Properties properties = new Properties();
        ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream("présentation/Config.properties");
        if (propertiesFile==null) throw new Exception("fichier config introuvable !!!");
        else {
            try {
                properties.load(propertiesFile);
                daoClass = properties.getProperty("DAO");
                serviceClass= properties.getProperty("SERVICE");
                controllerClass= properties.getProperty("CONTROLLLER");
                propertiesFile.close();
            }
            catch (IOException e){
                throw new Exception("Problème de chargement des propriétés du fichier config");
            }
            finally {
                properties.clear();
            }
        }
        try {
            Class cDao = Class.forName(daoClass);
            Class cMetier = Class.forName(serviceClass);
            Class cControleur =Class.forName(controllerClass);


            var dao =(IDao<Etudiant, Long>)cDao.getDeclaredConstructor().newInstance();
            var metier = (IEtudiantMétier) cMetier.getDeclaredConstructor().newInstance();
            etudControleur = (IEtudControleur)  cControleur.getDeclaredConstructor().newInstance();

            Method setDao = cMetier.getMethod("setCréditDao",IDao.class);
            setDao.invoke(etudControleur, metier);
            etudControleur.afficher_Moyenne_Etud(1L);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void test3() throws  Exception{
        ApplicationContext context= new ClassPathXmlApplicationContext("spring-ioc.xml");
        EtudControleur=(IEtudControleur) context.getBean("controleur");
        EtudControleur.afficher_Moyenne(1L);

}
public static void main(String[] args) throws Exception{
        test3();
    }
}










