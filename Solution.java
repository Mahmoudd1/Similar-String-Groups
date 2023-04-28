class Solution {
    Set<String>visited;
    public int numSimilarGroups(String[] strs) {
        visited=new HashSet<>();
        int counter=0;
        for (int i=0;i<strs.length;i++)
        {
            if (!visited.contains(strs[i]))
            {
                counter++;
                visited.add(strs[i]);
                dfs(strs , strs[i]);
            }

        }
        return counter;
    }
    void dfs(String [] strs,String parent)
    {
        for (String str:strs )
        {
            if (!visited.contains(str))
            {
                if (isSimilar(parent,str))
                {
                    visited.add(str);
                    dfs(strs,str);
                }
            }
        }
    }
    boolean isSimilar(String a,String b)
    {
        int flag=0;
        for (int i=0;i<a.length();i++)
        {
            if (a.charAt(i)!=b.charAt(i))
            {
                if (flag>1)
                    return false;
                flag++;
            }
        }
        return true;
    }
}
