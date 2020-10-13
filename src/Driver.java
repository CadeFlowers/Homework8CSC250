import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<BibleBook> theBooks = new ArrayList<BibleBook>();
		Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/data.dat"));
		while(input.hasNext()) 
		{
			theBooks.add(new BibleBook(input.nextLine()));
		}
		input.close();
		
		Driver.searchSummaries(theBooks);
	} 
	static void searchSummaries(ArrayList<BibleBook> theBooks) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a serach term: ");
		String term = input.nextLine();
		for(int i = 0; i < theBooks.size(); i++) 
		{
			if(theBooks.get(i).searchSummary(term)) 
			{
				System.out.println(theBooks.get(i).getName());
				break;
			}
		}
	}
}
