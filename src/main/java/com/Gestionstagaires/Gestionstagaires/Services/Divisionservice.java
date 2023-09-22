package com.Gestionstagaires.Gestionstagaires.Services;

import com.Gestionstagaires.Gestionstagaires.Entities.Division;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface Divisionservice {
    Division Updatedivision(Division dv, Long id);

    void Deletedivision(Long id);

    Division Adddivision(Division dv);

    List<Division> getdivision();
}
