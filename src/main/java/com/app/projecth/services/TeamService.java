package com.app.projecth.services;

import com.app.projecth.database.entities.Team;
import com.app.projecth.database.repositories.TeamRepository;
import com.app.projecth.dtos.team.TeamNewEdit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Team> findByIdIn(List<Long> ids) {
        return teamRepository.findByIdIn(ids);
    }

    @Transactional
    public Team save(TeamNewEdit team) {
        return teamRepository.save(new Team(team.getName(), team.getAcronym(), "", team.getColor()));
    }

    @Transactional
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Transactional
    public Team update(Long id, TeamNewEdit team) {
        var updatedTeam = this.findById(id);
        updatedTeam.setName(team.getName());
        updatedTeam.setAcronym(team.getAcronym());
        updatedTeam.setColor(team.getColor());

        return this.save(updatedTeam);
    }

    @Modifying
    @Transactional
    public void delete(Long id) {
        this.teamRepository.deleteById(id);
    }
}
