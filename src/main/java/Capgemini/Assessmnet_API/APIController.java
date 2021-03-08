package Capgemini.Assessmnet_API;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic Controller Class
 * @author Christopher Tassone
 *
 */

@RestController
public class APIController   
{  
	@RequestMapping("/")  
	public String hello()   
	{  
		return "Welcome to Capgemini Assessment REST API<p>Address: http://localhost:8080/data?numbers=5,4,6,1<p><a href=\"http://localhost:8080/data?numbers=5,4,6,1\">Click Me</a>";  
	}  

	/**
	 * Will take in a List of Integers and perform the requested function using java Stream
	 * @param numbers
	 * @return
	 */
	@RequestMapping("/data")  
	public static Map<String, Object> output(@RequestParam List<Integer> numbers)   
	{  
		HashMap<String, Object> map = new HashMap<>();

		if (numbers.size() >= 3) {
			int sum = numbers.parallelStream()
					.sorted(Comparator.reverseOrder())
					.limit(3)
					.map(n  -> n * n)
					.reduce(0, Integer::sum);

			// Square root the sumNumbers
			double squareNumbers = Math.sqrt(sum);

			// Reduce to only two decimal points
			BigDecimal bd = new BigDecimal(squareNumbers).setScale(2, RoundingMode.HALF_UP);
			double squareNumbersRound = bd.doubleValue();

			map.put("output", squareNumbersRound);
		} else 
		{
			map.put("Error", "Needs to be three or more numeric inputs");

		}
		return map;
	}  

}  