package métier;
import dao.daoVolatile.EtudDao;
import lombok.*;
import modèle.Etudiant;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EtudMétier{
     EtudDao etudDao;
    public Etudiant Calculer_Moyenne_Etud(Long idEtud) throws Exception{
        var Etu = etudDao.trouverParId(idEtud);
        if (Etu==null)
            throw new Exception("L'id du crédit est incorrecte::[Crédit non trouvé]");
        else {
            double etuNote_controle = Etu.getNote_controle();
            double   etuNote_examen= Etu.getNote_Examen();
            double etuNote_tp = Etu.getNote_tp();
            int Pourcentage_note_controle=25;
            int Pourcentage_note_tp=25;
            int Pourcentage_note_Examen=50;
            double Moyenne=etuNote_controle*Pourcentage_note_controle+etuNote_examen*Pourcentage_note_Examen+etuNote_tp*Pourcentage_note_tp;
            Etu.setMoyenne_Etud(Moyenne);
            return Etu;


        }
    }



}
