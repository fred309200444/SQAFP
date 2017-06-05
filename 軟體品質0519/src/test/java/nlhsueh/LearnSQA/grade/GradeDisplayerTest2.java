package nlhsueh.LearnSQA.grade;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
/*
 * GradeCollector is developed and integrated, we remove the mock
 * and replace by the real object
 */
public class GradeDisplayerTest2 {

	GradeDB db;
	GradeCollector gradeCollector;
	GradeSorter gradeSorter;

	@Before
	public void setup() {
		int[][] mockClass01DB = { { 90, 70, 80 }, { 20, 60, 70 }, { 100, 50, 30 } };
		int[] mockGrade = { 80, 50, 60 };
		int[] sortedGrade = { 50, 60, 80 };

		db = mock(GradeDB.class);		
		
//		gradeCollector = mock(GradeCollector.class);
		gradeCollector = new GCollector();
		gradeCollector.setDB(db);
		
		gradeSorter = mock(GradeSorter.class);

		when(db.getGrade(1)).thenReturn(mockClass01DB);
//		when(gradeCollector.getGradeAverage(01)).thenReturn(mockGrade);
		
		//make sure the computation is correct, or the gradeSorter stubbing
		//does not work
		int [] avg = gradeCollector.getGradeAverage(01);
		assert Arrays.equals(avg, mockGrade);

		when(gradeSorter.sort(mockGrade)).thenReturn(sortedGrade);
	}

	@Test
	public void test() {
		GradeDisplayer display = new GradeDisplayer(db, gradeCollector, gradeSorter);
		display.go();
	}

}