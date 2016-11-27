package sqlitejdbc;

/**
 * Description: Interactive Java Program that interfaces with the chinook.db to
 * offer functionalities.
 * @author Mahesh
 */
import java.sql.*;
import java.util.Scanner;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    Scanner input = new Scanner(System.in);
    Scanner forstring = new Scanner(System.in);
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:chinook.db"); //Connect to the chinook.db database
      c.setAutoCommit(false); //not commit automatically
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      //provide choices
      System.out.println("Select an option from \n 1.Obtain Album titles based on Artist name \n 2.Purchase History for customer \n 3.Update Track price");
      int choice = input.nextInt();
      switch (choice){
        case 1:   
            System.out.println("Enter name of artist: ");
            String s = forstring.nextLine();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT Album.Title, Artist.Name FROM Artist, Album where Artist.Name = '"+s+"' AND Album.ArtistId=Artist.ArtistId;");
            while ( rs.next() ) {
               String  artist_name = rs.getString("Name");
               String  album_title = rs.getString("Title");
               System.out.println( "Artist NAME = " + artist_name );
               System.out.println( "Album Title = " + album_title );
               System.out.println();
            }
            rs.close();
            break;
        case 2:    
            System.out.println("Enter Customer Id to get Purchase History");
            int customer_id = input.nextInt();
            ResultSet rstwo = stmt.executeQuery( "Select T.Name, A.Title, I.InvoiceDate, IL.Quantity from Track T, Album A, Invoice I, InvoiceLine IL, Customer C where C.CustomerId = "+customer_id+" AND C.CustomerId = I.CustomerId AND I.InvoiceId=IL.InvoiceId AND IL.TrackId= T.TrackId And T.AlbumId = A.AlbumId;");
            while ( rstwo.next() ) {
               String  track_name = rstwo.getString("Name");
               String  album_name = rstwo.getString("Title");
               String  date = rstwo.getString("InvoiceDate");
               int quantity  = rstwo.getInt("Quantity");
               System.out.println( "Track NAME = " + track_name );
               System.out.println( "Album Title = " + album_name );
               System.out.println( "Invoice Date = " + date );
              System.out.println( "Quantity = " + quantity );
               System.out.println();
            }
            rstwo.close();
            break;
        case 3:
            System.out.println("Enter the TrackId to get its UnitPrice: ");
            float entered_track_id = input.nextFloat();
            ResultSet rsthree = stmt.executeQuery( "Select UnitPrice from Track where Track.TrackId = "+entered_track_id+";");
            while ( rsthree.next() ) {
               float unit_price  = rsthree.getFloat("UnitPrice");
                System.out.println( "PRICE = " + unit_price );
               System.out.println();
            }
            rsthree.close();
            System.out.println("Enter new value for Unit Price: ");
            float new_price = input.nextFloat();
            String sql = "UPDATE TRACK set UnitPrice = "+new_price+" where TrackId="+entered_track_id+";";
            stmt.executeUpdate(sql);
            c.commit();
            break;
        default: 
            System.out.println("NOT done successfully");
            break;

      }

      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}

