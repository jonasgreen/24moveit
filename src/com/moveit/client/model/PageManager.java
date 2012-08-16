package com.moveit.client.model;

import com.moveit.client.SystemException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PageManager {


    private static int PAGE_SIZE = 50;
    private List<Route> allRoutes = new ArrayList<Route>();


    public PageManager(List<Route> routes) {
        this.allRoutes = routes;
    }

    //start at page 1.
    public List<Route> getPage(int page){
        if(page == 0){
            throw new SystemException("Pages start at 1 not 0.");
        }
        int startIndex = (page*PAGE_SIZE) - PAGE_SIZE;
        int endIndex = (page*PAGE_SIZE);

        List<Route> list = new ArrayList<Route>();

        while (startIndex <endIndex){
            list.add(allRoutes.get(startIndex++));
            if(allRoutes.size() == startIndex){
                return list;
            }
            
        }
        return list;
    }

    public int getNumberOfPages(){
        int modulus = allRoutes.size()%PAGE_SIZE;
        return allRoutes.size()/PAGE_SIZE + (modulus == 0 ? 0 : 1);
    }












    //lidt test

    public static void main(String[] args){

          PageManager pm = new PageManager(getList(50));
          System.out.println(pm.getNumberOfPages());

          pm = new PageManager(getList(0));
          System.out.println(pm.getNumberOfPages());

          pm = new PageManager(getList(51));
          System.out.println(pm.getNumberOfPages());

          pm = new PageManager(getList(200));
          System.out.println(pm.getNumberOfPages());

          pm = new PageManager(getList(201));
          System.out.println(pm.getNumberOfPages());

        System.out.println(pm.getPage(5).size());
        System.out.println(pm.getPage(4).size());
        System.out.println(pm.getPage(3).size());
        System.out.println(pm.getPage(2).size());
        System.out.println(pm.getPage(1).size());  

      }


    private static List<Route> getList(int number){
         int i = 0;

        List<Route> list = new ArrayList<Route>();
        while(i++ < number){
            list.add(new Route());
        }
        return list;
    }



}
