import java.util.ArrayList;

public class ResidentialProperty1
{
	private boolean forSale;
	private double price;
	private double[] rent;
	private ArrayList<Person>[] families;
	private int squareFeet;
	private Room[] rooms;
	private String name;
	private int maxPetsAllowed;
	private ArrayList<Pet>[] pets;
	private int numPets;

	//Constructors
	//Zero arg
	public ResidentialProperty1()
	{
		while(price > 1000 && price < 1000000) //set a price between a thousand and a million
		{
			price = Math.random() * 1000000;
		}
		rent = new double[4];
		forSale = true;
		squareFeet = 10000;
		families = new ArrayList[4];
		rooms = new Room[4];
		name = "";
		maxPetsAllowed = 0;
		pets = new ArrayList[4];
		numPets = 0;
	}
	//Multiarg
	public ResidentialProperty1(double price, String name, int maxPetsAllowed, int roomNum)
	{
		this.price = price;
		this.name = name;
		this.maxPetsAllowed = maxPetsAllowed;
		forSale = true;
		if(roomNum > 0) //check that the size given for the array is feasible
		{
			rent = new double[roomNum];
			families = new ArrayList[roomNum];
			rooms = new Room[roomNum];
			pets = new ArrayList[roomNum];
		}
		else
		{
			throw new IllegalArgumentException("You must have at least one room.");
		}
		squareFeet = 0; //square feet updates with rooms additions
		for(int i = 0; i < rent.length; i++) //initializes all arrays and arraylists
		{
			rent[i] = ResidentialDriver.randDouble(10000);
			pets[i] = new ArrayList<Pet>();
			families[i] = new ArrayList<Person>();
		}
		numPets = 0; //initiales numPets because there are no pets yet
	}

	//getters
	//returns if the property is for sale or not
	public boolean forSale()
	{
		return forSale;
	}
	//returns a room based of of its index
	public Room getRoom(int index)
	{
		if(index < rooms.length && index >= 0)
		{
			return rooms[index];
		}
		return null;
	}
	//returns a room based off of its name
	public Room getRoom(String name)
	{
		for(Room e : rooms)
		{
			if(e.getName().equals(name))
			{
				return e;
			}
		}
		return null;
	}
	//returns number of rooms
	public int numOfRooms()
	{
		return rooms.length;
	}

	//setters
	public void putForSale()
	{
		forSale = true;
	}
	public void takeOffMarket()
	{
		forSale = false;
	}
	//adds new pet at specific index; each index represents a room/family
	public void addPet(Pet pet, int familyIndex)
	{
		if(numPets < maxPetsAllowed && familyIndex < pets.length && familyIndex >= 0)
		{
			pets[familyIndex].add(pet);
			numPets++;
		}
		else
		{
			System.out.println("You are exceeding the maximum pet capacity");
		}
	}
	//sets entire family at specific room index; overwrites any previous families
	public void addFamily(ArrayList<Person> family, int index)
	{
		if(index < families.length && index >= 0)
		{
			families[index] = family;
		}
		else
		{
			System.out.println("That index was not compatible");
		}
	}
	//adds single person to an existing arraylist at specified index
	public void addFamilyMember(Person person, int familyIndex)
	{
		if(familyIndex < families.length && familyIndex >= 0)
		{
			families[familyIndex].add(person);
		}
		else
		{
			System.out.println("That index was not compatible");
		}
	}
	//replaces room at specific index
	public void addRoom(Room roomm, int roomIndex)
	{
		if(roomIndex < rooms.length && roomIndex >= 0)
		{
			rooms[roomIndex] = roomm;
		}
		else
		{
			System.out.println("That index was not compatible");
		}
		updateSquareFeet();
	}

	//returns boolean area of index of families that can or cannot pay rent
	public boolean[] canPayRent()
	{
		boolean[] canPayRent = new boolean[families.length];
		int famIncome = 0;
		for(int i = 0; i < families.length; i++)
		{
			for(Person p : families[i])
			{
				if(p == null) continue;
				famIncome += p.getIncome();
			}
			if(famIncome > rent[i])
			{
				canPayRent[i] = true;
			}
			else
			{
				canPayRent[i] = false;
			}
		}
		return canPayRent;
	}
	//returns index of empty room; returns -1 if all rooms are full
	public int indexOfEmptyRoom()
	{
		int index = 0;
		do
		{
			for(Person e : families[index])
			{
				if(e != null)
					continue;
				else
					return index;
			}
			index++;
		}
		while(index < families.length);
		return -1;
	}
	//removes all mean pets and lists the names of removed pets
	public void evictMeanPets()
	{
		String str = "The pets being evicted are:\n";
		for(ArrayList<Pet> e : pets)
		{
			if(e == null) continue;
			for(int i = 0; i < e.size(); i++)
			{
				if(!e.get(i).isFriendly())
				{
					str += e.get(i).getName() + "\n";
					e.remove(i);
					i--;
				}
			}
		}
		System.out.println(str);
	}
	//calclates square feet of entire residential property based off of rooms
	public int updateSquareFeet()
	{
		int totalSquareFeet = 0;
		for(Room e : rooms)
		{
			if(e == null)
				continue;
			else if(e != null)
				totalSquareFeet += e.getSquareFeet();
		}
		return totalSquareFeet;
	}

	public String toString()
	{
		String str = "Building " + name + "\nSquare feet: " + squareFeet + "\n";
		//Iterate through each room and print by room
		for(int roomNum = 0; roomNum < rooms.length; roomNum++) //iterates and prints each room seperately
		{
			str += "Room " + roomNum + ": " + rooms[roomNum];
			str += "\tFamily members:\n"; //prints people
			for(Person p : families[roomNum])
			{
				str += "\t" + p + "\n";
			}
			str += "\tPets:\n"; //prints pets
			for(Pet p : pets[roomNum])
			{
				str += "\t" + p + "\n";
			}
			str += "\n";
		}
		return str;
	}
}