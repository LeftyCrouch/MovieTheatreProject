import java.io.*;

/**
 * Menu Class where the main method is located and
 * each case for each option of the text menu is done.
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 * @date 12/5/11
 *
 *
 */
public class Menu
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));
    private ListArrayBasedPlus transformers;
    private ListArrayBasedPlus muppets;
    private QueueReferenceBased express = new QueueReferenceBased();
    private QueueReferenceBased regOne = new QueueReferenceBased();
    private QueueReferenceBased regTwo = new QueueReferenceBased();
    private QueueReferenceBased serveQueue = new QueueReferenceBased();     //order for lines to be taken care of
    private int tSize = 0;      // variable to help with size of current theater being used
    private String movieName = "";      //variable to help with name of theater currently being used
    private int rowMuppet = 0;
    private int seatsMuppet = 0;
    private int muppetsSize = 0;
    private int rowTrans = 0;
    private int seatsTrans = 0;
    private int transSize = 0;
    private double price = 0;
    private double totalEarnings = 0;
    private int ticketsMuppet = 0;
    private int ticketsTrans = 0;
    private boolean firstTime = true;     // used for picking line for calling case 2 for first time
    private int counter = 0;        // used for round robin order of lines


    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        // nothing needs to be initialized in the constructor
    }

    /**
     * prints the seating for the theater to show which seats are taken and which are available
     *
     * @param int takes an integer to determine which theater to print out: 0 for Muppets and 1 for Transformers
     *
     * modified by Chris Crouch
     *
     */
    public void printSeating(int chart)
    {
        int rowTheater = 0;
        int seatTheater = 0;
        ListArrayBasedPlus seatChart = new ListArrayBasedPlus();

        switch(chart)
        {
        case 0:
            rowTheater = rowMuppet;
            seatTheater = seatsMuppet;
            seatChart = muppets;
            System.out.println("This is the seating chart for the Muppets Theater!");
            System.out.println("");
            break;
        case 1:
            rowTheater = rowTrans;
            seatTheater = seatsTrans;
            seatChart = transformers;
            System.out.println("This is the seating chart for the Transformers Theater!");
            System.out.println("");
            break;
        }

        for(int base = 0; base < seatTheater; base++)
        {
            if(seatChart.get(base) == null)
            {
                System.out.println("Row 1 seat " + (base + 1) + " is free.");
            }
            else
            {
                System.out.println("Row 1 seat " + (base + 1) + " used by " + seatChart.get(base)
                                   + "'s party.");
            }
        }

        for(int x = 1; x < rowTheater; x++)
        {
            int zeroSpot = x * seatTheater;
            if(seatChart.get(zeroSpot) == null)
            {
                System.out.println("Row " + (x + 1) + " seat " + 1 + " is free.");
            }
            else
            {
                System.out.println("Row " + (x + 1) + " seat " + 1 + " used by " + seatChart.get(zeroSpot)
                                   + "'s party.");
            }

            for(int y = 1; y < seatTheater; y++)
            {
                int position = zeroSpot + y;
                if(seatChart.get(position) == null)
                {
                    System.out.println("Row " + (x + 1) + " seat " + (y + 1) + " is free.");
                }
                else
                {
                    System.out.println("Row " + (x + 1) + " seat " + (y + 1) + " used by " + seatChart.get(position)
                                       + "'s party.");
                }
            }
        }
    }

    /**
     * checks to see if a customer with the name entered is already in the movie theater.
     * If so another name is asked so duplication is not a concern.
     *
     * @param name name entered by the customer for checking
     *
     * @return boolean returns true if the name given is already in the theater, else false and the name can be used.
     *
     * modified by Chris Crouch
     *
     */
    public boolean checkCustomer(String name)
    {
        int rotation = 1;
        QueueReferenceBased checkQueue = new QueueReferenceBased();
        while(rotation < 4)
        {
            switch(rotation)
            {
            case 1:
                checkQueue = express;
                break;
            case 2:
                checkQueue = regOne;
                break;
            case 3:
                checkQueue = regTwo;
                break;
            }

            for(int x = 0; x < checkQueue.size(); x++)
            {
                Node first = checkQueue.back.getNext();
                Customer expressLane = (Customer) first.getItem();
                if(expressLane.getName().equals(name))
                {
                    return true;
                }
                Node nextItem = checkQueue.back.getNext().getNext();
                while(nextItem != first)
                {
                    Customer nextCheck = (Customer) nextItem.getItem();
                    if(nextCheck.getName().equals(name))
                    {
                        return true;
                    }
                    nextItem = nextItem.getNext();
                }
            }
            rotation++;
        }

        if(searchCustomer(name, false) == true)
        {
            return true;
        }
        return false;
    }

    /**
     * menuApp for the main method to run the program for the user to use.
     * takes in text based information to perform numerous tasks.
     *
     * modified by Chris Crouch and Donald Aufiero
     * case 1: Chris
     * case 2: Donald
     * case 3: Donald
     * case 4: Chris
     * case 5: Donald/Chris
     * case 6: Chris
     * case 7: Chris
     *
     */
    public void menuApp() throws IOException
    {
        System.out.println("Welcome to the Best Movie Theater Ever!");
        System.out.println("    Tonight's featured films are: ");
        System.out.println("        'Transformers' and 'Muppets' ");
        System.out.println();
        System.out.println("Please specify the size of the movie theaters");
        System.out.println("        Enter information about the Muppets movie theater:");
        System.out.print("                  >>Enter number of rows: ");
        String row = stdin.readLine();
        rowMuppet = Integer.parseInt(row);
        System.out.print("                  >>Enter number of seats in a row: ");
        String seats = stdin.readLine();
        seatsMuppet = Integer.parseInt(seats);
        muppetsSize = rowMuppet * seatsMuppet;
        muppets = new ListArrayBasedPlus(muppetsSize);
        System.out.println("        Enter information about the Transformers movie theater:");
        System.out.print("                  >>Enter number of rows: ");
        String rowString = stdin.readLine();
        rowTrans = Integer.parseInt(rowString);
        System.out.print("                  >>Enter number of seats in a row: ");
        String seatsString = stdin.readLine();
        seatsTrans = Integer.parseInt(seatsString);
        transSize = rowTrans * seatsTrans;
        transformers = new ListArrayBasedPlus(transSize);
        System.out.print("                  >>Enter the price of a ticket: ");
        String p = stdin.readLine();
        price = Double.parseDouble(p);
        System.out.println();
        int choice = 0;
        while( choice != 8)
        {
            System.out.println("Select an operation from the following menu");
            System.out.println(        "1. Customer(s) enter(s) movie theater.");
            System.out.println(        "2. Customer is served.");
            System.out.println(        "3. Customer(s) leave(s) the theater.");
            System.out.println(        "4. Display info about customers waiting for tickets.");
            System.out.println(        "5. Display seating chart for Transformers movie theater.");
            System.out.println(        "6. Display seating chart for Muppers movie theater.");
            System.out.println(        "7. Display number of tickets sold and total earnings");
            System.out.println(        "8. End the program.");
            System.out.print(">>Make your menu selection now: ");
            String answer = stdin.readLine();
            choice = Integer.parseInt(answer);
            switch(choice)
            {
            case 1:
                System.out.print(">>Enter customer name: ");
                String customer = stdin.readLine();
                while(checkCustomer(customer))
                {
                    System.out.println("Customer " + customer + " is already in the theater!");
                    System.out.println("Please specify another name.");
                    System.out.print(">>Enter customer name: ");
                    customer = stdin.readLine();
                }
                System.out.print(">>Enter party size: ");
                String size = stdin.readLine();
                int customerSize = Integer.parseInt(size);
                System.out.print(">>Enter movie name: ");
                String customerMovie = stdin.readLine();
                System.out.print(">>Is a child 12 or younger in this party(Y/N)? ");
                String cTwelve = stdin.readLine();
                boolean customerTwelve = false;
                if(cTwelve.equals("Y"))
                {
                    customerTwelve = true;
                }
                Customer c = new Customer(customer, customerSize, customerMovie, customerTwelve);
                QueueReferenceBased lowest = regOne;
                String lowestName = "regular line 1";
                if(c.getTwelve())
                {
                    lowest = express;
                    lowestName = "express";
                    if(regOne.size() == lowest.size())
                    {
                    }
                    else if(regOne.size() <= (.5) * lowest.size())
                    {
                        lowest = regOne;
                        lowestName = "regular line 1";
                    }
                    if(regTwo.size() == lowest.size())
                    {
                    }
                    else if(regTwo.size() <= (.5) * lowest.size())
                    {
                        lowest = regTwo;
                        lowestName = "regular line 2";
                    }
                }
                else
                {
                    if(regTwo.size() < lowest.size())
                    {
                        lowest = regTwo;
                        lowestName = "regular line 2";
                    }
                }
                lowest.enqueue(c);
                System.out.println("Customer " + customer + " is in " + lowestName
                                   + " ticket line.");
                break;
            case 2:
                if(firstTime)
                {
                    System.out.print(">>Which line would you like to serve customers first? (Express/Reg1/Reg2): ");
                    String firstLine = stdin.readLine();
                    if(firstLine.equals("Reg1"))
                    {
                        counter = 1;
                        firstTime = false;
                    }
                    else if(firstLine.equals("Reg2"))
                    {
                        counter = 2;
                        firstTime = false;
                    }
                    firstTime = false;
                }
                int i = 0;
                boolean emptyCheck = false;
                while((i < 3) && (!emptyCheck))
                {
                    serveQueue = getLine();
                    if(serveQueue.isEmpty())
                    {
                        i++;
                    }
                    else
                    {
                        emptyCheck = true;
                    }
                }
                if(emptyCheck)
                {
                    boolean firstOpen = false;
                    boolean secondOpen = true;
                    Customer seatCustomer = (Customer) serveQueue.peek();
                    ListArrayBasedPlus theater = getTheater(false);
                    if(tSize - theater.size() < seatCustomer.getPartySize())
                    {
                        firstOpen = true;
                        theater = getTheater(true);
                        if(tSize - theater.size() < seatCustomer.getPartySize())
                        {
                            System.out.println("Sorry! Both movies are sold out! Goodbye!!");
                            System.out.println("Customer " + seatCustomer.getName() + " has left the theater.");
                            serveQueue.dequeue();
                            secondOpen = false;
                        }

                        if((firstOpen) & (secondOpen))
                        {
                            System.out.print(">>Sorry! This movie is sold out. Would you like to see the other movie?(Y/N): ");
                            String decision = stdin.readLine();
                            if(decision.equals("Y"))
                            {
                                serveCustomer(seatCustomer, theater);
                            }
                            else
                            {
                                System.out.println("Customer " + seatCustomer.getName() + " has left the theater.");
                            }
                        }
                    }
                    else
                    {
                        serveCustomer(seatCustomer, theater);

                    }
                }
                else
                {
                    System.out.println("There are no customers in any line!");
                    firstTime = false;
                }
                break;
            case 3:
                if(transformers.isEmpty() && muppets.isEmpty())
                {
                    System.out.println("No customers are in the movie theater at this time.");
                }
                else
                {
                    System.out.print(">>Enter customer name to leave movie theater: ");
                    String custName = stdin.readLine();
                    if(transformers.isEmpty() && muppets.isEmpty())
                    {
                        System.out.println("No customers are in the movie theater at this time.");
                    }
                    if(searchCustomer(custName, true))
                    {
                        System.out.println("Customer " + custName + " has left the theater!");
                    }
                    else
                    {
                        System.out.println("This customer is not in the theater!!");
                    }
                }
                break;
            case 4:
                if(!express.isEmpty())
                {
                    System.out.println("The following customers are in the express line: ");
                    System.out.println(express.toString());
                }
                else
                {
                    System.out.println("No customers in the express line! \n");
                }

                if(!regOne.isEmpty())
                {
                    System.out.println("The following customers are in the first line: ");
                    System.out.println(regOne.toString());
                }
                else
                {
                    System.out.println("No customers in the first line! \n");
                }

                if(!regTwo.isEmpty())
                {
                    System.out.println("The following customers are in the second line: ");
                    System.out.println(regTwo.toString());
                }
                else
                {
                    System.out.println("No customers in the second line! \n");
                }
                break;
            case 5:
                printSeating(1);
                break;
            case 6:
                printSeating(0);
                break;
            case 7:
                System.out.println(ticketsTrans + " tickets have been sold for the Transformers Movie.");
                System.out.println(ticketsMuppet + " tickets have been sold for the Muppets Movie.");
                System.out.println("Total earnings: " + totalEarnings);
                break;
            case 8:
                System.out.println("");
                System.out.println("The Best Movie Theater Ever has caught fire!!");
                System.out.println("All remaining customers have perished!!");
                System.out.println("Should have gone to The Wonderful Movie Theater!!");
                System.out.println("...");
                break;
            }
            System.out.println();
        }
    }

    /**
     * checks to see if a name of a customer is in any of the theaters.
     * if the boolean is set to false it is just checking for customers coming in.
     * if the boolean is true, it is looking for the name for removing purposes.
     *
     * @param name name of customer to be searched for
     * @param boolean true if the customer is leaving and they are being removed from list of seating, or false
     * if the name if the customer is just being checked for name purposes.
     *
     * modified by Donald Aufiero
     *
     */
    private boolean searchCustomer(String name, boolean kickOut)
    {
        boolean exists = false;
        int movieCheck = 1;
        ListArrayBasedPlus checkTheater = new ListArrayBasedPlus();
        int sizeCheck = 0;
        while(movieCheck < 3)
        {
            switch(movieCheck)
            {
            case 1:
                checkTheater = muppets;
                sizeCheck = muppetsSize;
                break;
            case 2:
                checkTheater = transformers;
                sizeCheck = transSize;
                break;
            }

            for(int i = 0; i < sizeCheck; i++)
            {
                if(!(checkTheater.get(i) == null))
                {
                    if(checkTheater.get(i).equals(name))
                    {
                        exists = true;
                        if(kickOut)
                        {
                            checkTheater.remove(i);
                        }
                    }
                }
            }
            movieCheck++;
        }
        return exists;
    }

    /**
     * serves the customer to the desired theater.
     * runs through the method checkNull to find empty seats to seat them at.
     * prints out where they have entered.
     * tickes sold is increased by size of party and total earnings is increased.
     *
     * @param customer seatCustomer is customer currently being taken care of and being seated in a theater
     * @param theater theater that the customer is going to be entering
     *
     * modified by Donald Aufiero
     *
     */
    protected void serveCustomer(Customer seatCustomer, ListArrayBasedPlus theater)
    {
        for(int party = 0; party < seatCustomer.getPartySize(); party++)
        {
            theater.add(checkNull(theater), seatCustomer.getName());
        }
        System.out.println("Customer " + seatCustomer.getName() + ", party of " + seatCustomer.getPartySize() + " has entered the " + movieName + " theater!");
        serveQueue.dequeue();
        if(movieName.equals("Muppets"))
        {
            ticketsMuppet += seatCustomer.getPartySize();
            totalEarnings += ((seatCustomer.getPartySize()) * price);
        }
        else
        {
            ticketsTrans +=  seatCustomer.getPartySize();
            totalEarnings += ((seatCustomer.getPartySize()) * price);
        }
    }

    /**
     * checks theater of choice to find how many empty seats are in it
     *
     * @param theater the theater to be checked for seating
     *
     * @return int - returns an int with the number of seats available
     *
     * modified by Donald Aufiero
     *
     */
    protected int checkNull(ListArrayBasedPlus checkTheater)
    {
        int check = 0;
        boolean found = false;
        while((check < checkTheater.size()) && (!found))
        {
            if(checkTheater.get(check) == null)
            {
                found = true;
            }
            else
            {
                check++;
            }
        }
        return check;
    }

    /**
     * returns the theater the current customer being helped wants to see if the boolean entered is false.
     * if the boolean is true, the customer cannot get into the movie of their choice so the other option
     * is taken into consideration.
     *
     * @param boolean false if the method is checking for the customer for the first time, false if it is checking again
     * after finding out the customer cannot attend the movie of their first choice
     *
     * @return theater returns the list of the theater that the customer may have a chance in getting into after other checks are ran
     *
     * modified by Donald Aufiero
     *
     */
    protected ListArrayBasedPlus getTheater(boolean second)
    {
        Customer seatCustomer = (Customer) serveQueue.peek();
        String custMovie = seatCustomer.getMovie();
        ListArrayBasedPlus returnT = new ListArrayBasedPlus();
        if(!second)
        {
            if(custMovie.equals("Muppets"))
            {
                returnT = muppets;
                tSize = muppetsSize;
                movieName = "Muppets";
            }
            else
            {
                returnT = transformers;
                tSize = transSize;
                movieName = "Transformers";
            }
        }
        else if(second)
        {
            if(custMovie.equals("Muppets"))
            {
                returnT = transformers;
                tSize = transSize;
                movieName = "Transformers";
            }
            else
            {
                returnT = muppets;
                tSize = muppetsSize;
                movieName = "Muppets";
            }
        }
        return returnT;
    }

    /**
     * sets and keeps track of the round robin order that the lines are being served in.
     * the start of the order is specified by the user from the start of the serving.
     *
     * @return Queue - returns the queue that is next up to be served
     *
     * modified by Donald Aufiero
     *
     */
    protected QueueReferenceBased getLine()
    {
        QueueReferenceBased chosenQueue = new QueueReferenceBased();
        switch(counter)
        {
        case 0:
            chosenQueue = express;
            counter++;
            break;
        case 1:
            chosenQueue = regOne;
            counter++;
            break;
        case 2:
            chosenQueue = regTwo;
            counter = 0;
            break;
        }
        return chosenQueue;
    }

    /**
     * runs the program
     */
    public static void main(String Args[]) throws IOException
    {
        Menu menu = new Menu();
        menu.menuApp();
    }
}
