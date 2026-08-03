class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] ps = new int[position.length][2];

        int n = position.length; 

        for(int i=0; i<n; ++i){
            ps[i][0] = position[i]; 
            ps[i][1] = speed[i]; 
        }

        Arrays.sort(ps, (a,b) -> a[0]-b[0]); 

        Stack<Float> stack = new Stack<>(); 

        for(int[] metric : ps){
            int pos = metric[0]; 
            int spd = metric[1]; 

            float timeTaken = (float)((float)(target-pos)/spd); 
            System.out.println(timeTaken); 

            while(!stack.isEmpty() && timeTaken >= stack.peek()){
                stack.pop(); 
            }

            stack.push(timeTaken); 
        } 

        return stack.size(); 
    }
}
