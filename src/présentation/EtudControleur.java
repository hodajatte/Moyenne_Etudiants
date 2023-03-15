package présentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import métier.EtudMétier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudControleur implements IEtudControleur {
    EtudMétier EtuMétier;
     public void afficher_Moyenne_Etud(Long idEtu) throws Exception{
        var Moyenne_finale_Etu=EtuMétier.Calculer_Moyenne_Etud(idEtu);
        System.out.println(Moyenne_finale_Etu +"Félécitations ^_^" );

    }


}
