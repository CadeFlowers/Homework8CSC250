import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		BibleBookCollection theNewTestament = new BibleBookCollection("Data.dat");
		BibleBook answer = theNewTestament.getFirstBookGivenSearchTerm("Paul");
		answer.display();
		int[] answer2 = theNewTestament.sortOnChapterCount();
		System.out.println(Arrays.toString(answer2));
		String[] answer3 = theNewTestament.sortOnName();
		System.out.println(Arrays.toString(answer3));
	} 
}
