import java.util.Arrays;
//time complexity is o(n)
//space complexity is o(n)
//use array to keep count of candy at each index
//iterate from left to right side and check current rating is greater than previous rating if yes increase value by 1 of previous value and put it at current index of array
//again iterate from right to left and check current rating with privious rating. if grater check update if max value in between previous value+1 and previous array value.
public class Candy {
    public int candy(int[] ratings) {
        int result =0;
        int[] output = new int[ratings.length]; 
        Arrays.fill(output,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                output[i]=output[i-1]+1;
            }
        }
        
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                output[i]=Math.max(output[i],output[i+1]+1);
            }
        }
        for(int i=0;i<output.length;i++){
            result+=output[i];
        }
        return result;
    }
}
