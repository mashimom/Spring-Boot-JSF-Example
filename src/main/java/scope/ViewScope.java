package scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * This uses the FacesContext view map as a datastore for a scope in the Spring
 * Framework
 * <p/>
 * More simply this is a view scope implementation that works in spring
 *
 * @author Optimus Prime(From the primefaces
 *         team)(http://blog.primefaces.org/?p=702)
 */
public class ViewScope implements Scope {
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance()
                .getViewRoot().getViewMap();
        if (viewMap.containsKey(name)) {
            return viewMap.get(name);
        }
        Object object = objectFactory.getObject();
        viewMap.put(name, object);
        return object;
    }

    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
                .remove(name);
    }

    public String getConversationId() {
        return null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        // Not supported
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}