package com.Gestionstagaires.Gestionstagaires.Services.ImpServices;

import com.Gestionstagaires.Gestionstagaires.Entities.Division;
import com.Gestionstagaires.Gestionstagaires.Repository.DivisionRepo;
import com.Gestionstagaires.Gestionstagaires.Services.Absentservice;
import com.Gestionstagaires.Gestionstagaires.Services.Divisionservice;
import com.Gestionstagaires.Gestionstagaires.exception.BadRequestException;
import com.Gestionstagaires.Gestionstagaires.exception.ExceptionDetails;
import com.Gestionstagaires.Gestionstagaires.exception.ExceptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DivisionserviceImp implements Divisionservice {
    DivisionRepo divisionRepo;
    @Override
    public Division Updatedivision(Division dv, Long id) {
        Division division=divisionRepo.findById(id).orElseThrow(()->new BadRequestException("division not Found "));
       division.setNom_Div(dv.getNom_Div());
        return division;
    }

    @Override
    public void Deletedivision(Long id) {
     divisionRepo.deleteById(id);
    }

    @Override
    public Division Adddivision(Division dv) {
        return divisionRepo.save(dv);
    }

    @Override
    public List<Division> getdivision() {
        return divisionRepo.findAll();
    }
}
