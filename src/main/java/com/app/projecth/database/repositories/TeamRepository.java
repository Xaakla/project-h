package com.app.projecth.database.repositories;

import com.app.projecth.database.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByIdIn(List<Long> ids);
}
