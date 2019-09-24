package DecoratorPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//  Hello World
//  hello world

public class main {

	static String _FILEPATH="src/test.txt";
	
	public static void main( String[] args) {
		InputStream is;
		int c = 0;
		
		try {
			is = new BufferedInputStream(new FileInputStream(_FILEPATH));
			StringBuilder sb = new StringBuilder();
			while(is.available() > 0) {
				c = is.read();
				sb.append((char)c);
			}
			System.out.println(sb.toString());
			is.close();			
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
