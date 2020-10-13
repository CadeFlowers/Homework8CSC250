import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class BibleBookCollection
{
	private ArrayList<BibleBook> theBooks;
	
	public BibleBookCollection() 
	{
		this.theBooks = new ArrayList<BibleBook>();
	}
	
	public BibleBookCollection(String filename)
	{
		this();
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/data.dat"));
			while(input.hasNext()) 
			{
				this.theBooks.add(new BibleBook(input.nextLine()));
			}
			input.close();
		}
		catch(Exception e) 
		{ 
			e.printStackTrace();
		}		
	}
	
	public int[] sortOnChapterCount() 
	{
		int[] intArray = {2,3,1};
		int start = 0;
		int swapPos, temp;
		while(start < intArray.length) 
		{
			swapPos = start;
			for(int i = start + 1; i < intArray.length; i++) 
			{
				if(intArray[i] < intArray[swapPos]) 
				{
					swapPos = i;
				}
			}
			temp = intArray[start];
			intArray[start] = intArray[swapPos];
			intArray[swapPos] = temp;
			start++;
		}
		return intArray;
	}
	
	public String[] sortOnName()
	{
		String[] strArray = {"woot", "lol", "hi"};
		return strArray;
	}
	
	public void addBibleBook(BibleBook b) 
	{
		this.theBooks.add(b);
	}
	
	public void addBibbleBook(String colonDelimitedData) 
	{
		this.theBooks.add(new BibleBook(colonDelimitedData));
	}
	
	public BibleBook getFirstBookGivenSearchTerm(String term) throws Exception
	{
		for(BibleBook aBook : this.theBooks) 
		{
			if(aBook.searchSummary(term)) 
			{
				return aBook;
			}
		}
		throw new Exception("Term not found exception");
	}
	
}
