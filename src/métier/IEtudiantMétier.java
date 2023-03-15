package métier;

import modèle.Etudiant;

public interface IEtudiantMétier {
    Etudiant Calculer_Moyenne_Etud(Long idEtud) throws Exception;

}
