//time complexity is o(n)
//space complexity is o(1)
//idea is count maxFrequency of task and calculate no of task which has maxFrequency
//task is to find no of ideal slot. return no of ideal slot + total slots.
//calculate parameter to  find no of ideal slots.
/*1 no of places=maxFrequency-1;
2. empty places=NoOfPlaces*(n-(countOfMaxFrequency-1));
3. available places
4.ideal slot = empty places - available places*/

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int maxFrequency =0;
        int countOfMaxFrequency =0;
        int[] counter = new int[tasks.length];
        for(char task: tasks){
            counter[task- 'A']++;
            if(counter[task-'A']== maxFrequency){
                countOfMaxFrequency++;
            }else if(maxFrequency<counter[task-'A']){
                maxFrequency = counter[task-'A'];
                countOfMaxFrequency=1;
            }
        }
        int NoOfPlaces = maxFrequency-1;
        int emptyPlaces = NoOfPlaces*(n-(countOfMaxFrequency-1));
        int availablePlaces = tasks.length -(maxFrequency *countOfMaxFrequency);
        int idleSlot = Math.max(0,emptyPlaces- availablePlaces);
        return tasks.length+idleSlot;
    }
}
