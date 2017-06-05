package nlhsueh.LearnSQA.grade;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/*
 * Only the GradeDisplayer class is developed, others are not. 
 * So we create the mock to test the GradeDisplayer is okay. 
 */
public class GadeDisplayerTest1 {
	GradeDB db;
	GradeCollector gradeCollector;
	GradeSorter gradeSorter;

	@Before
	public void setup() {
		int[][] mockClass01DB = { { 90, 70, 80 }, { 100, 60, 70 }, { 50, 20, 30 } };
		int[] mockGrade = { 80, 50, 60 };
		int[] sortedGrade = { 50, 60, 80 };

		db = mock(GradeDB.class);
		gradeCollector = mock(GradeCollector.class);
		gradeSorter = mock(GradeSorter.class);

		when(db.getGrade(1)).thenReturn(mockClass01DB);
		when(gradeCollector.getGradeAverage(01)).thenReturn(mockGrade);
		when(gradeSorter.sort(mockGrade)).thenReturn(sortedGrade);
	}

	@Test
	public void test() {
		GradeDisplayer display = new GradeDisplayer(db, gradeCollector, gradeSorter);
		display.go();
	}

}
