package com.Gestionstagaires.Gestionstagaires.Repository;

import com.Gestionstagaires.Gestionstagaires.Entities.Absent;
import com.Gestionstagaires.Gestionstagaires.Entities.Stage;
import com.Gestionstagaires.Gestionstagaires.Entities.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StagiaireRepo extends JpaRepository<Stagiaire,Long> {
    @Query("SELECT c FROM Stagiaire c WHERE c.cin like :kw")
    Stagiaire findByCin(@Param("kw") String cin);
}
