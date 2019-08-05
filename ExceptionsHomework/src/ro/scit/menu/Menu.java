package ro.scit.menu;

import ro.scit.comparators.StudentNameComparator;
import ro.scit.entities.Student;
import ro.scit.enums.GenderEnum;
import ro.scit.utilities.DateOfBirth;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Georgiana
 * Menu Class
 *
 */

public class Menu {

    //   SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    Scanner sc = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();
    Student student = new Student();
    public void display() {
        int selection = 0;
        while (selection != 5) {
            System.out.println(
                    "Select an option: \n" +
                            "  1) Add student\n" +
                            "  2) Delete student\n" +
                            "  3) retrieve all students with Age ... \n" +
                            "  4) list students order by Last Name \n" +
                            "  5) Exit\n "
            );
            selection = sc.nextInt();
            sc.nextLine();
            switch (selection) {
                case 1:
                    System.out.println("Insert the CNP");
                    String cnp = sc.nextLine();
                    System.out.println("Insert student's first name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Insert student's last name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Insert student's date of birth: ");
                    //String str = sc.nextLine();
                    try {
                        System.out.print("Enter month: ");
                        int month = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter day: ");
                        int day = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter year: ");
                        int year = Integer.parseInt(sc.nextLine());
                        DateOfBirth birthDate = new DateOfBirth(month, day, year);
                        System.out.println("Date of birth is : " + birthDate);
                        LocalDate currentDate = LocalDate.now();
                        System.out.println("The age is : " );
                        int age = DateOfBirth.calculateAge(birthDate, currentDate );
                        System.out.println(age);
                        System.out.println("Insert the gender: male or female");
                        String gender = sc.next();
                        if (gender.equalsIgnoreCase("male")) {
                            student.setGender(GenderEnum.MALE.getGender());
                        } else if (gender.equalsIgnoreCase
                                ("female")) {
                            student.setGender(GenderEnum.FEMALE.getGender());
                        } else {
                            System.out.println("Invalid option! Please try again.");
                        }
                        Student student1 = new Student(cnp,firstName, lastName, birthDate, age, gender);
                        addStudent(student1);
                        System.out.println("Your Student has been added");
                    }catch (NumberFormatException e){
                        System.err.println("Please insert a number");
                    }

//                    try {
//                        Date date = sdf.parse(str);
//                        sdf = new SimpleDateFormat("dd.MM.yyyy");
//                        System.out.println("Date of birth: " + sdf.format(date));
//                    } catch (ParseException e) {
//                        System.out.println("Parse Exception");
//                    }


                    break;
                case 2:
                    System.out.println("Insert the student's cnp");
                    String cnp1 = sc.nextLine();
                    deleteStudent(cnp1);
                    System.out.println("The student has been deleted! ");

                    break;
                case 3:
                    System.out.println("Insert the age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.println("all students with age " + age + " : ");
                    retrievebyAge(age);
                    break;
                case 4:
                    System.out.println("List Sorted by name");
                    StudentNameComparator nameCompare = new StudentNameComparator();
                    Collections.sort(studentList, nameCompare);
                    for (Student s: studentList)
                        System.out.println(s);
                    break;
                case 5:
                    this.exit();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;

            }
        }
    }

    private void exit () {
        System.out.println("Exiting...");
        System.exit(1);

    }

    //Add students in list
    public  boolean addStudent (Student student){
        if( student.getFirstName().isEmpty() || student.getLastName().isEmpty()){
            throw new IllegalArgumentException("The first name or last name should not be empty!");
        }else {
            studentList.add(student);
            return true;
        }
    }
    //Remove students from list
    public  boolean deleteStudent (String cnp){
        if( cnp.isEmpty()){
            throw new IllegalArgumentException("The cnp should not be empty!");
        }else {
            Iterator<Student> iterator = studentList.iterator();
            while(iterator.hasNext()) {
                Student student = iterator.next();
                if (cnp.contentEquals(student.getCnp())) {
                    iterator.remove();
                }
            }
            return true;
        }
    }
    //display all students by a given age
    public boolean retrievebyAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("The cnp should not be 0 or a negative number!");
        } else{
            for (Student student: studentList)
                if(age == student.getAge()) {
                    System.out.println(student.getLastName()+ "  " + student.getLastName()+ " " + student.getBirthDate());
                }
        }
        return true;
    }

}
