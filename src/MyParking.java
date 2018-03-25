
import java.util.regex.Pattern;

public class MyParking {

	public static void main(String[] args) {
		//
		MyParking test = new MyParking();
		
		String command ="5,5:RFLFRFLF";
		System.out.println("The input is :" + command + "\n" +  "The position is " + test.getDirection(command));
		
		command ="6,6:FFLFFLFFLFF";
		System.out.println("The input is :" + command + "\n" +  "The position is " + test.getDirection(command));
		
		command ="5,5:FLFLFFRFFF";
		System.out.println("The input is :" + command + "\n" +  "The position is " + test.getDirection(command));
		
	}
	
	
	/**
	 * 
	 * @param instruction
	 * @return
	 */
	public String getDirection(String instruction){
		//
		String[] tokens = instruction.split(Pattern.quote(":"));
		String[] location = tokens[0].split(Pattern.quote(","));
		// get initial location
		Integer[] xy ={Integer.valueOf(location[0]), Integer.valueOf(location[1])};
		String heading = "north";
		char[] commands=tokens[1].toCharArray();
		for(char command:commands){
			switch(command){
			case 'R':
				heading=getRightTurnHeading(heading);
				break;
			case 'L':
				heading=getLeftTurnHeading(heading);
				break;
			case 'F':
				moveStep(xy, heading);	
				break;
			default:
				break;
			}
		}
		return xy[1] + "," + xy[0];
	}
	
	/**
	 * 
	 * @param xy
	 * @param heading
	 */
	protected void moveStep(Integer[] xy, String heading) {
		//
		switch(heading){
		case "north":
			xy[1]++;
			break;
		case "east":
			xy[0]++;
			break;
		case "south":
			xy[1]--;
			break;
		case "west":
			xy[0]--;
			break;
		default:
				break;
	}
		
	}

	/**
	 * 
	 * @param heading
	 * @return
	 */
	protected String getRightTurnHeading(String heading){
		switch(heading){
		case "north":
			return "east";
		case "east":
			return "south";
		case "south":
			return "west";
		case "west":
			return "north";
		default:
			return heading;
				
		}
	}
	
	/**
	 * 
	 * @param heading
	 * @return
	 */
	protected String getLeftTurnHeading(String heading){
		switch(heading){
		case "north":
			return "west";
		case "west":
			return "south";
		case "south":
			return "east";
		case "east":
			return "north";
		default:
			return heading;
				
		}
	}

}
