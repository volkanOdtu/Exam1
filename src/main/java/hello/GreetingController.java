package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api") 
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/")
	public String welcome()
	{
		return "Welcome to RESTful web service";
	}
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "World")String name)
	{
		return new Greeting(counter.incrementAndGet(), "Hello " + name );
	}
	@RequestMapping("/Fibonacci")
	public int fibonacci(@RequestParam(value="n" , defaultValue = "0")int n )
	{
		FibonacciNumber fibonacci = new FibonacciNumber();
		int result= fibonacci.fib( n );
		return result;
	}
	
	@RequestMapping("/ReverseWords")
	public String reverse(@RequestParam(value="sentence" , defaultValue = "")String sentence)
	{		
		Reversing reverse = new Reversing();
		String result= reverse.reverse(sentence, "") ;
		return result;
	}
	
	@RequestMapping("/Token")
	public String getToken()
	{				
		return "https://join.readify.net/Status/1c3d1467-9a0f-49c2-bfc6-e30e99e827ef";
	}
	
	@RequestMapping("/TriangleType")
	public String TriangleType(@RequestParam(value="a" , defaultValue = "0")int a,@RequestParam(value="b" , defaultValue = "0")int b ,@RequestParam(value="c" , defaultValue = "0")int c)
	{  
		String result = "Error";
		
	    if (a <= 0 || b <= 0 || c <= 0) return "Error"; // added test
	    if (a == b && b == c) return "EQUILATERAL";
	    if (a >= b+c || c >= b+a || b >= a+c) return "Error";
	    if (b==c || a==b || c==a) return "ISOSCELES";
	    
	    return result;
	}
}
