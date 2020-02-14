package com.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: StevenClise
 * @Date : 2019/11/26
 **/
@Component
public class ApplicationService implements ApplicationRunner {

    Log logger= LogFactory.getLog(ApplicationService.class);



    @Override
    public void run(ApplicationArguments args) {
        logger.info("罗氏健初始化成功");
    }
}
