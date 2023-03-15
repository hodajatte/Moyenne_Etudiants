package dao.daoVolatile;
import modèle.Etudiant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EtudDao  {
public static Set<Etudiant> BD_Etudiants(){
    return new HashSet<Etudiant>(
            Arrays.asList(
                    new Etudiant(1L, "Hoda", "Jatte", 16.0, 15.0, 18.0, 25, 25, 50),
                    new Etudiant(2L, "Anissa", "Kheir allah", 16.0, 17.0, 14.0, 25, 25, 50),
                    new Etudiant(3L, "Laila", "Khelfaoui", 14.0, 15.0, 16.0, 25, 25, 50),
                    new Etudiant(4L, "Ahlam", "Berrada", 12.5, 10.25, 11.75, 25, 25, 50)
            )
    );
}



    public static Etudiant trouverParId(Long id)
    {
        System.out.println("trouver l'etudiant numéro :" + id);
        return BD_Etudiants()
                .stream()
                .filter(Etud->Etud.getId()==id).findFirst()
                .orElse(null);
    }



}
