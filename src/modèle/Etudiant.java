package modèle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant {
    Long id;
    String Nom;
    String Prénom;
    Double note_controle;
    Double note_tp;
    Double note_Examen;
    Double Moyenne_Etud;
      int POURCENTAGE_NOTE_CONTROLE=25;
     int POURCENTAGE_NOTE_TP=25;
     int POURCENTAGE_NOTE_EXAMEN=50;

    public Etudiant(long id, String Nom, String Prénom, Double note_controle, Double note_tp, Double note_Examen, int pourcentage_controle, int pourcentage_tp, int pourcentage_examen) {
    }


    public Long getId() {
        return id;
    }
    @Override
    public String toString()
    {
        var EtudStr= "====>voilà votre moyenne finale de matière:<====\n";
        EtudStr +="====>Etudiant numéro  " + getId() + "  \n";
        EtudStr +="====>Nom de l'etudiant " +getNom() + "\n";
        EtudStr +="====>Prénom de l'etudiant " + getPrénom() +"\n";
        EtudStr +="===>Note de controle :" + getNote_controle() + "\n";
        EtudStr +="===> Note du tp :" + getNote_tp() + "\n";
        EtudStr +="===> Note d'examen :" +getNote_Examen() + "\n";
        EtudStr +="===> pourcentage  du note de controle:" + getPOURCENTAGE_NOTE_CONTROLE()  + "\n";
        EtudStr +="===> pourcentage  du note de tp:" + getPOURCENTAGE_NOTE_TP()+ "\n";
        EtudStr +="===> pourcentage  du note de controle:" + getPOURCENTAGE_NOTE_EXAMEN()+ "\n";
        EtudStr +="===>La moyenne du note :" + (getMoyenne_Etud()==0.0? "Non Calculée": getMoyenne_Etud() )  + "\n" ;
        EtudStr +="====>&&&&&&&&&&&& Fin de calcul &&&&&&&&&&&&&&& \n";
        return EtudStr;

    }


}
