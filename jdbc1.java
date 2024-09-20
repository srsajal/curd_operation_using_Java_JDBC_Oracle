import java.sql.*;
import java.util.*;

class jdbc1 {
    public static void main(String args[]) {
        int option;
        Scanner sr = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------Welcome to Sajal's jdbc program-------------------------------------------------------------");
        while (true) {
            System.out.print(
                    "What do you want to do(press the number) : \n1. Get All Data\t\t2. Get Data By roll\t3. Insert Data\t\t4. Update Data\t\t5.Delete Data\t\t6. Search\t\t7. Exit : ");
            option = sr.nextInt();
            switch (option) {
                case 1:
                    getAllData();
                    break;
                case 2:
                    getDataById();
                    break;
                case 3:
                    insertData();
                    break;
                case 4:
                    updateData();
                    break;
                case 5:
                    deleteData();
                    break;
                case 6:
                    search();
                    break;
                case 7:
                {
                    System.out.println("---------------------------------------------------------------------Have a nice day---------------------------------------------------------------------");
                    return;
                }

                default:
                System.out.println("Enter valid number!!!");
                    break;
            }
        }
    }

    public static void getAllData() {

        try {
            // step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // step2 create the connection object
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc"); // Username and password in oracle
            // step3 create the statement object
            Statement stmt = con.createStatement();

            // step4 execute query
            ResultSet rs = stmt.executeQuery("select * from student");
            System.out.println();
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3));
            con.close();
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertData() {
        int roll;
        String name;
        String dept;
        Scanner sr = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc"); // Username and password in oracle
            System.out.print("Enter roll no : ");
            roll = sr.nextInt();
            sr.nextLine();
            System.out.print("Enter name : ");
            name = sr.nextLine();
            System.out.print("Enter dept : ");
            dept = sr.nextLine();
            String insertQuery = "INSERT INTO student (roll_no, name, dept) VALUES (?, ?,?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setInt(1, roll);
            pstmt.setString(2, name);
            pstmt.setString(3, dept);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println();
            System.out.println(rowsInserted + " rows inserted.");
            System.out.println();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteData() {
        int roll;
        Scanner sr = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc"); // Username and password in oracle
            System.out.print("Enter the roll no you want to delete : ");
            roll = sr.nextInt();
            String deleteQuery = "DELETE FROM student where roll_no = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteQuery);
            pstmt.setInt(1, roll);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println();
            System.out.println(rowsDeleted + " rows deleted.");
            System.out.println();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateData() {
        int roll;
        String name;
        String dept;
        Scanner sr = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc"); // Username and password in oracle
            System.out.print("Enter roll where you want to update : ");
            roll = sr.nextInt();
            sr.nextLine();
            System.out.print("Enter name : ");
            name = sr.nextLine();
            System.out.print("Enter dept : ");
            dept = sr.nextLine();
            String updateQuery = "UPDATE student SET name = ?, dept = ? WHERE roll_no = ?";
            PreparedStatement pstmt = con.prepareStatement(updateQuery);
            pstmt.setString(1, name);
            pstmt.setString(2, dept);
            pstmt.setInt(3, roll);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println();
            System.out.println(rowsUpdated + " rows updated.");
            System.out.println();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getDataById() {
        int roll;
        Scanner sr = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc"); // Username and password in oracle
            System.out.print("Enter roll number you want to see : ");
            roll = sr.nextInt();
            String getByIdQuery = "select * from student where roll_no = ?";
            PreparedStatement pstmt = con.prepareStatement(getByIdQuery);
            pstmt.setInt(1, roll);
            ResultSet rs = pstmt.executeQuery();
            System.out.println();
            if (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3));
            } else {
                System.out.println("No student found with roll number: " + roll);
            }
            System.out.println();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void search() {
        String s;
        Scanner sr = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc"); // Username and password in oracle
            System.out.print("Enter what you want to search : ");
            s = sr.nextLine();
            String searchQuery = "select * from student where TO_CHAR(roll_no) = ? or UPPER(name) like UPPER(?) or UPPER(dept) like UPPER(?) ";
            PreparedStatement pstmt = con.prepareStatement(searchQuery);

            pstmt.setString(1, s);
            // pstmt.setInt(1, roll);
            pstmt.setString(2, "%" + s + "%");
            pstmt.setString(3, "%" + s + "%");
            ResultSet rs = pstmt.executeQuery();
            System.out.println();
            boolean isFound = false;
            while (rs.next()){
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3));
                isFound = true;
            }
            if(!isFound)
            {
                System.out.println("No data found with : " + s);
            }
            System.out.println();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
