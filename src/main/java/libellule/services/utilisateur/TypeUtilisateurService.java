package libellule.services.utilisateur;

import libellule.domain.utilisateur.TypeUtilisateur;

import java.util.List;

public interface TypeUtilisateurService {

    List<TypeUtilisateur> findAll();

    TypeUtilisateur findOne();

    void insertOne(TypeUtilisateur type);

    void insertMany(List<TypeUtilisateur> types);

    void deleteOne(Integer type);

    void updateOne(TypeUtilisateur type);
}
