import java.util.ArrayList<>;

public class ResidentialProperty
{
    private double price;
    private double rent;
    private boolean forSale;
    private Person[] residents;
    private int squareFeet;
    private ArrayList<Room> rooms;
    private String name;
    private int maxPetsAllowed;
    private ArrayList<Pet> pets;
    
    ResidentialProperty()
    {
        price = 100000;
        rent = 1000;
        forSale = true;
        squareFeet = 1000;
        residents = new Person[4];
        rooms = new ArrayList<Room>();
        name = "";
        maxPetsAllowed = 0;
        pets = new ArrayList<Pet>();
    }
    ResidentialProperty(double price, double rent, String name, int maxPetsAllowed, int maxResidentsAllowed)
    {
        this.price = price;
        this.rent = rent;
        this.name = name;
        this.maxPetsAllowed = maxPetsAllowed;
        forSale = true;
        residents = new Person[maxResidentsAllowed];
        squareFeet = 0;
        rooms = new ArrayList<Room>();
        pets = new ArrayList<Pet>();
    }
    
    double getPrice()
    {
        return price;   
    }
    boolean forSale()
    {
        return forSale;   
    }
    double getRent()
    {
        return rent;   
    }
    int getSquareFeet()
    {
        return squareFeet;   
    }
    String getName()
    {
        return name;   
    }
    String getResidents()
    {
        String str = "";
        for(Person e : residents)
        {
            str += e;
            str += "\n";
        }
        return str;
    }
    String getPets()
    {
        String str = "";
        for(Pet e : pets)
        {
            str += e;
            str += "\n";
        }
        return str;
    }
    String getRooms()
    {
        String str = ""
        for(Room e : rooms)
        {
            str += e;
            str += "\n"
        }
        return str;
    }
    Room getRoom(int index)
    {
        return rooms.get(index);
    }
    Room getRoom(String name)
    {
        for(Room e : rooms)
        {
            if(e.getName().equals(name))
            {
                return e;   
            }
        }
    }
    boolean canPayRent()
    {
        double totalIncome = 0;
        for(Person e : residents)
        {
            totalIncome += e.getIncome();
            if(totalIncome >= rent)
            {
                return true;   
            }
        }
        return false;
    }
    int getNumberOfResidents()
    {
        return residents.length;   
    }
    int getNumberOfPets()
    {
        return pets.size();   
    }
    void putForSale()
    {
        forSale = true;   
    }
    void takeOffMarket()
    {
        forSale = false;   
    }
    void setPetsAllowed(int pets)
    {
        maxPetsAllowed = pets;   
    }
    void addPets(Pet pet)
    {
        pets.add(pet);   
    }
    //not finished
    void evictMeanPets()
    {
        String str = "";
        for(int i = 0; i < pets.size(); i++)
        {
            if(!pets.get(i).isFriendly())
            {
                str += pets.get(i).getName() + " ";
                pets.remove(i);
                i--;
            }
        }
    }
}
