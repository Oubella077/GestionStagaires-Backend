package com.Gestionstagaires.Gestionstagaires.Services.ImpServices;

import com.Gestionstagaires.Gestionstagaires.DTO.stagiaireDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Encadrent;
import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import com.Gestionstagaires.Gestionstagaires.Repository.EncadrentRepo;
import com.Gestionstagaires.Gestionstagaires.Repository.StageRepo;
import com.Gestionstagaires.Gestionstagaires.Repository.StagiaireRepo;

import com.Gestionstagaires.Gestionstagaires.Services.Stagiaireservice;
import com.Gestionstagaires.Gestionstagaires.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StagaireserviceImp implements Stagiaireservice {
    @Autowired
    StagiaireRepo stagiaireRepo;
    @Autowired
    StageRepo stageRepo;
    @Autowired
    EncadrentRepo encadrentRepo;
    @Override
    public List<Stagiaire> getStagiaires(){
    return stagiaireRepo.findAll();
}
    @Override
    public stagiaireDto Addstagiaire(stagiaireDto stagiaire){
        Stagiaire stagiaire1=new Stagiaire();
        stagiaire1.setNom(stagiaire.getNom());
        stagiaire1.setCin(stagiaire.getCin());
        Stage stage=stageRepo.findById(stagiaire.getIdstage()).get();
        stagiaire1.setStage(stage);
        stagiaire1.setEtablissment(stagiaire.getEtablissment());
        stagiaire1.setTel(stagiaire.getTel());
        Encadrent encadrent =encadrentRepo.findById(stagiaire.getIdencadrent()).get();
        stagiaire1.setEncadrent(encadrent);
        stagiaireRepo.save(stagiaire1);
        return stagiaire;
    }
    @Override
    public void Deletestagiaire(Long idstagiaire){
    try{
     stagiaireRepo.deleteById(idstagiaire);
     }catch (Exception e){
    throw new BadRequestException("Error in deleting element");
      }
    }
    @Override
    public stagiaireDto Updatestagiaire(stagiaireDto stagiaire, Long idstagiaire){
        Stagiaire stagiaire1=stagiaireRepo.findById(idstagiaire).get();
        stagiaire1.setPrenom(stagiaire.getPrenom());
        stagiaire1.setNom(stagiaire.getNom());
        stagiaire1.setTel(stagiaire.getTel());
        stagiaire1.setCin(stagiaire.getCin());
        stagiaire1.setDate_Naissance(stagiaire.getDate());

        stagiaireRepo.save(stagiaire1);
      return  stagiaire;
    }

}