package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//컨트롤러의 반환 값이 스트링이면 뷰 이름으로 인식 그러나 레스트컨트롤러는 그대로 반환한다.
@RestController//문자열을 반환하면 그대로 스트링으로 반환한다.
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){

        String name = "string";

        System.out.println("name = " + name);

        //로그의 레벨을 정할 수 있음
        //로그의 올바른 사용법이다.
        log.trace(" trace log={}",name);
        log.debug(" debug log={}",name);
        log.warn(" warn log={}",name);
        log.info(" info log={}",name);
        log.error("error");

        return "ok";
    }
}
