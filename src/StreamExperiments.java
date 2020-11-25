import java.util.ArrayList;
import java.util.OptionalDouble;

public class StreamExperiments {
    public static void main(String[] args) {
        ArrayList<Customer> customers = DBUtility.getCustomers();

        System.out.printf("There are %d customers.%n", customers.size());


        //challenge 1 - create a method that will return the number
        //of male customers
        System.out.printf("There are %d male customers. %n",
                            getNumOfCustomerByGender(customers,"male"));

        //challenge 2 - create a method that will return the number
        //of female customers
        System.out.printf("There are %d female customers. %n",
                getNumOfCustomersWithStream(customers, "female"));

        //challenge 3 - what is the % of male to female customers
        System.out.printf("The %% of male customers is: %.1f%% %n",
                ((double) getNumOfCustomerByGender(customers, "male")/customers.size()*100));


        OptionalDouble avgAge = customers.stream()
                                .mapToDouble(Customer::getAge)
                                .average();
        if (avgAge.isPresent())
            System.out.printf("The average age of customers is %.1f years%n",avgAge.getAsDouble());


    }

    private static int getNumOfCustomerByGender(ArrayList<Customer> customers, String gender)
    {
        int count = 0;
        for (Customer customer : customers)
        {
            if (customer.getGender().equals(gender))
                count++;
        }
        return count;
    }

    /**
     * The same kind of method as the previous one, but using Streams
     */
    public static long getNumOfCustomersWithStream(ArrayList<Customer> customers, String gender)
    {
        return customers.stream()
                .filter(customer -> customer.getGender().equals(gender))
                .count();
    }
}
