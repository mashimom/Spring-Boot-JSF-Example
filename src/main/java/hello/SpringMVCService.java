package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@Scope("request")
public class SpringMVCService implements Serializable {

    @Autowired
    TestService testService;

    /**
     * Displays the message from the test service including information in the
     * session scope
     * <p/>
     * This is a proof that calling the Spring MVC service is on the same
     * context as the JSF views(A problem I had before)
     */
    @RequestMapping("/greeting")
    public String greeting() {
        return testService.getMessage();
    }
}
