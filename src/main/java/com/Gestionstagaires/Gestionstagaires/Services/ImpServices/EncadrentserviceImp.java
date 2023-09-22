package com.Gestionstagaires.Gestionstagaires.Services.ImpServices;

import com.Gestionstagaires.Gestionstagaires.DTO.EncadrentDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Division;
import com.Gestionstagaires.Gestionstagaires.Entities.Encadrent;
import com.Gestionstagaires.Gestionstagaires.Repository.DivisionRepo;
import com.Gestionstagaires.Gestionstagaires.Repository.EncadrentRepo;
import com.Gestionstagaires.Gestionstagaires.Services.Encadrentservice;
import com.Gestionstagaires.Gestionstagaires.Services.Stageservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EncadrentserviceImp implements Encadrentservice {
    EncadrentRepo encadrentRepo;
    DivisionRepo divisionRepo;
    @Override
    public List<Encadrent> getEncadrent() {
        return encadrentRepo.findAll();
    }
    @Override
    public Encadrent AddEncadrent(EncadrentDto encadrentDto) {
        Encadrent encadrent=new Encadrent();
        BeanUtils.copyProperties(encadrentDto, encadrent);
        Division division=divisionRepo.findById(encadrentDto.getIdDivision()).get();
        encadrent.setDivision(division);
        return encadrentRepo.save(encadrent);}
    @Override
    public void DeleteEncadrent(Long id) {
        encadrentRepo.deleteById(id);}
    @Override
    public Encadrent UpdateEncadrent(Encadrent encadrent, Long id) {
        Encadrent encadrent1=encadrentRepo.findById(id).get();
        encadrent1.setCin(encadrent.getCin());
        encadrent1.setNom(encadrent.getNom());
        encadrent1.setPrenom(encadrent.getPrenom());
        encadrent1.setEmail(encadrent.getEmail());

        return encadrentRepo.save(encadrent1);
    }
}
