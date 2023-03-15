package présentation;

import métier.IEtudiantMétier;

public interface IEtudControleur {
    IEtudiantMétier Etu_Metier = null;

    void afficher_Moyenne_Etud(Long idEtu) throws Exception;


}
