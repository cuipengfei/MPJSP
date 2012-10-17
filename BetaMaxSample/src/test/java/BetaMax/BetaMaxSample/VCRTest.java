package BetaMax.BetaMaxSample;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Rule;
import org.junit.Test;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;

public class VCRTest {
	@Rule
	public Recorder recorder = new Recorder();

	@SuppressWarnings("deprecation")
	@Betamax(tape = "my test vcr tape")
	@Test
	public void shouldReturnResultWhenWIFIIsTurnedOff() throws IOException {
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
