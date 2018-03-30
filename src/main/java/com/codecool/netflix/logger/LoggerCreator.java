package com.codecool.netflix.logger;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class LoggerCreator implements LoggerService {


    public Logger getLogger(){
        return Logger.getLogger(getClass());
    }
}
