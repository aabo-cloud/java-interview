package com.luogu.rm.P2649;

import java.util.*;

/**
 * @program: java-interview
 * @description: P2649 游戏预言 提交 4.29k 通过 2.60k 时间限制 1.00s 内存限制 128.00MB 提交答案
 * @author: aabo
 * @create: 2024-08-17 10:58
 **/
public class Main {

    public static Integer result = 0;

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        int[] myCards = new int[n + 1];
        Set<Integer> myCardSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            myCards[i] = cin.nextInt();
            myCardSet.add(myCards[i]);
        }
        int[] otherCards = new int[n + 1];
        int j = 1;
        for (int i = m * n; i >= 1; i--) {
            if (myCardSet.contains(i)) {
                continue;
            }
            otherCards[j++] = i;
            if (j > n) {
                break;
            }
        }
        Arrays.sort(myCards);
//        System.out.println(Arrays.toString(myCards));
//        System.out.println(Arrays.toString(otherCards));

        int myPos = n;
        int otherPos = 1;
        int endPos = n;
        while (myPos >= 1 && otherPos <= endPos) {
            if (myCards[myPos] > otherCards[otherPos]) {
                result++;
                endPos--;
            } else {
                otherPos++;
            }
            myPos--;
        }

//        System.out.println("finish input");
//        dfs(n, m, visited, myCardSet, new ArrayList<>());

        System.out.println(result);
    }

    private static void dfs2(int n, int m,  boolean[] visited, Set<Integer> myCardSet, List<Integer> item) {
        if (item.size() == n * m) {
//            System.out.println(item);
            result = Math.min(result, winCnt(m, item));
            return;
        }
        for (int i = 1; i <= n * m; i++) {
            if (visited[i]) {
                continue;
            }
            if (item.size() % m == 0 && !myCardSet.contains(i)) {
                continue;
            }
            item.add(i);
            visited[i] = true;
            dfs(n, m, visited, myCardSet, item);
            visited[i] = false;
            item.remove(item.size() - 1);
        }
    }


    private static void dfs(int n, int m,  boolean[] visited, Set<Integer> myCardSet, List<Integer> item) {
        if (item.size() == n * m) {
//            System.out.println(item);
            result = Math.min(result, winCnt(m, item));
            return;
        }
        for (int i = 1; i <= n * m; i++) {
            if (visited[i]) {
                continue;
            }
            if (item.size() % m == 0 && !myCardSet.contains(i)) {
                continue;
            }
            item.add(i);
            visited[i] = true;
            dfs(n, m, visited, myCardSet, item);
            visited[i] = false;
            item.remove(item.size() - 1);
        }
    }

    private static int winCnt(int m, List<Integer> item) {

        int win = 0;
        for (int i = 0; i < item.size(); i += m) {
            int start = i;
            int end = i + m;
            int max = item.get(start);
            for (int j = start + 1; j < end; j++) {
                if (item.get(j) > max) {
                    max = item.get(j);
                    break;
                }
            }
            if (max == item.get(start)) {
                win++;
            }
        }

        return win;
    }

}


//#include<cstdio>
//#include<cstring>
//using namespace std;
//        int a[1005],b[1005];
//        int main()
//        {
//        int n,m,ans=0,sum=0;
//        scanf("%d%d",&m,&n);
//        for(int i=1;i<=n;i++)
//        {
//        scanf("%d",&a[i]);
//        b[a[i]]=1;
//        }
//        for(int i=n*m;i>=1;i--)//让大牌在上，从大往小搜。
//        {
//        if(b[i]==0)sum++;//如果这张牌不是他的，就可以抵掉她的一张小牌，就让计可以的sum++。
//        else if(sum>0)sum--;//如果这张牌是他的，就可以抵掉她的一张小牌，但这张牌也废了，sum--。
//        else ans++;//如果这张牌是他的，并且没有更大的牌能抵掉它，ans++。
//        }
//        printf("%d",ans);
//        }