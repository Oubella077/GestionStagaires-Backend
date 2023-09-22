package com.Gestionstagaires.Gestionstagaires.Services.ImpServices;

import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import com.Gestionstagaires.Gestionstagaires.Repository.StageRepo;
import com.Gestionstagaires.Gestionstagaires.Services.Stageservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class StageserviceImp implements Stageservice {
    StageRepo stageRepo;
    @Override
    public List<Stage> getStages() {
        return stageRepo.findAll();
    }
    @Override
    public Stage Addstage(Stage stage) {
        return stageRepo.save(stage);
    }
    @Override
    public void Deletestage(Long idstage) {
       stageRepo.deleteById(idstage);
    }
    @Override
    public Stage Updatestage(Stage stage, Long idstage){
        Stage stage1=stageRepo.findById(idstage).get();
        stage1.setSujet(stage.getSujet());
        stage1.setDate_debut(stage.getDate_debut());
        stage1.setDate_fin(stage.getDate_fin());
        return  stageRepo.save(stage1);
    }
}
