package meli.exam.mutants.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import meli.exam.mutants.services.dtos.Stats;

@Controller
@RequestMapping(path = "/stats")
public class StatsController extends BaseController {

    @GetMapping
    public ResponseEntity<String> GetStats() throws JsonProcessingException {
        Stats stats = dnaAnalyzerService.getStats();
        String body = objectMapper.writeValueAsString(stats);
        return ResponseEntity.ok(body);
    }
}