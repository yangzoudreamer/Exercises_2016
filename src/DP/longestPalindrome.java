package DP;

/*������Ӵ������ַ���
1��DP��dp[i][j]��ʾString[i...j]?=true�Ƿ��ǻ���,���Կ���dp[i][j]���Ҽ���Գƣ�����d[i-1][j+1] == d[i][j],ʱ��ռ䶼��o(n^2)
2���������㷨��ʱ��ռ䶼��o(N)����hiho1032
3����ÿ���ַ����������жϣ�ʱ��O(N^2),�ռ�o(1)*/
public class longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1)return s;
        boolean[][] dp = new boolean [len][len];//dp[i][j]��ʾs[i..j]�Ƿ��ǻ���
        int resLeft = 0, resRight = 0;
        dp[0][0] = true;
        for(int i = 1; i < len; i++)
        {
            dp[i][i] = true;
            dp[i][i-1] = true;//�����ʼ�����׺��ԣ���k=2ʱҪ�õ�
        }
        for(int k = 2; k <= len; k++)//ö���Ӵ�����
            for(int i = 0; i <= len-k; i++)//ö���Ӵ���ʼλ��
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
