public class Person
{
    private String name;
    private int age;
    private boolean isChild;
    private double income;
    
    Person()
    {
        this.name = "";
        this.age = 0;
        this.isChild = false;
        this.income = 0.0;
    }
    Person(String name, int age, double income)
    {
        this.name = name;
        this.age = age;
        this.isChild = isChild();
        this.income = income;
    }
    
    //getters
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public boolean isChild()
    {
        if(age < 18)
            return true;
        return false;
    }
    public double getIncome()
    {
        return income;
    }
    public String firstName()
    {
        return name.substring(0, name.indexOf(" "));
    }

    //setters
    public void ageUp()
    {
        age++;
        if(age >= 18)
        {
            isChild = false;
        }
        else
        {
            isChild = true;
        }
    }
    public void setIncome(double income)
    {
        this.income = income;
    }
    public void promote()
    {
        income *= 1.2;
    }
    
    public String toString()
    {
        return name + ":\n\t\tFirst name: " + firstName() + "\n\t\tAge: " + age + "\n\t\tIs a child: " + isChild + "\n\t\tIncome: " + income;   
    }
}
