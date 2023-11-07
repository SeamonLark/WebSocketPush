package eu.axasoft.websocketpush;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

/**
 *
 * @author kralmatej
 */
@Named(value = "omniPushBean")
@ApplicationScoped
public class OmniPushBean {

    @Inject
    @Push(channel = "omniChannel")
    private PushContext testChannel;
    
    private int counter = 1;

    public OmniPushBean() {        
    }

    public void sendMessage() {
        testChannel.send(counter);
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}
