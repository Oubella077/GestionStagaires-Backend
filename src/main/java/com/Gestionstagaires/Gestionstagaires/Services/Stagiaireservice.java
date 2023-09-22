package com.Gestionstagaires.Gestionstagaires.Services;
import com.Gestionstagaires.Gestionstagaires.DTO.stagiaireDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface Stagiaireservice {
    List<Stagiaire> getStagiaires();
    stagiaireDto Addstagiaire(stagiaireDto stagiaire);

    void Deletestagiaire(Long idstagiaire);

    stagiaireDto Updatestagiaire(stagiaireDto stagiaire, Long idstagiaire);
}
