package nlhsueh.LearnSQA.grade;

import static org.mockito.Mockito.*;


import java.util.Scanner;

public class GradeDisplayer {
	GradeDB db;
	GradeCollector gradeCollector;
	GradeSorter gradeSorter;

	public GradeDisplayer(GradeDB db, GradeCollector collector, GradeSorter sorter) {
		this.db = db;
		this.gradeCollector = collector;
		this.gradeSorter = sorter;
	}

	public void go() {
		// the process of the program
		Scanner sc = new Scanner(System.in);
		System.out.println("Input class id: ");
		int classID = sc.nextInt();
		classID = 01;
		int[] g = gradeCollector.getGradeAverage(classID);
		assert (g != null) : "g is null";
		int[] g2 = gradeSorter.sort(g);
		assert (g2 != null) : "g2 is null";

		System.out.println("Grade book of class " + classID);
		int std = 1;
		for (int x : g2) {
			System.out.println("Student" + std + ", average:" + x);
			std++;
		}
	}
}

// return the grade average for each student in the class classID
// the return array g[i] is the average grade of student i
interface GradeCollector {
	int[] getGradeAverage(int classID);

	void setDB(GradeDB db);
}

// the return array g[i][j] is the grade of student i in the subject j
interface GradeDB {
	int[][] getGrade(int classID);
}

// will return a new grade array, sorted in incremental order
interface GradeSorter {
	int[] sort(int[] grade);
}


class GCollector implements GradeCollector {
	GradeDB db;

	public int[] getGradeAverage(int classID) {
		int[][] g = db.getGrade(classID);
		assert (g != null);
		int[] avg = new int[g.length];

		for (int x : avg)
			x = 0;

		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				avg[i] += g[i][j];
			}
			avg[i] = avg[i] / avg.length;
		}
		return avg;
	}

	public void setDB(GradeDB db) {
		this.db = db;
	}
}

class GSorter implements GradeSorter
{
	public int[] sort(int[] grade)
	{
		for(int i=0;i<grade.length-1;i++)
		{
			for(int j=0;j<grade.length-1-i;j++)
			{
				if(grade[j]>grade[j+1])
				{
				int temp;
				
				temp = grade[j];
				grade[j] = grade[j+1];
				grade[j+1] = temp;
				}
			}
		}
		return grade;
	}
}
