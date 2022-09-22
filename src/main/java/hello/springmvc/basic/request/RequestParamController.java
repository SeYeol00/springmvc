package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody//중요, 컨트롤러랑 같이 쓰면 레스트 컨트롤러 역할을 한다.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("username") int memberAge
    ){
        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }

    //권장
    @ResponseBody//중요, 컨트롤러랑 같이 쓰면 레스트 컨트롤러 역할을 한다.
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}",username,age);
        return "ok";
    }
    
    // String, int, Integer 등의 단순 타입이면 @RequestParam도 생략 가능
    @ResponseBody//중요, 컨트롤러랑 같이 쓰면 레스트 컨트롤러 역할을 한다.
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody//중요, 컨트롤러랑 같이 쓰면 레스트 컨트롤러 역할을 한다.
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true)  String username,
            @RequestParam(required = false) Integer age
            // Integer는 null값 허용, 그냥 int는 무조건 값이 들어가야한다.
            // null과 ""은 다르다.
    ){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody//중요, 컨트롤러랑 같이 쓰면 레스트 컨트롤러 역할을 한다.
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            //값이 지정이 안되어있으면 defaultValue로 기본값을 지정한다.
            //defaultValue는 빈문자의 경우에도 설정한 기본 값이 적용된다.
            @RequestParam(required = true, defaultValue = "guest")  String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age
            // Integer는 null값 허용, 그냥 int는 무조건 값이 들어가야한다.
            // null과 ""은 다르다.
    ){
        log.info("username={}, age={}",username,age);
        return "ok";
    }

    @ResponseBody//중요, 컨트롤러랑 같이 쓰면 레스트 컨트롤러 역할을 한다.
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String,Object> paramMap
            //파라미터를 Map, MultiValueMap으로 조회가 가능하다.
            ){
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }
}
