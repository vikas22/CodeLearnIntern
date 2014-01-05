package codelearninternship;

import static org.junit.Assert.*;

import org.junit.Test;



public class ViewPart13Test {

	public	ViewPart13 test =new ViewPart13();
	public boolean b;
		@Test
		public void testtext() {
			
			
			b=test.check("ch@nnai");
			assertEquals(false,b);
		}
		
		@Test	
		public void testinvalid()
		{
			b=test.check("har");
			assertEquals(false,b);
		}
		
		@Test
		public void testempty()
		{
			b=test.check("  ");
			assertEquals(false, b);
		}
		
		@Test
		public void testnum()
		{
			b=test.check("123");
			assertEquals(false,b);
		}	
		
		@Test
		public void testvalid()
		{
			b=test.check("Banaras");
			assertEquals(false,b);
			
		}
		
		@Test
		public void testcmp()
		{
			b=test.cmp("bangalore","bangalore");
			assertEquals(false, b);
		}
		
		@Test
		public void testcmp1()
		{
			b=test.cmp("bangalore","chennai");
			assertEquals(true, b);
		}
}
