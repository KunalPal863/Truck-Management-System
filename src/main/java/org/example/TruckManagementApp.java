package org.example;

import java.util.List;
import java.util.Scanner;

public class TruckManagementApp
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        TruckService truckService = new TruckService();
        //adding into the database

        System.out.println("Enter (1) if you want to insert data in database");
        int ch = scan.nextInt();
        while(ch == 1)
        {
            System.out.println("--------------> Enter the truck details <-------------");
            System.out.println("Enter the Truck name ");
            String truck_name  = scan.next();
            System.out.println("Enter the Driver name");
            String driver_name  = scan.next();
            System.out.println("Enter the  Model ");
            String model  = scan.next();
            System.out.println("Enter the Capacity");
            String cap  = scan.next();

            Truck t1 = new Truck(truck_name,driver_name,model,cap);

            //Adding data into database
            truckService.addTruck(t1);

            System.out.println("If you want to add more trucks then enter (1) ");
            ch = scan.nextInt();

        }
        int n;
        do
        {
            System.out.println(" 1. Fetch truck by Id \n 2. Fetch all Trucks \n 3. Update truck by Id \n 4. Delete truck by ID");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the Id of the truck");
                    int truckId = scan.nextInt();
                    Truck truck = truckService.getTruckById(truckId);
                    System.out.println("Truck Details ...... \n" + truck);
                    break;
                case 2:
                    System.out.println("Fetching All Data of Truck .......");
                    List<Truck> truckList = truckService.getTruckList();
                    for(Truck truck1 : truckList)
                    {
                        System.out.println(truck1);
                    }
                    break;
                case 3:
                    System.out.println("Enter the truck Id");
                    int updateId = scan.nextInt();
                    Truck truck2 = truckService.getTruckById(updateId);
                    System.out.println(" 1. Update Truck Name \n 2. Update Driver Name \n 3. Update Model \n 4. Update Capacity");
                    int updateChoice = scan.nextInt();
                    switch(updateChoice)
                    {
                        case 1:
                            System.out.println("Enter the truck name ");
                            String truckName = scan.next();
                            truck2.setDname(truckName);
                            truckService.updateTruck(truck2);
                            System.out.println("Updated truck data : "+truckService.getTruckById(updateId));
                            break;
                        case 2:
                        System.out.println("Enter the Driver name ");
                            String driver = scan.next();
                            truck2.setDname(driver);
                            truckService.updateTruck(truck2);
                            System.out.println("Updated truck data : "+truckService.getTruckById(updateId));
                            break;
                        case 3:
                            System.out.println("Enter the Model ");
                            String model = scan.next();
                            truck2.setDname(model);
                            truckService.updateTruck(truck2);
                            System.out.println("Updated truck data : "+truckService.getTruckById(updateId));
                            break;
                        case 4:
                            System.out.println("Enter the Capacity ");
                            String capacity = scan.next();
                            truck2.setDname(capacity);
                            truckService.updateTruck(truck2);
                            System.out.println("Updated truck data : "+truckService.getTruckById(updateId));
                            break;
                        default:
                            System.out.println("Invalid Choice ");
                    }
                    break;
                case 4:
                    System.out.println("Enter the Truck Id");
                    int deleteId = scan.nextInt();
                    System.out.println("Deleting data by ID = "+ deleteId);
                    Truck truck3 = truckService.getTruckById(deleteId);
                    truckService.deleteTruck(truck3.getId());
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println(" ======= DO YOU WANT TO AGAIN ======== ");
            System.out.println("ENTER 1");
            n = scan.nextInt();
        }
        while(n == 1);
        System.out.println("<--------------->>>>>> THANK YOU <<<<<<<---------------->");
    }
}
