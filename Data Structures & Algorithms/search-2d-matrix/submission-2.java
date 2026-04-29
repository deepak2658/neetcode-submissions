class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int leftR = 0;
        int rightR = matrix.length-1;
        int m = matrix[0].length;

        while(leftR <= rightR){
            int mid = leftR + (rightR - leftR)/2;

            if(target < matrix[mid][0])
                rightR = mid-1;
            else if(target > matrix[mid][m-1])
                leftR = mid+1;
            else{
                leftR = mid;
                break;
            }
        }

        if(leftR == matrix.length) return false; 

        int left = 0;
        int right = m-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(matrix[leftR][mid] > target){
                right = mid-1;
            }else if(matrix[leftR][mid] < target){
                left = mid+1;
            }else {
                return true;
            }
        }

        return false;
    }
}
