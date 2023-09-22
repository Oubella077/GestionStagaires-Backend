package com.Gestionstagaires.Gestionstagaires.Services;

import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Stageservice {

    List<Stage> getStages();

    Stage Addstage(Stage stage);

    void Deletestage(Long idstage);

    Stage Updatestage(Stage stage, Long idstage);
}
