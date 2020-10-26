package Addressbook;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;
public class Address {
	Scanner sc= new Scanner(System.in);
	public static String firstname=null,lastname=null,mobnumber=null,address="null",state="null" ,pincode="null";
	public static String Fname="^[?=[A-Z]]{1}[A-Za-z]{3,}";
	public static String Lname="^[A-Za-z]{3,}";
	public static String Mnumber="^[0-9]{10}";
	public static String pincode1="^[0-9]{6}";
	public static String address1="^[A-Za-z]{3,}";

			public static void Insert() throws IOException
			{Scanner sc= new Scanner(System.in);
				System.out.println("\nFirst name:");
			firstname=sc.next();
			Pattern pat1=Pattern.compile(Fname);
			Matcher match1=pat1.matcher(firstname);
			if(match1.matches())
				System.out.println();
			else
				System.out.printf("\nMinimum 3 Chracter,atleast 1 Uppercase\n" +firstname);
			System.out.println("\nLast name:");
			lastname=sc.next();
			Pattern pat2=Pattern.compile(Lname);
			Matcher match2=pat2.matcher(lastname);
			if(match2.matches())
				System.out.printf("\n" +lastname);
			else
				System.out.printf("\nMinimum 3 Chracter\n" +lastname);
			System.out.println("\nAddress:");
			address=sc.next();
			Pattern patt3=Pattern.compile(address1);
			Matcher matchh3=patt3.matcher(address);
			if(matchh3.matches())
				System.out.printf("\n");
			else
				System.out.printf("\nnot validated\n" +address);
			
			
			System.out.println("\nPincode:");
			pincode=sc.next();
			Pattern pat3=Pattern.compile(pincode1);
			Matcher match3=pat3.matcher(pincode);
			if(match3.matches())
				System.out.printf("\n");
			else
				System.out.printf("\nMinimum 6 character\n" +pincode);
			System.out.println("\nMobilenumber:");
			mobnumber=sc.next();
			Pattern pat4=Pattern.compile(Mnumber);
			Matcher match4=pat4.matcher(mobnumber);
			if(match4.matches())
				System.out.printf("\n");
			else
				System.out.printf("\nNot an valid number" +mobnumber);
	File f1=new File("C:/Users/Ramesh/Desktop/AdressBook.txt"+firstname+".txt");
	f1.createNewFile();
	FileWriter fw=new FileWriter(f1,true);
	BufferedWriter bw=new BufferedWriter(fw);
	
	bw.write("\nfirst name:" +firstname+ "\nlastname:" +lastname+ "\nAddress:"+address+"\npincode:"+pincode+"\nmobile no:"+mobnumber);
	bw.close();
			}
			public static void search() throws IOException {
				Scanner sc= new Scanner(System.in);
			System.out.println("enter the name you want to search. note:please provide the first name");
			String search=sc.next();
			File f2=new File("C:/Users/Ramesh/Desktop/AdressBook.txt"+search+".txt");
			boolean bool=f2.exists();
			if (bool == true) {
				FileReader fr=new FileReader(f2);
				BufferedReader br =new BufferedReader(fr);
				String s1;
				while((s1=br.readLine())!=null) {
					System.out.println(s1);
				}
				br.close();
			}
			
			else System.out.println("name you want to search do not exists");
				
			}
			public static void delete() {
				Scanner sc= new Scanner(System.in);
				System.out.println("enter the name you want to delete. note:Should be first name");
				String del=sc.next();
				File f4=new File("C:/Users/Ramesh/Desktop/AdressBook.txt"+del+".txt");
				boolean delete=f4.exists();
				if(delete==true) {
					f4.delete();
					System.out.println("the file is deleted sucessfully");
				}
				else System.out.println("name of the file with "+del+"is not found please provide perfect name");
			}
			public static void edit() throws IOException {
				Scanner sc= new Scanner(System.in);
				System.out.println("enter the name you want to edit");
				String edit=sc.next();
				File f3=new File("C:/Users/Ramesh/Desktop/AdressBook.txt"+edit+".txt");
				boolean e=f3.exists();
				if (e==true) {

					
						System.out.println("enter the first name");
						firstname=sc.next();
						Pattern e1=Pattern.compile(Fname);
						Matcher ma1=e1.matcher(firstname);
						if(ma1.matches()) {
							System.out.println("valid is "+firstname);
						     }
						else
							System.out.println("invalid is "+firstname);
						
					
						System.out.println("enter the last name");
						lastname=sc.next();
						Pattern e2=Pattern.compile(Lname);
						Matcher ma2=e2.matcher(lastname);
						if(ma2.matches()) {
							System.out.println();
						     }
						else
							System.out.println("invalid is "+lastname);
						
					
						System.out.println("enter the address name");
						address=sc.next();
						Pattern e22=Pattern.compile(address1);
						Matcher ma22=e22.matcher(address);
						if(ma22.matches())
							System.out.println("valis is "+address);
						     
						else
							System.out.println("invalid is "+address);
						
					
					 
						System.out.println("enter the  mobile");
						mobnumber=sc.next();
						Pattern e5=Pattern.compile(Mnumber);
						Matcher ma5=e5.matcher(mobnumber);
						if (ma5.matches()) {
							System.out.println("valid"+mobnumber);
							}
						else
							System.out.println("invalid"+mobnumber);
					
					
					 
						System.out.println("enter the  pincode");
						pincode=sc.next();
						Pattern e7=Pattern.compile(pincode1);
						Matcher ma7=e7.matcher(pincode);
						if (ma7.matches()) {
							System.out.println("valid"+pincode);
							}
						else
							System.out.println("invalid"+pincode);
					
					FileWriter fw1=new FileWriter("C:/Users/Ramesh/Desktop/AdressBook.txt"+firstname+".txt");
					BufferedWriter bw=new BufferedWriter(fw1);
					bw.write("first name is"+firstname+"\nlastname is "+lastname+"\naddress is"+address+"\nstate is "+state+"\npincode is"+pincode+"\nmobilr no is"+mobnumber);
					bw.close();	
				}
				else 
					System.out.println("name you want to edit is not available;please provide the first name of the user");
				
			}
			
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("**WELCOME TO ADDRESS BOOK**");
		Scanner sc= new Scanner(System.in);
		int choice;
		while (true)
		{
			System.out.println("\n enter the choice\n 1.add\n 2.search\n 3.delete\n 4.edit\n 5.exit\n");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:Insert();
						break;
				case 2:search();
				break;
				case 3:delete();
				break;
				case 4:edit();
				break;
				case 5:System.exit(0);
				default:System.out.println("Invalid option");
			}
}
	}
}

	