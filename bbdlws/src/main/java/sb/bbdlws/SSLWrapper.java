package sb.bbdlws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.bloomberg.datalic.dlps.PerSecurityWS;
import com.bloomberg.datalic.dlps.PerSecurityWS_Service;

public class SSLWrapper {

	private static Logger logger = Logger.getLogger(SSLWrapper.class.getName());
	private static String blpWsdlFilePath = "c:/whatever/blp-dlws.wsdl";
	private static String keystoreFilePath = "c:/whatever/my-keystore.jks";
	private static String keystorePassword = "my-keystore-password";
	private static String keystoreType = "JKS";

	// PerSecurityWS* are classes generated from Blp DLWS wsdl
	public static PerSecurityWS getWrappedPerSecurityWSPort() {
		PerSecurityWS port = null;
		try {
			PerSecurityWS_Service service = new PerSecurityWS_Service(new URL("file:///" + blpWsdlFilePath));
			port = service.getPerSecurityWSPort();
			setupTLS(port);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error in getting webservice port: ", e);
		}
		return port;
	}

	private static void setupTLS(PerSecurityWS port) throws FileNotFoundException, IOException, GeneralSecurityException {
		TLSClientParameters tlsCP = new TLSClientParameters();

		KeyStore keyStore = KeyStore.getInstance(keystoreType);
		keyStore.load(new FileInputStream(keystoreFilePath), keystorePassword.toCharArray());
		KeyManager[] myKeyManagers = getKeyManagers(keyStore, keystorePassword);
		tlsCP.setKeyManagers(myKeyManagers);

		Client client = ClientProxy.getClient(port);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        // Apache CXF default to allow chunking true.  
        // This caused problem if the other side do not support it, which is the case for Blp
        httpClientPolicy.setAllowChunking(false);
        httpConduit.setClient(httpClientPolicy);
        httpConduit.setTlsClientParameters(tlsCP);
	}

	private static KeyManager[] getKeyManagers(KeyStore keyStore, String keyPassword) throws GeneralSecurityException, IOException {
		String alg = KeyManagerFactory.getDefaultAlgorithm();
		char[] keyPass = keyPassword != null ? keyPassword.toCharArray() : null;
		KeyManagerFactory fac = KeyManagerFactory.getInstance(alg);
		fac.init(keyStore, keyPass);
		return fac.getKeyManagers();
	}
}