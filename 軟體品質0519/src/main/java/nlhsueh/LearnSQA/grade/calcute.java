package nlhsueh.LearnSQA.grade;

import java.util.Scanner;
import static org.mockito.Mockito.*;
public class calcute{
	
	dataDB db;
	//ListDB db;
	//ListCollector listCollector;
	

		public calcute(dataDB db) {
			this.db = db;
		}

		public void go() {
			// the process of the program
			int count=0;
			Scanner sc = new Scanner(System.in);
			System.out.println("Input class id: ");
			int classID = sc.nextInt();
			classID = 03;
			dataDB[] Dzthree = new dataDB[120];
			for(int i=0;i<120;i++)
			{
				Dzthree[i] = new dataDB();
				if(Dzthree[i].getmoney())
				{
					count++;
				}
			}
			double x=(count/120)*100;//繳系費率
			

			System.out.println("Grade book of class " + classID);
			
			System.out.println("繳系費率 " + classID + x + "%");
		}
}
	class dataDB{
		String sclass;
		String sid;
		String sname;
		boolean money;
		boolean cloth;
		public void data(String sclass , String sid, String sname, boolean smoney, boolean scloth)
		{
			this.sclass = sclass;
			this.sid=sid;
			this.sname = sname;
			this.money = smoney;
			this.cloth = scloth;
		}
		public void data()
		{
			this.sclass = "資電一甲";
			this.sid = "D0555555";
			this.sname = "林測試";
			this.money = true;
			this.cloth = true;
		}
		public boolean getmoney()
		{
			return money;
		}
		/*public dataDB getGrade(int classID) {
			return null;
		}*/
	}
	
	/*interface ListCollector {
		int getlistcount(int classID);

		void setDB(dataDB db);
	}*/
	
	/*class LCollector implements ListCollector {
		dataDB db;

		public int getlistcount(int classID) {
			int count=0;
			dataDB g = db.getGrade(classID);
			assert (g != null);
			return count;
			
		}

		public void setDB(dataDB db) {
			this.db = db;
		}
	}*/
	


