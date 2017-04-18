package mills.war;

import org.junit.Test;

import static org.junit.Assert.*;

public class FaceTest {

	@Test
	public void testGetValue()
	{
		System.out.println("getValue()");
		Face face = Face.EIGHT;
		int expected = 4;
		int result = face.getValue();
		assertNotEquals(expected, result);
		
		Face face2 = Face.ACE;
		expected = 14;
		result = face2.getValue();
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetFace()
	{
		System.out.println("getFace()");
		Face expected = Face.ACE;
		Face result = Face.getFace(14);	//14=ACE
		assertEquals(expected, result);
		
		expected = Face.TWO;		//Should NOT be equal to this
		result = Face.getFace(0);	//0=NULL
		assertNotEquals(expected, result);
	}
	
}
