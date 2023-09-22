package com.Gestionstagaires.Gestionstagaires.Repository;

import com.Gestionstagaires.Gestionstagaires.Entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepo extends JpaRepository<Division,Long> {
}