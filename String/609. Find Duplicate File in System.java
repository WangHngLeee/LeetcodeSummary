/*
Given a list of directory info including directory path, and all the files with contents in this directory,
you need to find out all the groups of duplicate files in the file system in terms of their paths.

Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

 */



class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String,Set<String>> map = new HashMap<>();
        for(String str : paths){
            String[] strs = str.split("\\s++");
            for(int i = 1 ;i<strs.length ;i++){
                int idx = strs[i].indexOf('(');
                String msg = strs[i].substring(idx);
                String totalName = strs[0] + "/" + strs[i].substring(0,idx);
                Set<String> names = map.getOrDefault(msg,new HashSet<>());
                names.add(totalName);
                map.put(msg,names);
            }
        }
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                res.add(new ArrayList<>(map.get(key)));
            }
        }
        return res;
    }
}
/*
T:O(n) S:O(n)

First we split the string with " " to seprate the string with two parts : paths + file.
Then we go to the file part, and find the message in it using "(", we split the file with two part: file name + file message.
Using map and set to store the file like " message -> Set <paths of file> ". Then we add the path in the set to final res list.

 */