import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaFriendSLL {
    private UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
    }

    public UserNode findUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 != null && u2 != null && userId1 != userId2) {
            if (!u1.friendIds.contains(userId2))
                u1.friendIds.add(userId2);
            if (!u2.friendIds.contains(userId1))
                u2.friendIds.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove((Integer) userId2);
            u2.friendIds.remove((Integer) userId1);
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + "'s Friends: " + user.friendIds);
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 != null && u2 != null) {
            Set<Integer> mutual = new HashSet<>(u1.friendIds);
            mutual.retainAll(u2.friendIds);
            System.out.println("Mutual Friends between " + userId1 + " and " + userId2 + ": " + mutual);
        }
    }

    public void searchByNameOrId(String name, Integer id) {
        UserNode temp = head;
        while (temp != null) {
            if ((id != null && temp.userId == id) || (name != null && temp.name.equals(name))) {
                System.out.println("Found: " + temp.name + " (ID: " + temp.userId + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public static void main(String[] args) {
        SocialMediaFriendSLL sm = new SocialMediaFriendSLL();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 21);
        sm.addUser(3, "Charlie", 22);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.displayFriends(1);
        sm.displayFriends(2);
        sm.findMutualFriends(2, 3);
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        sm.searchByNameOrId("Charlie", null);
    }
}