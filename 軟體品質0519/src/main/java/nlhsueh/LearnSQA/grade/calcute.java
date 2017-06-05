package nlhsueh.LearnSQA.grade;

import java.util.Scanner;
import static org.mockito.Mockito.*;
public class calcute{
	
	dataDB datas;
	ListDB db;
	

		public calcute(ListDB db) {
			this.db = db;
		}

		public void go() {
			// the process of the program
			Scanner sc = new Scanner(System.in);
			System.out.println("Input class id: ");
			int classID = sc.nextInt();
			classID = 03;
			dataDB[] Dzthree = new dataDB[120];
			for(int i=0;i<120;i++)
			{
				Dzthree[i] = new dataDB();
			}
			double x=100.0;//繳系費率
			

			System.out.println("Grade book of class " + classID);
			
			System.out.println("繳系費率 " + classID + x + "%");
		}
}
	
	interface data
	{
		void data(String sclass , String sid, String sname, boolean money, boolean cloth);
		void data();
	}
		
	class ListDB
	{
		dataDB[] db;
		//this.db = dataDB.data();
		public dataDB[] getDB()
		{
			return db;
		}
		public void setDB(dataDB datas) {
			db[0] = datas;
		}
	}
	
	class dataDB implements data{
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
	}
	


