package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LogTest {

    @Test
    public void logs(){
        //log.fatal("fatal");
        log.error("error");
        log.warn("warn");//retry
        log.info("info");//steps и system out заменить на инфо
        log.debug("debug");//tech info
        //log.trace("trace");
    }
}
