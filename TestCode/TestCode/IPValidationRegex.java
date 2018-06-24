import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huiding.teoh, 24/6/2018
 * Question 1
 */
public class IPValidationRegex {

	private Pattern ipPattern;
    private Matcher matcher;
    
    private static final String IPADDRESS_PATTERN = 
    		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IPValidationRegex(){
    	ipPattern = Pattern.compile(IPADDRESS_PATTERN);
    }
    
	public boolean validate(final String ip){		  
	  matcher = ipPattern.matcher(ip);
	  return matcher.matches();	    	    
    }
}
