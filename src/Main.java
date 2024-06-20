import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/basic_auth_db";
        String user = "postgres";
        String password = "Panhadb";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();


            String query = """
                SELECT * FROM Product
            """;
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double pricePerUnit = resultSet.getDouble("price_per_unit");
                boolean activeForSell = resultSet.getBoolean("active_for_sell");

                // Print the product details
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price Per Unit: " + pricePerUnit);
                System.out.println("Active For Sell: " + activeForSell);
                System.out.println("-------------------------");
            }


            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}