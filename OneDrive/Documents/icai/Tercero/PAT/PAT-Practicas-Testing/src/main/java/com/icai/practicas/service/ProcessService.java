package com.icai.practicas.service;

public interface ProcessService {

    public record ProcessStep1Request(String fullName, String dni, String telefono) { }
    public record ProcessStep1Response(boolean status, String message) { }

    ProcessStep1Response processStep1(ProcessStep1Request step1Request);

}
