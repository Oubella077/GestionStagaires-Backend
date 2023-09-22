package com.Gestionstagaires.Gestionstagaires.Repository;

import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepo extends JpaRepository<Stage,Long> {
}
