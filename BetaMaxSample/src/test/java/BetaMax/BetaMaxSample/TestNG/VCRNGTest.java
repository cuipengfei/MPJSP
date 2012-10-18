package BetaMax.BetaMaxSample.TestNG;

import BetaMax.BetaMaxSample.extension.NGRecorderJ;
import BetaMax.BetaMaxSample.extension.NGRule;
import BetaMax.BetaMaxSample.extension.RulesListener;
import co.freeside.betamax.Betamax;
import org.testng.IHookable;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(RulesListener.class)
public class VCRNGTest {
    @NGRule
    public final IHookable recorder = new NGRecorderJ();

    @Test
    @Betamax(tape = "defaultTape1")
    public void shouldReturnHtmlContent() {
        URL url;
        InputStream stream = null;
        DataInputStream dataInputStream;
        String line;

        try {
            url = new URL("http://geoxtorydev.herokuapp.com/trips/1");
            stream = url.openStream(); // throws an IOException
            dataInputStream = new DataInputStream(new BufferedInputStream(stream));

            while ((line = dataInputStream.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    }
}
