package com.Gestionstagaires.Gestionstagaires.Repository;

import com.Gestionstagaires.Gestionstagaires.Entities.Absent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AbsentRepo extends JpaRepository<Absent,Long> {
}