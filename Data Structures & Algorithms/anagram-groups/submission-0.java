class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String curr: strs){
            List<Integer> freq = new ArrayList<>();
            for(int i = 0; i < 26; i++)
                freq.add(0);

            for(int i = 0; i < curr.length(); i++){
                char ch = curr.charAt(i);

                int currFreq = freq.get(ch - 'a');

                freq.set(ch-'a', currFreq+1);
            }

            String key = freq.toString();

            if(map.containsKey(key)){
                map.get(key).add(curr);
            } else {
                List<String> inner = new ArrayList<>();
                inner.add(curr);
                map.put(key, inner);
            }
        }

        // System.out.println(map);
        List<List<String>> res = new ArrayList<>();

        for(String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}
