//Kanemoto
//4.27.2021
//a name picker based upon the number of meetings students attended
//meaning that if a student attended five times then they get their 
//"name in the hat" 5 times. We are pulling names from the hat for the 
//Valle prizes

package vallePrizePicker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ValleNamePicker {

	//read the data into a data structure
	//using an arraylist
	public static ArrayList<Student> student = new ArrayList<Student>();

	//public static void main(String[] args) {

	public static void start() {

		long start = System.currentTimeMillis();

		//copy paste file reading code
		Scanner inputStream = null;

		try  {
			//instantiates the Scanner object
			//connecting this object with the text input file
			inputStream = new Scanner(new File("valleAttendance.csv"));
		}  catch(FileNotFoundException e)  {
			//this code runs if the above code fails, such as not finding the file
			System.out.println("Error opening the file ");
			System.exit(0);
		}

		//need to read in the header and do nothing with it so we can skip over it
		inputStream.nextLine();

		//if we make it to this in the code, that means that it opened the file
		//now you can read from the file
		//checking to see if there is another line to read in from the text file
		while (inputStream.hasNextLine())  {
			//reading in one line - stops at the end of line character \n
			//String line = inputStream.nextLine();
			//System.out.println(line);

			//input the data into the arraylist
			String[] fields = inputStream.nextLine().split(",");
			student.add(new Student(fields[0], fields[1], Integer.parseInt(fields[2])));
			//enter the student into the arraylist the numner of attendance times
			for(int i = 0; i < Integer.parseInt(fields[2]); i++) {
				student.add(new Student(fields[0], fields[1], Integer.parseInt(fields[2])));
			}
		}

		//close that file input stream
		inputStream.close();

		for(int i = 0; i < student.size(); i++) {
			System.out.println("index " + i + " " + student.get(i));
		}

		long finish = System.currentTimeMillis();

		//System.out.println(pickName());

		System.out.println(finish - start);

	}

	public static int getIndex() {
		//int index = (int)(Math.random()*student.size());
		int index = ThreadLocalRandom.current().nextInt(0, student.size());

		System.out.println("index is " + index);
		return index;
	}

	public static Student pickName(int index) {
		return student.get(index);
		//return student.get((int)Math.random()*student.size());
	}

}
