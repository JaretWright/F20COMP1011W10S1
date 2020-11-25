import java.util.ArrayList;

public class StreamExperiments {
    public static void main(String[] args) {
        ArrayList<Customer> customers = DBUtility.getCustomers();

        System.out.printf("There are %d customers.", customers.size());

    }
}
