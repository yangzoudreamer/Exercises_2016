package DP;

/*最长回文子串，三种方法
1，DP将dp[i][j]表示String[i...j]?=true是否是回文,可以看出dp[i][j]左右假如对称，则有d[i-1][j+1] == d[i][j],时间空间都是o(n^2)
2，马拉车算法，时间空间都是o(N)，见hiho1032
3，对每个字符进行左右判断，时间O(N^2),空间o(1)*/
public class longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1)return s;
        boolean[][] dp = new boolean [len][len];//dp[i][j]表示s[i..j]是否是回文
        int resLeft = 0, resRight = 0;
        dp[0][0] = true;
        for(int i = 1; i < len; i++)
        {
            dp[i][i] = true;
            dp[i][i-1] = true;//这个初始化容易忽略，当k=2时要用到
        }
        for(int k = 2; k <= len; k++)//枚举子串长度
            for(int i = 0; i <= len-k; i++)//枚举子串起始位置
            {
                if(s.charAt(i) == s.charAt(i+k-1) && dp[i+1][i+k-2])
                {
                    dp[i][i+k-1] = true;
                    if(resRight-resLeft+1 < k)
                    {
                        resLeft = i;
                        resRight = i+k-1;
                    }
                }
            }
        return s.substring(resLeft, resRight+1);
    }
}
