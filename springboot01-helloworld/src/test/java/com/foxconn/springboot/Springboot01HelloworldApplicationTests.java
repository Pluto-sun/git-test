package com.foxconn.springboot;

import com.foxconn.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class Springboot01HelloworldApplicationTests {
//    @Autowired
//    Person person;
    Logger logger= LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志的级别
        logger.trace("这是trace日记");
        logger.debug("这是debug日记");
        //springboot默认是info级别，没有指定则默认级别，logging.level.（包名）=trace就是trace级别
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }

}
