import java.util.ArrayList;
import java.util.Scanner;

public class ResidentialDriver
{
	public static void main(String[] args)
	{
		ResidentialProperty1 prop1 = new ResidentialProperty1(10000, "Mildew Motel", 4, 4);
		//Filling the property with random families, rooms, and pets
		for(int i = 0; i < prop1.numOfRooms(); i++)
		{
			ArrayList<Person> p = new ArrayList<Person>();
			p.add(new Person(randPersonName(), randInt(50), randDouble(1000)));
			p.add(new Person(randPersonName(), randInt(50), randDouble(1000)));
			p.add(new Person(randPersonName(), randInt(50), randDouble(1000)));

			prop1.addRoom(new Room(randRoomName(), 100), i);
			prop1.addFamily(p, i);
			prop1.addPet(new Pet(randPetName(), randBool()), i);
		}

		System.out.println(prop1);
		System.out.println(prop1.getRoom("Pigsty Palace"));
		prop1.takeOffMarket();
		boolean[] canPay = prop1.canPayRent();
		for(boolean b : canPay)
		{
			System.out.print(b + " ");
		}
		System.out.println(prop1.indexOfEmptyRoom());
		prop1.evictMeanPets();
		System.out.println(prop1);

		Scanner in = new Scanner(System.in);
		System.out.println("What is a family member name?");
		String name = in.nextLine();
		prop1.addFamilyMember(new Person(name, randInt(25), randDouble(1000)), 0);
		System.out.println(prop1;)
	}


	//random methods 
	public static boolean randBool()
	{
		int i = randInt(2);
		switch(i)
		{
			case 1: return true;
			case 2: return false;
			default: return true;
		}
	}
	public static int randInt(int max)
	{
		return (int)(Math.random() * max + 1);
	}
	public static double randDouble(int max)
	{
		return (Math.random() * max + 1);
	}
	public static String randPersonName()
	{
		int i = randInt(15);
		String name = "";
		switch(i)
		{
			case  1: name = "Austin Soohoo";	break;
			case  2: name = "Tiffany Tam";		break;
			case  3: name = "Adam Noworolski";	break;
			case  4: name = "Isabel Dominik";	break;
			case  5: name = "Ariana Chin";		break;
			case  6: name = "Rory Douglass";	break;
			case  7: name = "Serena Haddad";	break;
			case  8: name = "Justin Lee";		break;
			case  9: name = "Max Kober";		break;
			case 10: name = "David Tarazi";		break;
			case 11: name = "Daniel Yu";		break;
			case 12: name = "Toonces Dominik";	break;
			case 13: name =	"Ms. Wade";			break;
			case 14: name = "Anais Macko";		break;
			case 15: name = "Stella Yang";		break;
		}
		return name;
	}
	public static String randPetName()
	{
		int i = randInt(16);
		String name = "";
		switch(i)
		{
			case  1: name = "Larry";	break;
			case  2: name = "Blacksad";	break;
			case  3: name = "Sunset";	break;
			case  4: name = "Luna";		break;
			case  5: name = "Gerard";	break;
			case  6: name = "Sura";		break;
			case  7: name = "Ximena";	break;
			case  8: name = "Mittens";	break;
			case  9: name = "Sakura";	break;
			case 10: name = "Clement";	break;
			case 11: name = "Queso";	break;
			case 12: name = "Gene";		break;
			case 13: name =	"Barbas";	break;
			case 14: name = "Albert";	break;
			case 15: name = "Potato";	break;
			case 16: name = "Clye";		break;
		}
		return name;
	}
	public static String randRoomName()
	{
		int i = randInt(5);
		String name = "";
		switch(i)
		{
			case 1: name = "Dilapidated Digs"; 	break;
			case 2: name = "Pigsty Palace";		break;
			case 3: name = "Suburban Shack";	break;
			case 4: name = "Buckingham Palace";	break;
			case 5: name = "Heinous House";		break;
		}
		return name;
	}
}