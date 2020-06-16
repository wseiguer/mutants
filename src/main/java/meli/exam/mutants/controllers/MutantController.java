package meli.exam.mutants.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/mutant")
public class MutantController extends BaseController {

    @PostMapping
    public ResponseEntity<String> isMutant(@RequestBody String[] dna) {
        Boolean isMutant = dnaAnalyzerService.isMutant(dna);
        HttpStatus status;
        String body;
        if (isMutant) {
            status = HttpStatus.OK;
            body = "{\"message\": \"Welcome! Mutant Friend\"}";
        } else {
            status = HttpStatus.FORBIDDEN;
            body = "{\"message\": \"Sorry! only mutants allowed\"}";
        }
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(body);
    }
}