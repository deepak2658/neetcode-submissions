class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int[] freq;
        for( String str: strs){
            freq = new int[26];
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < str.length(); i++){
                freq[str.charAt(i) - 'a']++;
            }

            for( int i = 0 ; i < 26; i++){
                sb.append(freq[i] + "#");
            }

            String key = sb.toString();

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for( String key: map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}
