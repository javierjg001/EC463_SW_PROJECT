package com.icai.practicas.controller;

import com.icai.practicas.service.ProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api/v1")
public class ProcessController {

    public static Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private ProcessService processService;

    @PostMapping(
            path="/process-step1-legacy",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> processDataLegacy(@RequestBody MultiValueMap<String, String> data1) {

        logger.info("Procesando request en el endpoint Legacy");

        String fullNameRaw = data1.get("fullName").get(0);
        String dniRaw = data1.get("dni").get(0);
        String telefonoRaw = data1.get("telefono").get(0);

        var processStep1Request = new ProcessService.ProcessStep1Request(fullNameRaw, dniRaw, telefonoRaw);
        var result = processService.processStep1(processStep1Request);

        if(result.status()) {
            return ResponseEntity.ok().body(ResponseHTMLGenerator.message1);
        }

        return ResponseEntity.ok().body(ResponseHTMLGenerator.message2);
    }

    record DataRequest(
            @NonNull
            @NotEmpty
            String fullName,

            @NonNull
            @NotEmpty
            String dni,

            @NonNull
            @NotEmpty
            String telefono) {}
    record DataResponse (String result) {}

    @PostMapping(
            path="/process-step1",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse> processData(
            @Valid @RequestBody DataRequest data1, BindingResult bindingResult) {

        logger.info("Procesando request en el endpoint");

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new DataResponse("KO"));
        }

        String fullNameRaw = data1.fullName();
        String dniRaw = data1.dni();
        String telefonoRaw = data1.telefono();

        var processStep1Request = new ProcessService.ProcessStep1Request(fullNameRaw, dniRaw, telefonoRaw);
        var result = processService.processStep1(processStep1Request);

        if(result.status()) {
            return ResponseEntity.ok().body(new DataResponse("OK"));
        }

        return ResponseEntity.ok().body(new DataResponse("KO"));
    }

}
