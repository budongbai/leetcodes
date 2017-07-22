package qunar;
/**
 * @author budongbai
 * @version 2017年9月14日上午9:44:04
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Network {
    private Set<Userinfo> users; // 该社交网络中的所有用户
    int P;// 好友推荐阈值P
    int m;// 创建用户数量m
    int M;// 增加指定两个用户之间的好友关系数量M
    int n;// 查询某个用户的好友数量n
    int N;// 查询指定两个用户是否是好友N字符串

    public Network() {
        users = null;
    }

    public static void main(String[] args) {
        Network network = new Network();
        network.initial();
    }

    public void initial() {
        Scanner scan = new Scanner(System.in);
        P = scan.nextInt();
        m = scan.nextInt();
        M = scan.nextInt();
        n = scan.nextInt();
        N = scan.nextInt();
        for (int i = 0; i < m; i++) {// 添加了m个用户
            String uname = scan.next();
            addUserinfo(new Userinfo(uname));
        }
        for (int i = 0; i < M; i++) {// 添加了M个用户关系
            String r1 = scan.next();
            String r2 = scan.next();
            addRelation(findByName(r1), findByName(r2));
        }
        initialCount();
        // print();
        // check();
        print();
        int[] nn = new int[n]; // 存储好友数量
        for (int i = 0; i < n; i++) {// n个用户的好友数量
            String uname = scan.next();
            nn[i] = findByName(uname).getFriendCount();
        }
        int[] nN = new int[N];
        for (int i = 0; i < N; i++) {// 判断这几组是否好友
            String s1 = scan.next();
            String s2 = scan.next();

        }
        for (int i = 0; i < n; i++) {
            System.out.println(nn[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(nN[i]);
        }
    }

    /**
     * 添加用户
     *
     * @param userinfo
     */
    public void addUserinfo(Userinfo userinfo) {
        if (users == null) {
            users = new HashSet<Userinfo>();
        }
        users.add(userinfo);
    }

    /**
     * 添加好友关系
     *
     * @param userinfo
     * @param userinfo2
     */
    public void addRelation(Userinfo userinfo, Userinfo userinfo2) {
        userinfo.addFriend(new Friend(userinfo2));
        userinfo2.addFriend(new Friend(userinfo));
    }

    /**
     * 获取两个用户之间公共好友数目
     *
     * @param userinfo
     * @param userinfo2
     * @return
     */
    public int getCommonCount(Userinfo userinfo, Userinfo userinfo2) {
        int count = 0;
        Set<Friend> friends = userinfo.getFriends();
        Set<Friend> friends2 = userinfo2.getFriends();
        //System.out.println(friends2+"\n"+friends);
        //System.out.println("-----------------------------------------------");
        if (friends != null && friends != null)
            for (Friend friend : friends) {
                // System.out.println(userinfo2.getUname()+"的好友们"+friends2+"包含"+friend+":"+friends2.contains(friend));
                if (friends2.contains(friend)) {
                    count++;
                }
            }
        return count;
    }

    /**
     * 初始化好友之间的公共好友数目
     */
    public void initialCount() {
        List<Userinfo> list = new ArrayList<Userinfo>();
        for (Userinfo userinfo : users) {
            list.add(userinfo);
        }
        int countP = 1;
        while (countP != 0) {//只要在循环里面添加了关系都要重新从头更新一遍
            countP = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    Userinfo userinfo = list.get(i);
                    Userinfo userinfo2 = list.get(j);
                    int commonCount = getCommonCount(userinfo, userinfo2);
                    //System.out.println(userinfo2.getUname() + ","
                    //		+ userinfo.getUname() + "公共好友：" + commonCount);

                    if (commonCount >= P) {
                        if (isFriend(userinfo, userinfo2) != 0) {// 不是朋友的时候
                            addRelation(userinfo, userinfo2);
                            countP++;
                        }
                    }
                }
            }


        }

    }

    /**
     * 根据用户名获取用户
     *
     * @param uname
     * @return
     */
    public Userinfo findByName(String uname) {
        for (Userinfo userinfo : users) {
            if (userinfo.getUname().equals(uname)) {
                return userinfo;
            }
        }
        return null;
    }

    /**
     * 判断两用户是否好友
     *
     * @param u1
     * @param u2
     * @return
     */
    public int isFriend(String u1, String u2) {
        return isFriend(findByName(u1), findByName(u2));
    }

    /**
     * 判断两用户是否好友
     *
     * @param userinfo
     * @param userinfo2
     * @return
     */
    public int isFriend(Userinfo userinfo, Userinfo userinfo2) {
        return userinfo.isFriend(userinfo2);
    }

    public void print() {
        for (Userinfo userinfo : users) {
            System.out.println(userinfo);
        }
    }

    public Set<Userinfo> getUsers() {
        return users;
    }

    public void setUsers(Set<Userinfo> users) {
        this.users = users;
    }

}

class Userinfo { // 用户,相当于节点
    private String uname; // 用户名
    private Set<Friend> friends; // 邻接点们

    public Userinfo(String uname) {
        super();
        this.uname = uname;
        friends = null;
    }

    /**
     * 添加好友
     *
     * @param friend
     */
    public void addFriend(Friend friend) {
        if (friends == null) {
            friends = new HashSet<Friend>();
        }
        friends.add(friend);
    }

    /**
     * 获取好友数量
     *
     * @return
     */
    public int getFriendCount() {
        if (this.friends != null)
            return this.friends.size();
        return -1;
    }

    /**
     * 当前用户与userinfo是否为好友
     *
     * @param userinfo
     * @return
     */
    public int isFriend(Userinfo userinfo) {
        for (Friend friend : friends) {
            if (friend.getUserinfo().equals(userinfo)) {
                return 0;
            }
        }
        return -1;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Userinfo))
            return false;
        Userinfo user = (Userinfo) obj;
        if (!user.getUname().equals(this.uname))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int length = this.uname.length();
        for (int i = 0; i < this.uname.length(); i++) {
            char ch = this.uname.charAt(i);
            length = length + i * (int) ch;
        }
        return length;
    }

    @Override
    public String toString() {
        return "Userinfo [" + uname + ", " + friends + "]";
    }

}

class Friend {
    private Userinfo userinfo; // 与userinfo的关系
    private int count; // 公共好友个数

    public Friend(Userinfo u2) {
        this.userinfo = u2;
        this.count = 0;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((userinfo == null) ? 0 : userinfo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        Friend other = (Friend) obj;
        if (!userinfo.equals(other.userinfo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Friend [" + userinfo.getUname() + ", " + count + "]";
    }

}
