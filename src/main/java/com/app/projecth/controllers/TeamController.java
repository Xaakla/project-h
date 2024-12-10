package com.app.projecth.controllers;

import com.app.projecth.dtos.team.TeamList;
import com.app.projecth.dtos.team.TeamNewEdit;
import com.app.projecth.services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping()
    public ResponseEntity<List<TeamList>> findAll() {
        return ResponseEntity.ok(teamService.findAll().stream().map(TeamList::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamList> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new TeamList(teamService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<TeamList> save(@RequestBody TeamNewEdit team) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new TeamList(teamService.save(team)));
    }
}
