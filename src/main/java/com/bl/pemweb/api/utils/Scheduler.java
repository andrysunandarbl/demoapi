/**
 * Innovez-One, Proprietary Software Cloud Communications
 * Copyright (c) 2015, Innovez-One and individual contributors
 * by the @authors tag.
 * <p>
 * This program is Proprietary Software: you can not redistribute it and/or modify
 * without license from Innovez-One.
 * <p>
 * Website : http://www.innovez-one.com/
 * Report bugs to <techsupport@innovez-one.com>.
 * Copyright (C) 2015 PT. Innovez-One. All rights reserved.
 */
package com.bl.pemweb.api.utils;

import com.bl.pemweb.api.model.Classroom;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 * Author andry on 11/11/17.
 */
@Component
public class Scheduler {

    private  final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimpMessagingTemplate message;

    private ObjectMapper mapper = new ObjectMapper();

    @Scheduled(fixedRate = 5000)
    private Classroom generateData() throws JsonProcessingException {
        double max = 32.0;
        double min = 28.5;

        // generate simulated data;
        Random random = new Random();
        double temperature = random.nextDouble()*(max-min) + min;
        double humidity = random.nextDouble()*(max-min) + min;
        double pressure = random.nextDouble()*(max-min) + min;

        // create new Classroom model
        Classroom classroom =  new Classroom();
        classroom.setTemperature(temperature);
        classroom.setHumidity(humidity);
        classroom.setPressure(pressure);

        log.info("classrom : "+classroom.toString());

        message.convertAndSend("/topic/classroom",classroom);

        return classroom;

    }
}
