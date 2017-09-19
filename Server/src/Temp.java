import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Provide service to convert Fahrenheit to Celsius  
 * 
 * @author Rahul Kumar
 *
 */
@WebService
public class Temp {
	
	/**
	 * Convert temperature from Fahrenheit to Celsius
	 * 
	 * @param temperature
	 * @return
	 */
	@WebMethod
	public double convertFahrenheitToCelsius(double temperature){
		return Math.floor((((temperature - 32) * 5)/9)*100)/100;
	}

}