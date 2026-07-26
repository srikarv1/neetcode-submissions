class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length; 
        int l=0; 
        int r = n-1; 

        List<Integer> res = new ArrayList<>(); 
        while(l<r && r-l+1>k){
            if(Math.abs(arr[l]-x) <= Math.abs(arr[r]-x)){
                r--;
            } else {
                l++;
            }
        }

        for(int i=l;i<=r;++i)
            res.add(arr[i]); 
        
        return res;
    }
}