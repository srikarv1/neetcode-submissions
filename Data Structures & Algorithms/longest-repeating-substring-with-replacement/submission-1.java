class Solution {
    public int characterReplacement(String s, int k) {
        int[] bucket = new int[26]; 

        int n = s.length(); 
        int j = 0; 
        int res = 0; 
        for(int i=0;i<n;++i){
        bucket[s.charAt(i) - 'A']++;
        while(!possible(bucket,k)){
            bucket[s.charAt(j) - 'A']--; 
            j++;
        }

        res = Math.max(res, i-j+1); 
        }

        return res; 
    }

    private boolean possible(int[] bucket, int k){
        int sum = 0;
        int max = 0; 
        for(int num:bucket){
            sum += num; 
            max = Math.max(max, num); 
        }

        return sum-max <=k;
    }
}
