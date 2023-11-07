package eu.axasoft.websocketpush;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author kralmatej
 */
@Named(value = "jsfPushBean")
@ApplicationScoped
public class JsfPushBean {

    @Inject
    @Push(channel = "jsfChannel")
    private PushContext jsfChannel;
    
    private int counter = 1;

    public JsfPushBean() {        
    }

    public void sendMessage() {
        jsfChannel.send(counter);
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}
