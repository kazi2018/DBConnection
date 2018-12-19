package dbArrayList;

import reUseDB.ConnectDB;

import java.util.ArrayList;

import java.util.List;

public class UseArrayList {

    public static void main(String[] args) throws Exception {


        ArrayList<Integer> arrList = new ArrayList<>();


        arrList.add(150);
        arrList.add(200);
        arrList.add(300);
        arrList.add(25);
        arrList.add(90);
        arrList.add(500);
        arrList.add(1250);

        List list =  arrList;

        //Connect to MySql Database
        ConnectDB connectDB = new ConnectDB();

        //Create table in the database
        connectDB.createTableFromStringToMySql("array_list","listElement");

        //Insert data in the database
        connectDB.InsertDataFromArrayListToMySql(list,"array_list", "listElement");


        //Read data from database
        List<String> numbers = connectDB.readDataBase("array_list", "listElement");
        for(String st:numbers){
            System.out.println(st);
        }
    }
}
