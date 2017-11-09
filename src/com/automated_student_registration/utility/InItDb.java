import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author A30
 	change user, pass ,db_url according to your details
 	be sure you have set jdbc driver path on your class path of system
 *
 */


public class InItDb {

	public static String USER = "root";
 	public static String PASS = "root";
 	static Connection conn;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static PreparedStatement ps = null;
	static String sql = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		try {
				Class.forName(JDBC_DRIVER);
				conn=DriverManager.getConnection(DB_URL, USER, PASS);
				if(conn!=null)
				{

					System.out.println("database connected");
	
					conn.prepareStatement("drop database asrs").executeUpdate();

					System.out.println("asrs database drop");
	
					ps=conn.prepareStatement("create database asrs");
					ps.executeUpdate();
					System.out.println("database  asrs created");
					ps=conn.prepareStatement("use asrs");
					ps.executeUpdate();
					System.out.println("in asrs");
					sql = "create table student(id int not null unique auto_increment ,"
							+ "sid varchar(5) primary key default 's' ,email varchar(50) unique ,"
							+ "ph_no varchar(10),"
							+ "fname varchar(20) not null,  "
							+ "mname varchar(20),"
							+ "lname varchar(20),"
							+ "gender varchar(1) not null,"
							+ "address varchar(200))";
							ps=conn.prepareStatement(sql);
					ps.executeUpdate();
					System.out.println("student table created");


					sql="create table emp( id int not null unique auto_increment,"
					+"eid varchar(5) primary key default 'e',"
					+"fname varchar(20) not null,  "
					+"mname varchar(20),"
					+"lname varchar(20),"
					+"pass varchar(1000) not null,"
					+"address varchar(1000), "
					+"email varchar(100),"
					+"ph_no varchar(10),"
					+"designation varchar(20))";

					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
					System.out.println(" employee table created");

					sql="create table course_details(id int not null unique auto_increment,"
					+"cid varchar(5) primary key default 'c',"
					+"course_name varchar(20) not null,"
					+"duration int not null,"
					+"start_date date not null,"
					+"end_date  date not null default '2012-12-12',"
					+"capacity int not null,"
					+"faculty varchar(5) ,"
					+"course_fee int not null," 
					+"foreign key(faculty) references emp(eid))";

					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
					System.out.println("course_details table created");	

					

					sql="create table course("
					+"cid varchar(5) not null ,"
					+"sid varchar(5) not null ,"
					+"faculty varchar(5) not null ,"
					+"primary key (cid,sid),"
					+"foreign key (faculty) references emp(eid) ,"
					+"foreign key (cid) references course_details(cid) ,"
					+"foreign key (sid) references student(sid) )";
					


					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
					System.out.println("course table created");
				}
				conn.close();

			}catch (SQLException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
	}

}
