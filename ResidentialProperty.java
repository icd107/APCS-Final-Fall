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
        while(price > 1000 && price < 1000000)
        {
            price = Math.random() * 1000000;
        }
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
        if(maxResidentsAllowed > 0)
        {
            residents = new Person[maxResidentsAllowed];
        }
        else
        {
            ThrowNewIllegalException("At least one resident must be allowed.");
        }
        squareFeet = 0;
        rooms = new ArrayList<Room>();
        pets = new ArrayList<Pet>();
    }

    boolean forSale()
    {
        return forSale;   
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
        return room.get(index);
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
    boolean isOccupied()
    {
        int i = 0;
        do
        {
            if(residents[i] = null)
            {
                return true;
            }
            else if(pets.size() > 0)
            {
                return true;
            }
            else
            {
                i++
            }
        } while(residents.length > 0 || pets.size() > 0)
    }
    void putForSale()
    {
        forSale = true;   
    }
    void takeOffMarket()
    {
        forSale = false;   
    }
    void addPets(Pet pet)
    {
        pets.add(pet);   
    }
    void evictMeanPets()
    {
        String str = "The pets being evicted are:\n";
        for(int i = 0; i < pets.size(); i++)
        {
            if(!pets.get(i).isFriendly())
            {
                str += pets.get(i).getName() + "\n";
                pets.remove(i);
                i--;
            }
        }
    }

    public String toString()
    {
        return getRooms() + getPets() + getResidents();
    }
}
