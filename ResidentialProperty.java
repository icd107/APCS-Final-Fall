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
}
