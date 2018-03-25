import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTestCase {

	MyParking myParking;
	
	@Before
	public void init(){
		myParking = new MyParking();
	}
	@After
	public void cleanUp(){
		myParking=null;
	}
	
	@Test
	public void testGetDirection() {
		
		String command ="5,5:RFLFRFLF";
		assertTrue("returned location is not equal expected 7,7", myParking.getDirection(command).equals("7,7"));
		
		command ="6,6:FFLFFLFFLFF";
		assertTrue("returned location is not equal expected 6,6", myParking.getDirection(command).equals("6,6"));
		
		command ="5,5:FLFLFFRFFF";
		assertTrue("returned location is not equal expected 4,1", myParking.getDirection(command).equals("4,1"));
	}
	
	@Test
	public void testGetRightTurnHeading() {
		
		String heading ="north";
		assertTrue("Expected heading  east is not returned", myParking.getRightTurnHeading(heading).equals("east"));
		
		heading ="east";
		assertTrue("Expected heading  south is not returned", myParking.getRightTurnHeading(heading).equals("south"));
		
		heading ="south";
		assertTrue("Expected heading west is not returned", myParking.getRightTurnHeading(heading).equals("west"));
		
		heading ="west";
		assertTrue("Expected heading north is not returned", myParking.getRightTurnHeading(heading).equals("north"));
		
	}
	
	@Test
	public void testGetLeftTurnHeading() {
		
		String heading ="north";
		assertTrue("Expected heading  west is not returned", myParking.getLeftTurnHeading(heading).equals("west"));
		
		heading ="west";
		assertTrue("Expected heading  south is not returned", myParking.getLeftTurnHeading(heading).equals("south"));
		
		heading ="south";
		assertTrue("Expected heading  east is not returned", myParking.getLeftTurnHeading(heading).equals("east"));
		
		heading ="east";
		assertTrue("Expected heading  north is not returned", myParking.getLeftTurnHeading(heading).equals("north"));
		
		
	}
	
	@Test
	public void testMoveStep() {
		
		String heading ="north";
		Integer[] xy={5,5};
		myParking.moveStep(xy, heading);
		assertTrue("Expected  position (6,5) is not returned", xy[1]==6);
		
		heading ="east";
		xy=new Integer[] {5,5};
		myParking.moveStep(xy, heading);
		assertTrue("Expected  position (5,6) is not returned", xy[0]==6);
		
		heading ="south";
		xy=new Integer[] {5,5};
		myParking.moveStep(xy, heading);
		assertTrue("Expected  position (4,5) is not returned", xy[1]==4);
		
		heading ="west";
		xy=new Integer[] {5,5};
		myParking.moveStep(xy, heading);
		assertTrue("Expected  position (5,4) is not returned", xy[0]==4);
		
		
		
	}

}
