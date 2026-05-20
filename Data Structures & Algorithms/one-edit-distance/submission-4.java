class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenA = s.length();
        int lenB = t.length();
        
        if( s.length() == 0 && t.length() == 0)
            return false;

        if(Math.abs(lenA-lenB)>=2)
            return false;

        int operationCount = 0;
        int i = 0;
        int j = 0;

        while( i < lenA && j < lenB){
            if(s.charAt(i) != t.charAt(j)){
                if(operationCount > 1)
                    return false;

                if( lenA > lenB)
                    i++;
                else if( lenB > lenA)
                    j++;
                else {
                    i++;
                    j++;
                }

                operationCount++;
            }else {
                i++;
                j++;
            }
        }

        operationCount += (lenA-i) + (lenB-j);
        return operationCount == 1;
    }
}
