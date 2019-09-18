import java.sql.*;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 18/09/2019
 * DataBaseApp
 *
 */

public class DataBaseApp {


    public static void main(String[] args) {

        System.out.println("Display data for all classes\n");
        displayAllClasses();

        System.out.println("\nDisplay data for a course with specified id\n");
        displayDatesByID();

        System.out.println("\nDisplay data for all classes whose title (when converted to all lowercase letters) begins with intro\n");
        displayAllClassesBeginsWithIntro();

        System.out.println("\nDisplay data for all classes whose dept (when converted to all lowercase letters) is \"cos\" and whose coursenum begins with \"3\"\n");
        displayAllClassesDeptCos();

        System.out.println("\nDisplay data for all classes whose profname (when converted to all lowercase letters) begins with \"cos\"\n");
        displayAllClassesProfNameCos();


    }


    /**
     * Display data for all classes
     */
    public static void displayAllClasses() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "user");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        final String format = "|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes ");

            while(rs.next()){
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("course_id");
                int days = rs.getInt("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Display data for a course with specified id
     */

    public static void displayDatesByID() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "user");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        final String format = "|%10s|%10s|%10s|%10s|%10s|\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from courses where courseid =3 ");

            while(rs.next()){
                int courseid = rs.getInt("courseid");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                String prereqs = rs.getString("prereqs");
                System.out.format(format, courseid, area, title, descrip, prereqs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Display data for all classes whose title (when converted to all lowercase letters) begins with "intro".
     */

    public static void displayAllClassesBeginsWithIntro() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "user");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        final String format = "|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%20s|%10s|%10s|\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes left join courses on course_id = courses.courseid  where lower(title) like'%intro%'");

            while(rs.next()){
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("course_id");
                int days = rs.getInt("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                String prereqs = rs.getString("prereqs");
                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum,area, title, descrip, prereqs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
    /**
     * Display data for all classes whose dept (when converted to all lowercase letters) is "cos" and whose coursenum begins with "3"
     */
    public static void displayAllClassesDeptCos() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "user");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        final String format = "|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%20s|\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes, crosslistings where classes.course_id = " +
                    "crosslistings.course_id and lower(dept) like '%cos%' and coursenum like '%3%' ");

            while(rs.next()){
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("course_id");
                int days = rs.getInt("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                String dept = rs.getString("dept");
                String coursenum = rs.getString("coursenum");
                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum, dept, coursenum );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Display data for all classes whose profname (when converted to all lowercase letters) begins with "cos".
     */

    public static void displayAllClassesProfNameCos() {
        Connection conn = getConnection("mysql", "localhost", "3306", "school", "root", "user");
        if (conn == null) return;

        Statement st = null;
        ResultSet rs = null;
        final String format = "|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%20s|\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes, profs, coursesprofs where profs.profid = coursesprofs.profid and " +
                    "classes.course_id = coursesprofs.course_id and lower(profname) like '%cos%'");

            while(rs.next()){
                int classid = rs.getInt("classid");
                int courseid = rs.getInt("course_id");
                int days = rs.getInt("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                int roomnum = rs.getInt("roomnum");
                int profid = rs.getInt("profid");
                String profname = rs.getString("profname");
                System.out.format(format, classid, courseid, days, starttime, endtime, bldg, roomnum, profid, profname );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }



    /**
     * Connect to the Database
     * @param dbType
     * @param host
     * @param port
     * @param dbName
     * @param username
     * @param password
     * @return
     */

    public static Connection getConnection(String dbType, String host, String port, String dbName, String username, String password) {
        Connection conn = null;
        DriverManager.setLoginTimeout(60);
        try {
            StringBuilder connectionUrl = new StringBuilder();
            connectionUrl.append("jdbc:");
            connectionUrl.append(dbType);
            connectionUrl.append("://");
            connectionUrl.append(host);
            connectionUrl.append(":");
            connectionUrl.append(port);
            connectionUrl.append("/");
            connectionUrl.append(dbName);
            connectionUrl.append("?user=");
            connectionUrl.append(username);
            connectionUrl.append(("&password="));
            connectionUrl.append(password);

            return DriverManager.getConnection(connectionUrl.toString());

        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return conn;
    }
}

