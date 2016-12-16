public class Pet
{
    String name;
    boolean isFriendly;
    
    Pet()
    {
        name = "";
        isFriendly = false;
    }
    Pet(String name, boolean isFriendly)
    {
        this.name = name;
        this.isFriendly = isFriendly;
    }
    
    //getters
    public String getName()
    {
        return name;
    }
    public boolean isFriendly()
    {
        return isFriendly;
    }

    //setters
    public void trainPet()
    {
        isFriendly = true;
    }
    
    public String toString()
    {
        return name + "\n\t\tIs friendly: " + isFriendly;
    }
}
