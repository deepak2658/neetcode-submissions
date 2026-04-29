class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String curr: strs){
            int length = curr.length();
            res = res + length + "#" + curr;
        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()){

            int j = i;

            while(str.charAt(j) != '#')
                j++;

            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j+1, j+1+len);

            res.add(word);

            i = j + 1 + len;
        }

        return res;
    }
}
