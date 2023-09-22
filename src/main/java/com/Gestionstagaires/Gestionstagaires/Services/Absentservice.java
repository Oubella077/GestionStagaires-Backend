package com.Gestionstagaires.Gestionstagaires.Services;

import com.Gestionstagaires.Gestionstagaires.DTO.AbsentDto;
import com.Gestionstagaires.Gestionstagaires.Entities.Absent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface Absentservice {
   Absent Updateabsent(Absent dv, Long id);

    AbsentDto Addabsent(AbsentDto dv,Long id);

    List<Absent> getabsent();

    void deleteabsent(Long id);
}
