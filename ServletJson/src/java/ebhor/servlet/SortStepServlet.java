/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebhor.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quangnhse05858
 */
public class SortStepServlet extends HttpServlet {

    
     int selectionSort(int arr[]) {
        int count = 0;
        int n = arr.length;

        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array 
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;

                    // Swap the found minimum element with the first 
                    // element 
                    int temp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = temp;
                    count++;
                }
            }
        }
        return count;
    }
    
    int insertionSort(int arr[]) {
        int count = 0;
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
                count++;
            } 
            arr[j + 1] = key; 
            
        } 
        return count;
    }
    
   

    int bubbleSort(int arr[]) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        return count;
    }
/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AlgoSort algo)
            throws ServletException, IOException {
        Gson gson = new Gson();
        String jsonData = gson.toJson(algo);
        // request.setAttribute(jsonData, jsonData);
        //  request.getRequestDispatcher("jsonjs.js").forward(request, response);
        PrintWriter out = response.getWriter();
        try {
            out.println(jsonData);
        } finally {
            out.close();
        }
    }
*/
  
    private static List<Integer> toList(String json, Gson parser) {
        return parser.fromJson(json, List.class);
    }

    private static int[] toArray(String json, Gson parser) {
        return parser.fromJson(json, int[].class);
    }

    int []tempArray(int []arr) {
        int [] newarr =  new int[arr.length]; 
        
        for(int i= 0; i< arr.length;i++) {
           newarr[i] = arr[i];
           
       }
        return newarr;
    }
    //gọi là jsp 1
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //goi ve cai mang ma duoc js truyen di
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("name");
        Gson parser = new Gson();
        int[] jsFileArray = toArray(json, parser);
        
     
        //  System.out.println(Arrays.toString(arr)); // prints [1, 2, 3, 4]

        // List<Integer> list = toList(json, parser);// prints [1.0, 2.0, 3.0, 4.0], not integer values
        //  System.out.println(list.toString());
        // Again, let's convert this Java int array back to Json numeric array
        int bbStep = bubbleSort(tempArray(jsFileArray));         
        int ssStep = selectionSort(tempArray(jsFileArray));   
        int insStep = insertionSort(tempArray(jsFileArray));     
        AlgoSort algo = new AlgoSort("Bubble Sort", bbStep);      
       AlgoSort algo2 = new AlgoSort("Selection Sort",ssStep );
       AlgoSort algo3 = new AlgoSort("Insertion Sort", insStep);
       
       ArrayList<AlgoSort> listAlgo = new ArrayList<AlgoSort>();
       listAlgo.add(algo);
       listAlgo.add(algo2);
       listAlgo.add(algo3);
       
        
        String jsonData = parser.toJson(listAlgo);
        
        PrintWriter out = response.getWriter();
        try {
            out.println(jsonData);
        } finally {
            out.close();
        }
    
    }
   
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
