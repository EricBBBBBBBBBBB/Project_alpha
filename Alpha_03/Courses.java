/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Courses.java: 
********************************************/

class Courses{

	//data members
	public int courseID;
	public String courseName;
	
	private int duration;
	private String place;
	private int courseTrainerID;
	private int price;	
	// add Date & Time later
	private String description;
	
	public static int totalNumOfCourses = 0;
	public int totalNumOfTrainee = 0;
	public int maxNumOfTrainee;
	
	//constructors
	Courses() {
		courseID = this.totalNumOfTrainee;
		courseName = "TBC";
		duration = -1;
		place = "TBC";
		courseTrainerID = -1;
		price = -1;
		description = "TBC";
		totalNumOfTrainee = -1;
		maxNumOfTrainee = -1;
		totalNumOfCourses++;
	}

	Courses(String courseName) {
		this();
		this.courseName = courseName;
	}

	
	
	//methods
	public void getCourseInfo() {
        System.out.println("CourseID: \t\t" + courseID);
        System.out.println("CourseName: \t\t" + courseName);
        System.out.println("Duration: \t\t" + duration);
        System.out.println("Place: \t\t\t" + place);
        System.out.println("CourseTrainerID: \t" + courseTrainerID);
        System.out.println("price: \t\t\t" + price);
        System.out.println("Description: \t\t" + description);
        System.out.println("Number of Trainee: \t" + totalNumOfTrainee + "/" + maxNumOfTrainee);
    }
}
