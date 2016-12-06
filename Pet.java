public class Pet
{
    String name;
    String type;
    String color;
    boolean isFriendly;
    
    Pet()
    {
        name = "";
        type = "";
        color = "";
        isFriendly = false;
    }
    Pet(String name, String type, String color, boolean isFriendly)
    {
        this.name = name;
        this.type = type;
        this.color = color;
        this.isFriendly = isFriendly;
    }
    
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getColor()
    {
        return color;
    }
    public boolean isFriendly()
    {
        return isFriendly;
    }
    public void trainPet()
    {
        isFriendly = true;
    }
    
    public String toString()
    {
        return name + "\n\tType: " + type + "\n\tColor: " + color + "\n\tIs friendly: " + isFriendly;
    }
}
