package eu.axasoft.websocketpush;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public String countDown() {

        if (counter % 10 == 0) {
            return "retry.xhtml";
        }

        testChannel.send(counter);
        counter++;
        return "";
    }

    public String process() {

        for (int i = 5; i > 0; i--) {
            testChannel.send(i);
            if (i == 1) {
                testChannel.send("Redirect...");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OmniPushBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "retry.xhtml?faces-redirect=true";
    }

    public int getCounter() {
        return counter;
    }

}
