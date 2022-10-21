package accesobasededatos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBaseDatos {
	
	private static String servidor ="jdbc:mysql://dns11036.phdns11.es";
	private static Connection connection;
	private static Statement st = null;
	
	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(servidor,"ad2223","nervion");
            if ( connection != null){
                st = (Statement) connection.createStatement();
                System.out.println("Conexión a base de datos test correcta ");
                System.out.println(st.toString());

                String []campos = {"Id int PRIMARY KEY AUTO_INCREMENT", "Nombre varchar(255)", "Apellidos varchar(255)", "Edad int"};
                //crearTabla(st,"Anavarro", campos),
                //insertarTabla(st);
                //ListaTablaEdad(st);
                //ListaTablaApellidos(st);
                ListaTablaEdad30(st);
            }
            else {
                System.out.println("Conexión fallida");
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void crearTabla(Statement st, String tabla, String []campos) throws SQLException {
            String sql = "CREATE TABLE ad2223."+tabla+"(";
            for(int i = 0; i < campos.length; i++){

                if (i == campos.length - 1){
                    sql += campos[i];
                } else {
                    sql += campos[i] + ",";
                }
            }
            sql += ")";
            System.out.println(sql);
            ((java.sql.Statement) st).executeUpdate(sql);
    }
    
    
    
    
    
    
    
    public static void ListaTablaEdad30(Statement st) throws SQLException{
    	String sql = "SELECT * FROM ad2223.Anavarro where Edad>30;";
    	
    	MostrarListaTablaEdad30(st,sql);
    }
    
    public static void MostrarListaTablaEdad30(Statement st, String sql) throws SQLException{
    	ResultSet rs;
    	rs = st.executeQuery(sql);
    	
    	while(rs.next()) {
    		System.out.println("Nombre|| "+rs.getString("Nombre")+" ||Apellido|| "+ rs.getString("Apellidos")+ " ||Edad|| " + rs.getString("Edad"));
    	}
    }

    
    
    
    
    
    
    public static void ListaTablaApellidos(Statement st) throws SQLException{
    	String sql = "SELECT Nombre, Apellidos FROM ad2223.Anavarro ORDER BY Apellidos;";
    	
    	MostrarListaTablaApellidos(st,sql);
    }
    
    public static void MostrarListaTablaApellidos(Statement st, String sql) throws SQLException{
    	ResultSet rs;
    	rs = st.executeQuery(sql);
    	
    	while(rs.next()) {
    		System.out.println("Nombre|| "+rs.getString("Nombre")+" ||Apellidos|| "+ rs.getString("Apellidos"));
    	}
    }
    
    
    
    
    
    
    
    
    public static void ListaTablaEdad(Statement st) throws SQLException{
    	String sql = "SELECT * FROM ad2223.Anavarro ORDER BY Edad;";
    	
    	MostrarListaTablaEdad(st,sql);
    }
    
    
    public static void MostrarListaTablaEdad(Statement st, String sql) throws SQLException{
    	ResultSet rs;
    	rs = st.executeQuery(sql);
    	
    	while(rs.next()) {
    		System.out.println("Nombre|| "+rs.getString("Nombre")+" ||Apellido|| "+ rs.getString("Apellidos")+ " ||Edad|| " + rs.getString("Edad"));
    	}
    }
        
    
    
    
    
    
    
    

    public static void insertarTabla(Statement st) throws SQLException{
    	String sql="insert into ad2223.Anavarro(Nombre, Apellidos, Edad)values('Dame', 'Fulloway', 97),"
    			+ " ('Genevieve', 'Kovelmann', 50), "
    			+ " ('Edith', 'Andri', 30), "
    			+ " ('Brigida', 'Corzon', 40), "
    			+ " ('Rosalinde', 'Mattea', 62), "
    			+ " ('Russell', 'Castanos', 13), "
    			+ " ('Erskine', 'Doret', 24), "
    			+ " ('Cesar', 'Feld', 39), "
    			+ " ('Brina', 'Hastelow', 68), "
    			+ " ('Iolanthe', 'Leteurtre', 19), "
    			+ " ('Giordano', 'Grichukhin', 82), "
    			+ " ('Kimmy', 'Blancowe', 50), "
    			+ " ('Ginnie', 'Mildmott', 74), "
    			+ " ('Zachary', 'Munnion', 17), "
    			+ " ('Gregoire', 'Lillow', 14), "
    			+ " ('Tara', 'McCann', 85), "
    			+ " ('Zulema', 'Meighan', 40), "
    			+ " ('Basile', 'Wolfendale', 100), "
    			+ " ('Brigit', 'Urlin', 28), "
    			+ " ('Ward', 'Gilogly', 63), "
    			+ " ('Abelard', 'Rosenkrantz', 60), "
    			+ " ('Baillie', 'McGeouch', 83), "
    			+ " ('Zack', 'Diperaus', 61), "
    			+ " ('Ezequiel', 'Minogue', 66), "
    			+ " ('Jilli', 'Mathiassen', 48), "
    			+ " ('Lesly', 'Giabucci', 94), "
    			+ " ('Georgianna', 'Hartwell', 47), "
    			+ " ('Yolane', 'Eby', 65), "
    			+ " ('Kathryne', 'Binfield', 67), "
    			+ " ('Anderea', 'Lantuffe', 35), "
    			+ " ('Haley', 'Till', 12), "
    			+ " ('Karlens', 'Haslam', 33), "
    			+ " ('April', 'Jakubovicz', 67), "
    			+ " ('Frederigo', 'Sheach', 67), "
    			+ " ('Farleigh', 'Atwool', 62), "
    			+ " ('Andy', 'Brampton', 27), "
    			+ " ('Kalvin', 'Forestall', 32), "
    			+ " ('Henrik', 'Stroulger', 88), "
    			+ " ('Amity', 'Pre', 14), "
    			+ " ('Cris', 'Moro', 68), "
    			+ " ('Aylmar', 'Dewicke', 62), "
    			+ " ('Thomasin', 'Dungey', 40), "
    			+ " ('Trudi', 'McCloughen', 17), "
    			+ " ('Alta', 'Marflitt', 41), "
    			+ " ('Olag', 'Pitone', 35), "
    			+ " ('Rachele', 'Stout', 51), "
    			+ " ('Inger', 'Grindlay', 63), "
    			+ " ('Rona', 'Purton', 85), "
    			+ " ('Selinda', 'Launder', 76), "
    			+ " ('Kellia', 'Hampshire', 57), "
    			+ " ('Alexine', 'Heinzler', 73), "
    			+ " ('Kirbee', 'Delepine', 88), "
    			+ " ('Diannne', 'Augie', 48), "
    			+ " ('Horace', 'Trunkfield', 55), "
    			+ " ('Itch', 'Sketh', 46), "
    			+ " ('Matti', 'Kimmons', 62), "
    			+ " ('Carilyn', 'O''Suaird', 62), "
    			+ " ('Oona', 'Graddon', 61), "
    			+ " ('Francklyn', 'Putt', 58), "
    			+ " ('Cosimo', 'Thake', 14), "
    			+ " ('Clemmy', 'Flintuff', 97), "
    			+ " ('Hortense', 'Bamlett', 37), "
    			+ " ('Robbie', 'Woolen', 86), "
    			+ " ('Angelina', 'McDonnell', 30), "
    			+ " ('Teriann', 'Polding', 78), "
    			+ " ('Errick', 'Oakland', 75), "
    			+ " ('Geralda', 'Hallows', 99), "
    			+ " ('Dorene', 'Hakonsson', 34), "
    			+ " ('Austina', 'Cahillane', 33), "
    			+ " ('Carolina', 'Cockshut', 78), "
    			+ " ('Dawn', 'Ruff', 25), "
    			+ " ('Mortimer', 'Fodden', 59), "
    			+ " ('Jocelin', 'Deadman', 23), "
    			+ " ('Ermin', 'Cisar', 45), "
    			+ " ('Clayton', 'Gwillym', 36), "
    			+ " ('Cassaundra', 'Farndell', 73), "
    			+ " ('Shara', 'Hathaway', 22), "
    			+ " ('Ranna', 'Fessions', 81), "
    			+ " ('Ailee', 'Andrag', 12), "
    			+ " ('Katee', 'Hubbuck', 95), "
    			+ " ('Billy', 'McCaighey', 25), "
    			+ " ('Freemon', 'Philott', 12), "
    			+ " ('Pietro', 'Welford', 63), "
    			+ " ('Zorana', 'Verbeke', 55), "
    			+ " ('Pascal', 'Itzkovwitch', 70), "
    			+ " ('Leodora', 'Buzek', 30), "
    			+ " ('Baldwin', 'Busher', 22), "
    			+ " ('Hugo', 'Bellows', 30), "
    			+ " ('Nike', 'Dow', 70), "
    			+ " ('Jarid', 'Creber', 49), "
    			+ " ('Temple', 'Mapholm', 75), "
    			+ " ('Brandie', 'Sivewright', 100), "
    			+ " ('Emlynne', 'O''Cahey', 30), "
    			+ " ('Lise', 'Vaggers', 91), "
    			+ " ('Zarah', 'Harte', 31), "
    			+ " ('Patrice', 'Manicomb', 25), "
    			+ " ('Guilbert', 'Pundy', 89), "
    			+ " ('Drake', 'Shouler', 23), "
    			+ " ('Kirk', 'Golborne', 23), "
    			+ " ('Gigi', 'Crees', 22), "
    			+ " ('Fran', 'Duchart', 39), "
    			+ " ('Alyssa', 'Gretham', 95), "
    			+ " ('Benji', 'Plaunch', 40), "
    			+ " ('Gualterio', 'Scala', 24), "
    			+ " ('Stacie', 'Tomeo', 56), "
    			+ " ('Welby', 'Aikett', 37), "
    			+ " ('Stillman', 'Petrik', 37), "
    			+ " ('Tobiah', 'Webburn', 46), "
    			+ " ('Trude', 'Charpling', 33), "
    			+ " ('Neel', 'Boak', 28), "
    			+ " ('Rosco', 'Guidoni', 50), "
    			+ " ('Ebeneser', 'Gromley', 95), "
    			+ " ('Con', 'Shave', 44), "
    			+ " ('Eugen', 'Giacomozzo', 13), "
    			+ " ('Ilaire', 'Spawell', 86), "
    			+ " ('Ashley', 'Yeaman', 40), "
    			+ " ('Skipton', 'Grimsey', 25), "
    			+ " ('Christy', 'Aubri', 38), "
    			+ " ('Kath', 'McKerlie', 60), "
    			+ " ('Aylmar', 'De Bischop', 78), "
    			+ " ('Nicolas', 'Tollow', 79), "
    			+ " ('Sullivan', 'Balk', 98), "
    			+ " ('Ashley', 'Christophle', 79), "
    			+ " ('Glennis', 'Atcherley', 72), "
    			+ " ('Marc', 'St Louis', 30), "
    			+ " ('Abelard', 'Lowerson', 23), "
    			+ " ('Niccolo', 'Giorgione', 67), "
    			+ " ('Mehetabel', 'Crohan', 88), "
    			+ " ('Kathi', 'Shera', 54), "
    			+ " ('Alard', 'Scoon', 28), "
    			+ " ('Valaree', 'Comfort', 98), "
    			+ " ('Arnie', 'Dunnan', 62), "
    			+ " ('Estelle', 'Laing', 97), "
    			+ " ('Elfrida', 'Hurll', 20), "
    			+ " ('Gabrielle', 'Guys', 41), "
    			+ " ('Lexis', 'Dowdall', 76), "
    			+ " ('George', 'Faull', 73), "
    			+ " ('Burt', 'Saing', 53), "
    			+ " ('Mikael', 'Duferie', 64), "
    			+ " ('Bernelle', 'Peirone', 93), "
    			+ " ('Malachi', 'Birch', 85), "
    			+ " ('Aloise', 'Demoge', 12), "
    			+ " ('Norman', 'Klementz', 82), "
    			+ " ('Kyle', 'Grishanov', 88), "
    			+ " ('Caspar', 'Magog', 58), "
    			+ " ('Dreddy', 'Frankcom', 87), "
    			+ " ('Michaeline', 'Hoffmann', 81), "
    			+ " ('Berny', 'Von Hindenburg', 55), "
    			+ " ('Mariette', 'Bayfield', 12), "
    			+ " ('Anette', 'Maxfield', 80), "
    			+ " ('Roanne', 'Dy', 27), "
    			+ " ('Kyle', 'Setch', 32), "
    			+ " ('Erda', 'Lowdwell', 37), "
    			+ " ('Cindelyn', 'Salkeld', 61), "
    			+ " ('Constantine', 'Spenceley', 61), "
    			+ " ('Thoma', 'Tirkin', 15), "
    			+ " ('Benson', 'Manifield', 26), "
    			+ " ('Lenna', 'Fellnee', 19), "
    			+ " ('Merl', 'Dericut', 19), "
    			+ " ('Ban', 'Tuttle', 15), "
    			+ " ('Padraic', 'Caroli', 28), "
    			+ " ('Joella', 'Cannaway', 22), "
    			+ " ('Lilah', 'MacAindreis', 88), "
    			+ " ('Gottfried', 'Dehn', 78), "
    			+ " ('Maisey', 'Dearnly', 94), "
    			+ " ('Clem', 'Waudby', 78), "
    			+ " ('Lucienne', 'Aisthorpe', 75), "
    			+ " ('Darla', 'Geikie', 67), "
    			+ " ('Durward', 'Playfoot', 66), "
    			+ " ('Heindrick', 'Points', 91), "
    			+ " ('Frankie', 'Quinnell', 48), "
    			+ " ('Maxine', 'Petticrow', 45), "
    			+ " ('Maighdiln', 'Jurczyk', 40), "
    			+ " ('Marlyn', 'Tudhope', 24), "
    			+ " ('Amaleta', 'Sample', 94), "
    			+ " ('Arny', 'MacCorley', 54), "
    			+ " ('Fiona', 'Gamblin', 96), "
    			+ " ('Leone', 'Westphalen', 59), "
    			+ " ('Kamila', 'Cure', 90), "
    			+ " ('Barbi', 'Hinze', 64), "
    			+ " ('Dael', 'Girdlestone', 37), "
    			+ " ('Jackson', 'Basford', 76), "
    			+ " ('Stu', 'Malim', 28), "
    			+ " ('Patrice', 'Loudon', 32), "
    			+ " ('Damian', 'Normanton', 42), "
    			+ " ('Dallis', 'Assante', 25), "
    			+ " ('Corenda', 'Nabbs', 82), "
    			+ " ('Rodina', 'Feehan', 58), "
    			+ " ('Allan', 'Whanstall', 64), "
    			+ " ('Lorettalorna', 'Usher', 32), "
    			+ " ('Gennifer', 'Kellen', 80), "
    			+ " ('Atalanta', 'Chern', 26), "
    			+ " ('Alanna', 'Cooksley', 87), "
    			+ " ('Elliott', 'Rosensaft', 41), "
    			+ " ('Roberto', 'Hubach', 36), "
    			+ " ('Michelina', 'Maylin', 51), "
    			+ " ('Ceil', 'Shallcrass', 68), "
    			+ " ('Lian', 'Amyes', 57), "
    			+ " ('Tanney', 'Dowbekin', 46), "
    			+ " ('Sisile', 'Hopewell', 96);";
    	
    	st.executeUpdate(sql);
    }
    
    
}
	
	


