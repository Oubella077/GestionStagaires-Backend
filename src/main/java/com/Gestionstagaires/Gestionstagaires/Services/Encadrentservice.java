package com.Gestionstagaires.Gestionstagaires.Services;

import com.Gestionstagaires.Gestionstagaires.DTO.EncadrentDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Encadrent;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Encadrentservice {
    
    List<Encadrent> getEncadrent();

    Encadrent AddEncadrent(EncadrentDto encadrent);

    void DeleteEncadrent(Long id);

    Encadrent UpdateEncadrent(Encadrent encadrent, Long id);
}
