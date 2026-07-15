class Solution {
    /*
        string s,
        List<String> wordDict;

        bf:
            State:
                HashSet<String> words;

                backtrack(s, int start, List<String> path){
                    int n = s.length();
                    if(start == n+1){
                        StringBuilder sb = new StringBuilder();
                        for(String ele: path){
                            sb.append(ele);
                        }
                        res.add(sb.toString().substring(0, sb.length()-1));
                    }

                    for(int i = start+1; i <= n; i++){
                        String str = s.substring(start, i);

                        if(words.contains(str)){
                            path.add(str);
                            path.add(" ");

                            bracktrack(s, i, path);

                            path.remove(path.size()-1);
                            path.remove(path.size()-1);
                        }
                    }

                }
    */

    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        res =new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), words);

        return res;
    }

    void backtrack(String s, int start, List<String> path, HashSet<String> words){
        int n = s.length();
        if(start == n){
            StringBuilder sb = new StringBuilder();
            for(String ele: path){
                sb.append(ele);
            }
            res.add(sb.toString().substring(0, sb.length()-1));
        }

        for(int i = start+1; i <= n; i++){
            String str = s.substring(start, i);

            if(words.contains(str)){
                path.add(str);
                path.add(" ");

                backtrack(s, i, path, words);

                path.remove(path.size()-1);
                path.remove(path.size()-1);
            }
        }

    }

}







