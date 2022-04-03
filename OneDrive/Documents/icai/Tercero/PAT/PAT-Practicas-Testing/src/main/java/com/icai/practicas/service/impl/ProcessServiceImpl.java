package com.icai.practicas.service.impl;

import com.icai.practicas.model.DNI;
import com.icai.practicas.model.Telefono;
import com.icai.practicas.service.ProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {

    public static Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);

    @Override
    public ProcessStep1Response processStep1(ProcessStep1Request step1Request) {

        logger.info("Procesando datos del formulario:");

        DNI dni = new DNI(step1Request.dni());
        Telefono telefono = new Telefono(step1Request.telefono());

        logger.trace("{} Resultado: {}", dni.dniValue(), dni.validar());
        logger.trace("{} Resultado: {}", telefono.telefonoValue(), telefono.validar());

        if(dni.validar() && telefono.validar()) {

            //Realizar algun proceso complejo con esos datos

            logger.info("Procesamiento correcto");
            return new ProcessStep1Response(true,"Validado");
        }

        logger.info("Procesamiento incorrecto");
        return new ProcessStep1Response(false, "No Validado");
    }
}
