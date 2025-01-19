import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.security.cert.Certificate;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoogleClient {
    private static final String endpoint = "https://www.google.com:443/";

    // Send a GET request and print the response status code.
    public static void main(String[ ] args) {
	new GoogleClient().doIt();
    }
    private void doIt() {
	try {
	    URL url = new URL(endpoint);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoInput(true);
	    conn.setRequestMethod("GET");
	    conn.connect();
	    dumpDetails(conn);
	}
	catch(MalformedURLException e) { System.err.println(e); }
	catch(IOException e) { System.err.println(e); }
    }
    private void dumpDetails(HttpsURLConnection conn) {
	try {
	    print("Status code:  " + conn.getResponseCode());
	    print("Cipher suite: " + conn.getCipherSuite());
	    Certificate[ ] certs = conn.getServerCertificates();               //### the DCs
	    for (Certificate cert : certs) {                                   //### give details about each
		print("\tCert. type: " + cert.getType());
		print("\tHash code:  " + cert.hashCode());
		print("\tAlgorithm:  " + cert.getPublicKey().getAlgorithm());
		print("\tFormat:     " + cert.getPublicKey().getFormat());
		print("");
	    }
	    
	}
	catch(Exception e) { System.err.println(e); }
    }

    private void print(Object s) {
	System.out.println(s);
    }
}
