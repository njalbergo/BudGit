// User class for BudGIT
// by Nick Albergo

import java.util.*;

public class User 
{        
    private String username, userpw, user_email;
    private int user_id; // unused
    private HashMap<String,Double> cList = new HashMap<String, Double>(); // categories<name,allocated funds>
    // bankInfo to be added
    public static int id_count; // unused

    public User(String name, String pw, String email) 
    {
        username = name;
        userpw = pw;
        user_email = email;
        user_id = ++id_count;
    }
    
    public User() 
    {
        username = "username";
        userpw = "password";
        user_email = "N/A";
        user_id = -1;
    }
        
    public void setName(String s) 
    {
        username = s;
    }
        
    public void setPW(String pw) 
    {
        userpw = pw;
    }
        
    public void setEmail(String e) 
    {
        user_email = e;
    }
        
    public void addCategory(String c, double budget) 
    {
        cList.put(c,budget);
    }
    
    public String getName() 
    {
      return username;
    }
    
    public String getPW() 
    {
      return userpw;
    }
    
    public String getEmail() 
    {
      return user_email;
    }
    
    public void printC() 
    {
      Iterator iterator = cList.keySet().iterator();

      while (iterator.hasNext()) 
      {
        String key = iterator.next().toString();
        Double value = cList.get(key);
        System.out.println(key + ": $" + value);
      }
    }
    
    public void userInfo() 
    {
      System.out.println("User: " + this.getName() + " | Password: " + this.getPW() + " | Email: " + this.getEmail());
    }

    public void deleteC() 
    {
      cList.clear();
    }
    
    public static void main(String args[]) 
    {
      System.out.println("***Welcome to BudGIT***\n");   // debugging and tests
      /*
      User dummy = new User();
      dummy.addCategory("Food",69.99);
      dummy.addCategory("Clothing",19.99);
  
      dummy.printC();
      dummy.userInfo();
      dummy.deleteC();
      
      System.out.println();
      dummy.addCategory("Spaghetti",1);
      dummy.printC();
      */
      inputList();
    }
    
    public static void inputList() // only works for new users currently
    {
      String category, user, pw, em;
      double allocate;

      Scanner scan = new Scanner(System.in);
      category = "";
        
      System.out.println("Enter your username: ");
      user = scan.next();
      System.out.println("Enter your password: ");
      pw = scan.next();
      // if (new user)
      System.out.println("Enter your email: ");
      em = scan.next();
      User u = new User(user, pw, em);
      // else search for and accesss existing user's data (match password first)
      while(true)
      {
        System.out.println("Enter a category (q to quit): ");
        category = scan.next();
        if (category.equals("q"))
          break;
        System.out.println("How much would you like to allocate? ");
        allocate = scan.nextDouble();
        u.cList.put(category,allocate);
      } 
      System.out.printf("%s's categories:\n",u.getName());
      u.printC();
    }
    
    public static User findUser(int key) // returns default user for now 
    {
      // need database with stored user information to implement this function
      User dummy = new User();
      return dummy;
    }
}

  