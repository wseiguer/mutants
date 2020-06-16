package meli.exam.mutants.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

import meli.exam.mutants.services.DnaAnalyzerService;

public class BaseController {
    @Autowired
    protected DnaAnalyzerService dnaAnalyzerService;
    @Autowired
    protected ObjectMapper objectMapper;
}