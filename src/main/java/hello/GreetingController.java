package hello;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api" )
@Api(value= "Welcome to REST webservice" )
public class GreetingController { 

	private final AtomicLong counter = new AtomicLong();	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET , produces = "application/json")
	public String greeting()
	{
		return "{\"hello\":\"world\"}";
	}
	/*
	@RequestMapping(value= "/greeting" , method = RequestMethod.GET ) 
	public Greeting greeting(@RequestParam(value="name", defaultValue = "World")String name)
	{
		return new Greeting(counter.incrementAndGet(), "Hello " + name );
	}*/
	@ApiOperation( value = "Returns the nth fibonacci number.", 
				notes = "Reverses the letters of each word in a sentence." ,
				response = Long.class )
	@RequestMapping(value= "/Fibonacci" , method = RequestMethod.GET ) 
	public int Fibonacci(@RequestParam(value="n" , defaultValue = "0")int n )
	{
		FibonacciNumber fibonacci = new FibonacciNumber();
		int result= fibonacci.fib( n );
		return result;
	}
	
	@ApiOperation( value = "Reverses the letters of each word in a sentence" ,
				   notes = "Reverses the letters of each word in a sentence." ,
				   response = String.class)	
	@RequestMapping(value= "/ReverseWords" , method = RequestMethod.GET ) 
	public String ReverseWords(@RequestParam(value="sentence" , defaultValue = "")String sentence)
	{		
		Reversing reverse = new Reversing();
		String result= reverse.reverse(sentence, "") ;
		return result;
	}
	@ApiOperation( value = "Your token." ,
				   notes = "Your token." ,
				   response = UUID.class)		
	@RequestMapping(value= "/Token" , method = RequestMethod.GET ) 	
	public String Token()
	{				
		return "https://join.readify.net/Status/1c3d1467-9a0f-49c2-bfc6-e30e99e827ef";
	}
	
	
	@ApiOperation( value = "Returns the type of triange given the lengths of its sides." ,
				   notes= "Returns the type of triange given the lengths of its sides." ,
				   response = Integer.class )			
	@RequestMapping(value= "/TriangleType" , method = RequestMethod.GET ) 	
	public String TriangleType(@RequestParam(value="a"  )int a,@RequestParam(value="b" )int b ,@RequestParam(value="c")int c)
	{  
		String result = "Scalene";
		
	    if (a <= 0 || b <= 0 || c <= 0) return "Error"; // added test
	    if (a == b && b == c) return "EQUILATERAL";
	    if (a >= b+c || c >= b+a || b >= a+c) return "Error";
	    if (b==c || a==b || c==a) return "ISOSCELES";
	    
	    return result;
	}
}
