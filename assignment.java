//Q1.   Set an array such that the elements with higher frequency comes first, 
//if two elements tie the sort by ascending values.

import java.util.*;

public class ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert array to list for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Step 3: Sort using custom comparator
        list.sort((a, b) -> {
            int freqCompare = freqMap.get(b) - freqMap.get(a); // Descending frequency
            if (freqCompare == 0) {
                return a - b; // Ascending value if frequencies tie
            }
            return freqCompare;
        });

        // Step 4: Print result
        System.out.println("Sorted array by frequency:");
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}









//Q2.   Sliding window - Maximum Sum Subarray of size k. Also solve for dynamic window size 

import java.util.Scanner;

public class ques2 {
    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        if (k > n) {
            System.out.println("Window size cannot be greater than array size.");
        } else {
            System.out.println("Max sum of subarray of size " + k + ": " + maxSumSubarray(nums, k));
        }

        sc.close();
    }
}







//Q3.Find Intersection node of two linked list.
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; }
}

public class ques3 {
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    static Node findNode(Node head, int value) {
        while (head != null) {
            if (head.data == value) return head;
            head = head.next;
        }
        return null;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node headA = null, headB = null;

        System.out.print("Enter number of nodes in List A: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of List A:");
        for (int i = 0; i < n1; i++) headA = insert(headA, sc.nextInt());

        System.out.print("Enter number of nodes in List B: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of List B:");
        for (int i = 0; i < n2; i++) headB = insert(headB, sc.nextInt());

        System.out.print("Enter value where lists should intersect (must exist in List A): ");
        int intersectVal = sc.nextInt();
        Node intersectNode = findNode(headA, intersectVal);

        if (intersectNode == null) {
            System.out.println("Value not found in List A. No intersection created.");
        } else {
            // Attach intersection node to end of List B
            Node temp = headB;
            while (temp.next != null) temp = temp.next;
            temp.next = intersectNode;

            Node result = getIntersectionNode(headA, headB);
            System.out.println("Intersection at node with data: " + result.data);
        }

        sc.close();
    }
}

//Q4.Remove Nth node from end in a linked List
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; }
}

public class ques4 {
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy, second = dummy;

        for (int i = 0; i <= n; i++) {
            if (first == null) return head;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter number of nodes: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            head = insert(head, sc.nextInt());
        }

        System.out.print("Enter N (position from end to remove): ");
        int n = sc.nextInt();

        head = removeNthFromEnd(head, n);

        System.out.println("Updated List:");
        printList(head);

        sc.close();
    }
}









//Q5.Merge two sorted Linked List using Iteration
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; }
}

public class ques5 {
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1; l1 = l1.next;
            } else {
                tail.next = l2; l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node l1 = null, l2 = null;

        System.out.print("Enter size of List 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n1; i++) l1 = insert(l1, sc.nextInt());

        System.out.print("Enter size of List 2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n2; i++) l2 = insert(l2, sc.nextInt());

        Node merged = merge(l1, l2);
        System.out.println("Merged List:");
        print(merged);
        sc.close();
    }
}


















//Q6.Convert an array into Linked List without using java's built-in Linked List, create your own node class.
import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ques6 {
    // Convert array to linked list
    public static Node arrayToList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Convert to linked list
        Node head = arrayToList(arr);

        // Print linked list
        System.out.println("Linked List:");
        printList(head);
    }
}



















//Q7.Consider a Linked List with head given, reverse nodes in group of k.
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ques7 {
    // Reverse k nodes
    public static Node reverseKGroup(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Check if there are at least k nodes
        Node temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head;
            temp = temp.next;
        }

        // Reverse first k nodes
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Recursively reverse remaining list
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    // Print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Input node values
        System.out.println("Enter node values:");
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Input group size k
        System.out.print("Enter group size k: ");
        int k = sc.nextInt();

        System.out.println("Original list:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("Reversed list in groups of " + k + ":");
        printList(head);
    }
} 














//Q8.Detect a cycle in a Linked List.
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ques8 {
    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creates a cycle

        // Detect cycle
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move one step
            fast = fast.next.next;    // move two steps

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}










//Q9.Consider a sorted array and a number X find K closest numbers using two pointers.

import java.util.*;

public class ques9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input sorted array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target number X
        int x = sc.nextInt();

        // Input number of closest elements K
        int k = sc.nextInt();

        // Two-pointer approach
        int left = 0;
        int right = n - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("K closest elements to " + x + ":");
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}










//Q10.Given an array of heights, find how much maximum water can be stored between them (rain water trapping).

import java.util.Scanner;
public class ques10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i = 0; i < n; i++){
            height[i] = sc.nextInt();
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        System.out.println("Trapped water: " + water);
    }
}


