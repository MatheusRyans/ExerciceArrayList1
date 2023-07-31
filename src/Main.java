import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employes;


public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employes> list = new ArrayList<>();

        System.out.print("How many employess will be registered?");
        int quantityEmployees = sc.nextInt();

        for (int i = 0; i < quantityEmployees; i++){

            System.out.println("Employee #"+ (i + 1)+ ":");
            System.out.print("ID: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employes emp = new Employes(name,id, salary);

            list.add(emp);
        }

        System.out.println("Enther the employee id that will have salary increase :");
        int idSalary = sc.nextInt();
        Integer pos = position(list, idSalary);
        if (pos == null){
            System.out.println("This ID does not exist ! ");
        }
        else{
            System.out.println("Enter the porcentage: ");
            Double percent = sc.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of Employees: ");
        for(Employes emp : list) {
            System.out.println(emp);
        }


        sc.close();
    }

    //aqui eu crio uma função auxiliar para encontrar a posição do ID na lista, caso ele não encontre ele volta como nulo
    public static Integer position(List<Employes> list , int id){
        for(int i = 0 ; i < list.size(); i++){
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
}