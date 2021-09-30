package com.lti.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.SSLContext;

import com.lti.daos.StudentDaoimpl;
import com.lti.entities.Student;
import com.lti.utility.ConnectionFactory;

public class Main {

	public static void main(String[] args) {
		Connection c=ConnectionFactory.getConnection();
		try
		{
			
			if(c!=null)
            {
         	   System.out.println("connected");
            }
               
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		finally
//		{
//			try {
//				c.close();
//			} catch (SQLException e) {
//				System.out.println("Connection not closed");
//			}
		
               
               
               
               
               
               Scanner sc=new Scanner(System.in);
               
               
               Student s=new Student();
               StudentDaoimpl sd=new StudentDaoimpl(c);
               while(true)
               {
            	   System.out.println("Enter your choice");
                   System.out.println("1.insert\n2.delete\n3.update\n4.display\n5.get list of students \n6.display 1 student record\n7.exit");
                   int choice=sc.nextInt();
               switch(choice)
               {
               case 1:
               System.out.println("enter the no of records to enter");
               int count=sc.nextInt();
               for(int i=0;i<count;i++)
               {
               System.out.println("enter the sid");
               int id=sc.nextInt();
               sc.nextLine();
               System.out.println("enter your name");
               String name=sc.nextLine();
               s.setSid(id);
               s.setSname(name);
               
               sd.insert(s);
               System.out.println("record inserted");
               }
               break;
               
               
               case 2:
               
               System.out.println("enter the sid to delete the record");
               int id1=sc.nextInt();
               s.setSid(id1);
               sd.delete(s);
               System.out.println("record deleted");
               break;
               
               case 3:
            	   System.out.println("enter the sid to update the name");
            	   int id2=sc.nextInt();
            	   sc.nextLine();
            	   System.out.println("enter the new name");
            	   String name1=sc.nextLine();
            	   s.setSname(name1);
            	   s.setSid(id2);
            	   sd.update(s);
            	   System.out.println("Record updated");
                    break;
               case 4:
            	   System.out.println("records are..........");
            	   sd.display(s);
            	   break;
               case 5:
            	   ArrayList<Student> lst=sd.getAllStudents();
            	   for(Student stu: lst)
            	   {
            		   System.out.println("---------------------------------------");
            		  System.out.println(stu.getSid() + "  "+ "  " + stu.getSname()); 
            	   }
            	   break;
               case 6:
            	   System.out.println("enter the id to display");
            	   int id=sc.nextInt();
            	   Student s1=sd.getStudent(id);
            	   System.out.println(s1.getSid() + "  "+s1.getSname());
            	   break;
            	   
               case 7:
            	   System.out.println("Thank you!!");
            	   System.exit(0);
               }
               }
            	   
               
            	
               }
               
               
	}


