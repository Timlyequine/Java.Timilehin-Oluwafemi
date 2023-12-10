import java.util.Scanner;

public class GpaCalculator
{
	// My static variable declarations
	private static String[] CourseNames;
	private static String[] CourseCodes;
	private static int[] CourseUnits;
	private static double[] CourseScores;

	public static void main(String[] args)
	{
		int numbCourses;
		double gpa;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of courses: ");
		numbCourses = scanner.nextInt();

		//intializing arrays on the basis of the number of courses
		CourseNames = new String[numbCourses];
		CourseCodes = new String[numbCourses];
		CourseUnits = new int[numbCourses];
		CourseScores = new double[numbCourses];

		//inputting my course details
		for (int i = 0; i < numbCourses; i++)
		{
			inputCourseDetails(i + 1, scanner);
		}
		// This will calculate my gpa
		gpa = calculateGpa();

		//This will display my results
		displayResults(gpa);
	}

	private static void inputCourseDetails(int CourseNumber, Scanner scanner)
	{
		System.out.println("\nEnter details for Course " + CourseNumber + ":");
        	System.out.print("Course Name: ");
        	CourseNames[CourseNumber - 1] = scanner.next();

        	System.out.print("Course Code: ");
        	CourseCodes[CourseNumber - 1] = scanner.next();

        	System.out.print("Course Unit: ");
        	CourseUnits[CourseNumber - 1] = scanner.nextInt();

        	System.out.print("Course Score: ");
        	CourseScores[CourseNumber - 1] = scanner.nextDouble();	
	}

	private static double calculateGpa()
	{
		double totalQualityPoints = 0;
		int totalUnits = 0;
		
		for (int i = 0; i < CourseNames.length; i++)
		{
			totalQualityPoints += calculateQualityPoints(CourseScores[i]) * CourseUnits[i];
			totalUnits += CourseUnits[i];
		}

		if (totalUnits == 0)
		{
			//This will avoid division by zero
			return 0;
		}
		return totalQualityPoints / totalUnits;
    	}

	private static double calculateQualityPoints(double score)
	{
		//grading system here according to the requirement specified
		if (score >= 70) return 5.0;
		else if (score >= 60) return 4.0;
		else if (score >= 50) return 3.0;
		else if (score >= 45) return 2.0;
		else if (score >= 40) return 1.0;
		else return 0.0;
	}
	private static char calculateGrade(double qualityPoints)
	{
		// Implementation of grading system quality points
		if (qualityPoints >= 5.0) return 'A';
		else if (qualityPoints >= 4.0) return 'B';
		else if (qualityPoints >= 3.0) return 'C';
		else if (qualityPoints >= 2.0) return 'D';
		else if (qualityPoints >= 1.0) return 'E';
		else return 'F';
	}
	private static int calculateGradeUnit(char grade)
	{
		// Implementation of the custom grade unit as per specified
		switch (grade)
		{
			case 'A':
				return 5;
			case 'B':
				return 4;
			case 'C':
				return 3;
			case 'D':
				return 2;
			default:
				return 0;
		}
	}


 	private static void displayResults(double gpa)
	{
		System.out.println("| - - - - - - | - - - - - - | - - - - - - | - - - - - - - | - - - - - - - | - - - - - - - - - |");
		// Display results in tabular format
		System.out.println("\nResults:");
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Course Name", "Course Code", "COURSE UNIT","COURSE SCORE", "GRADE", "GRADE-UNIT");
		for (int i = 0; i < CourseNames.length; i++)
		{
			double qualityPoints = calculateQualityPoints(CourseScores[i]);
			char grade = calculateGrade(qualityPoints);
			int gradeUnit = calculateGradeUnit(grade);
			System.out.printf("%-15s%-15s%-15d%-15.2f%-15s%-15d\n",
						CourseNames[i], CourseCodes[i], CourseUnits[i], CourseScores[i], grade, gradeUnit);
		}
		System.out.println("\nYour GPA is: " + String.format("%.2f", gpa));

		System.out.println("| - - - - - - | - - - - - - | - - - - - - | - - - - - - - | - - - - - - - | - - - - - - - - - |");
	}
}
