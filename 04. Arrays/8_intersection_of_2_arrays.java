import java.util.*;

class PI{

public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B){
    
    ArrayList<Integer> ans=new ArrayList<>();

  // to maintain visited 
  int visited[]=new int[B.length]; 
 
  for (int i = 0; i < A.length; i++) {
    for (int j = 0; j < B.length; j++) {

      if (A[i] == B[j] && visited[j] == 0) { 
    
        //if element matches and has not been matched with any other before
        ans.add(B[j]);
        visited[j] = 1;

        break;
      } else if (B[j] > A[i]) break; 
       //because array is sorted , element will not be beyond this
    }
  }
  return ans;
}    

public static void main(String args[]) 
{
  // Array Initialisation.
  int A[]= {1,2,3,3,4,5,6,7};
  int B[]= {3,3,4,4,5,8};

  ArrayList<Integer> ans= intersectionOfArrays(A,B);
  
  for (int i = 0; i < ans.size(); i++) {
    System.out.print(ans.get(i)+" ");
  }

}
}
