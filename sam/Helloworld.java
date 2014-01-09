import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter ;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Helloworld {
	
	String[] city={"bangalore","chennai","delhi","mumbai","goa","cochin","hyderabad","ahmedabad"};
	public static void main(String[] args) {
	try {

			Helloworld h=new Helloworld();
			BufferedReader reader = new BufferedReader(new FileReader("c:\\sam\\test_in.txt"));
			String line = null;
			String[] places=new String[2];
			int i=0;
			while ((line = reader.readLine()) != null) {
			   
				places[i]=line;
				i++;
			}
			reader.close();
			
	PrintWriter writer = new PrintWriter("c:\\sam\\test_out.txt", "UTF-8");
	//writer.println("a");
	//writer.println("a1");
	//writer.close();
	writer.println(h.check(places[0]));
	
	writer.println(h.check(places[1]));
	writer.println(h.cmp(places[0],places[1]));
	writer.close();
				System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public boolean cmp(String from,String to)
	{
		if(from.toLowerCase().equals(to.toLowerCase())==true)
				{
			return false;
				}
		else
		{
			return true;
		}
	}
	
	public boolean check(String s)
	{
			boolean avail=false;
			
		if(s.trim().equals("")){return false;}
		
		

		for(int i=0;i<7;i++)
		{
		if(city[i].equals(s.toLowerCase().trim())==true)
		{
			avail=true;
			break;
		}
		}	
		if (s.toLowerCase().matches("[a-z]+$")==false) {
			   return false;
			}
	     
		if(avail==false){return false;}

		return true;
		
	}


}
