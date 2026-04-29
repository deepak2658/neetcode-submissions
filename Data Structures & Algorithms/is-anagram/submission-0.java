class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int[] sfreq= new int[26];
        int[] tfreq = new int[26];

        for(int i = 0; i < t.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            sfreq[sChar-'a']++;
            tfreq[tChar - 'a']++;
        }

        for(int i =0; i < 26; i++)
            if(sfreq[i]!=tfreq[i])
                return false;

        return true;
    }
}
