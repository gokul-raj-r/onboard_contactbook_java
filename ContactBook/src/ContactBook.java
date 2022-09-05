import java.util.*;
public class ContactBook {
    Scanner s = new Scanner(System.in);
    String Name,Phone,DoB,Place,Company;

    ContactBook(String ph)
    {
        System.out.println("Name: ");
        Name = s.next();
        Phone = ph;
        System.out.println("DoB: ");
        DoB = s.next();
        System.out.println("Place: ");
        Place = s.next();
        System.out.println("Company: ");
        Company =s.next();
        System.out.println("Contact is created");
    }
    void Display()
    {
        System.out.println("Name:"+Name+"\nDoB:"+DoB+"\nPlace:"+Place+"\nCompany:"+Company);
    }

    void Update()
    {
        System.out.println("which one you want to update 1.Name,2.DoB,3.Place,4.Company?");
        int dnum = s.nextInt();
        switch(dnum)
        {
            case 1:
                Name = s.next();
                break;
            case 2:
                DoB = s.next();
                break;
            case 3:
                Place = s.next();
                break;
            case 4:
                Company = s.next();
                break;
            default:
                System.out.println("enter valid Detail Number...");
        }
    }

    public static void main (String[] args)
    {
        int choice = 1;
        String ph;
        HashMap<String, ContactBook> o = new HashMap<String, ContactBook>();
        Scanner s = new Scanner(System.in);
        while(choice>0 && choice<5)
        {
            System.out.println("1.Create\n2.Display\n3.Update\n4.Delete");
            choice = s.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("enter phone number");
                    ph=s.next();
                    o.put(ph,new ContactBook(ph));
                    break;
                case 2:
                    for(Map.Entry<String, ContactBook> entry : o.entrySet()) {
                        System.out.println("Phone: "+entry.getKey());
                        ContactBook a= entry.getValue();
                        a.Display();
                    }
                    break;
                case 3:
                    System.out.println("Enter phone number: ");
                    String p = s.next();
                    ContactBook b = o.get(p);
                    b.Update();
                    o.replace(p,b);
                    break;
                case 4:
                    System.out.println("Enter phone number: ");
                    p = s.next();
                    o.remove(p);
                    break;
            }
        }
        System.out.println("Execution Done");
    }
}