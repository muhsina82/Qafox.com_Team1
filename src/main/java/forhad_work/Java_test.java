package forhad_work;

public class Java_test {

	public static void main(String[] args) {
		
		  String[]appleArray=new String[10];
			
			// Array Task 2 :
			//● Create an String array with 11 index (Variable Name should not be single 
			//Digit,it can be a name or anything but not a ,b, c ,d) and Put any value on 
			//Index number 1 (ex: a[0]), index number 3 , and Index number 6.//
			
			//Assign values to specific indices
			appleArray[0]="hello";
			appleArray[3]="world";
			appleArray[6]="Ela";
			
					 
			// Find out the length of the array and Print all the value with for each loop
			for (String value: appleArray) {
				System.out.println(value);
			}

}
	}