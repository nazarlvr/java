import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Parser {

	public static void main(String[] args) {
		File fl = new File("D:\\sysprog\\ex1.txt");
		try {
			HashSet<String> sameCheck= new HashSet<String>();
			String Result = "";
			String szDelemiters = "\" ( ) , + - = < > ? ! @ # $ % ^ & * ~ ' . / \\";
			String[] a = szDelemiters.split(" ");
			Scanner sc = new Scanner(fl);
			while(sc.hasNext()) {
				String Str = sc.nextLine();
				for (String s : a) {
					Str = Str.replace(s.charAt(0), ' ');
				}
				String CurrentStr = Str.trim().replaceAll(" +", " ");
				String[] CurrA = CurrentStr.split(" ");
				for (int i = 0; i < CurrA.length; ++i) {
					if (CurrA[i].length() > 30) 
					{
						CurrA[i] = CurrA[i].substring(0, 30);
					}
				}
				for (String s1 : CurrA) {
					int q = 0;
					for (int j = 0; j < s1.length(); ++j) 
					{
						char s2 = s1.toUpperCase().charAt(j);
						if(s2 == 'A' || s2 == 'E' || s2 == 'O' || s2 == 'U' || s2 == 'Y' || s2 == 'I') {
							q++;
						}
					}
					if (q > (s1.length() - q) && !(sameCheck.contains(s1))) {
						Result += s1 + " ";
						sameCheck.add(s1);
					}
				}
			}
			System.out.println(Result.trim());
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
