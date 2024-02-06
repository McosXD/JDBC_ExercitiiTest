package Ex;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
    public static void adaugare_M(Connection connection, int id, String marca, int cp, int id_service)
    { String sql="insert into masina values (?,?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ps.setString(2, marca);
            ps.setInt(3, cp);
            ps.setInt(4, id_service);
            ps.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void adaugare_S(Connection connection, int id, String nume, String adresa)
    { String sql="insert into service values (?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ps.setString(2, nume);
            ps.setString(3, adresa);
            ps.executeUpdate();

        } catch (SQLException e)
        {
            System.out.println(sql);
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sys";
        try {
            Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, "root", "root");


            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from service");

//            System.out.println("Introduceti id: ");
//            int id = scanner.nextInt();
//            System.out.println("Introduceti nume: ");
//            String nume = scanner.nextLine();
//            System.out.println("Introduceti adresa: ");
//            String adresa = scanner.nextLine();
            //adaugare_S(connection, 3, "florin", "op");

//            System.out.println("Introduceti id_masina: ");
//            int id_m = scanner.nextInt();
//            System.out.println("Introduceti marca: ");
//            String marca = scanner.nextLine();
//            System.out.println("Introduceti cp: ");
//            int cp = scanner.nextInt();
//            System.out.println("Introduceti id_service: ");
//            int id_s = scanner.nextInt();

            //adaugare_M(connection, 5, "4roti", 7000, 3);

            while (rs.next()) {
                System.out.println("id=" + rs.getInt("ID") + ", nume= " + rs.getString("Nume") + ", adresa=" + rs.getString("Adresa"));
            }
        }catch (SQLException e) { e.printStackTrace(); }
    }

}
