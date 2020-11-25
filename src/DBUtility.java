import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connString = "jdbc:mysql://localhost:3306";

    public static ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(connString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet =  statement.executeQuery("SELECT * FROM customers");
                )
        {
            customers.add(new Customer(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("province"),
                    resultSet.getString("gender"),
                    resultSet.getString("birthday"),
                    resultSet.getString("bloodType")));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return customers;
    }

}
