package hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Simple service to be used both by the JSF Controller and the Spring MVC
 * Service to demonstrate that they are working together in the same context.
 *
 * @author Caleb
 */
@Service
@Scope("session")
public class TestService implements Serializable {
    private int counter = 0;

    public String getMessage() {
        return "This is my message " + counter++;
    }
}
