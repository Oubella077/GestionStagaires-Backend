package com.Gestionstagaires.Gestionstagaires.Services.ImpServices;

import com.Gestionstagaires.Gestionstagaires.DTO.AbsentDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Absent;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import com.Gestionstagaires.Gestionstagaires.Repository.AbsentRepo;
import com.Gestionstagaires.Gestionstagaires.Repository.StagiaireRepo;
import com.Gestionstagaires.Gestionstagaires.Services.Absentservice;
import com.Gestionstagaires.Gestionstagaires.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.rmi.server.LogStream.log;

@Service
@Slf4j
public class AbsentserviceImp implements Absentservice {
    @Autowired
    AbsentRepo absentRepo;
    @Autowired
    StagiaireRepo stagiaireRepo;
    @Override
    public Absent Updateabsent(Absent As, Long id) {
        Absent absent=absentRepo.findById(id).get();
        absent.setDate_fin(As.getDate_fin());
        absent.setJustification(As.getJustification());
        return absentRepo.save(absent);
    }
    @Override
    public AbsentDto Addabsent(AbsentDto Ab,Long id) {
        Absent absent=new Absent();
        absent.setDate_debut(Ab.getDate_debut());
        Stagiaire stagiaire=stagiaireRepo.findById(id)
                .orElseThrow(()-> new BadRequestException("Stagiaire not found "));
        absent.setStagiaire(stagiaire);
        absentRepo.save(absent);
        return Ab ;
    }
    public Stagiaire findById(Long id) {
        try {
            Stagiaire stagiaire= stagiaireRepo.findById(id).get();
            return stagiaire;
        } catch (Exception e) {
            throw new BadRequestException("error finding Stagiaire");
        }
    }
    @Override
    public List<Absent> getabsent() {
        return absentRepo.findAll();
    }
    @Override
    public void deleteabsent(Long id){
      absentRepo.deleteById(id);
    }

}
