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
    Person(String name, int age, boolean isChild, double income)
    {
        this.name = name;
        this.age = age;
        this.isChild = isChild;
        this.income = income;
    }
    
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
        return isChild;
    }
    public double getIncome()
    {
        return income;
    }
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
        return name + ":\n\tAge: " + age + "\n\tIs a child: " + isChild + "\n\tIncome: " + income;   
    }
}
