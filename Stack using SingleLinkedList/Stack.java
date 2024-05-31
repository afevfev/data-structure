import java.util.NoSuchElementException;
class Node {
    String name;
    double grade;
    Node next;
    Node(String name, double grade){
        this.grade=grade;
        this.name =name;
        next=null;
    }
}
class SinglyLinkedList {
    Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    public void append(String name, double grade) {
        Node newNode = new Node(name, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    //insert an element at the start
    public void insertAtStart(String name, double grade) {
        Node newNode = new Node(name, grade);
        newNode.next = head;
        head = newNode;
    }

    //deleting at the start of singly likedList
    public void deletingAtStart() {
        if (head != null) {
            Node current = head;
            head = head.next;
            current.next = null;
        }
    }

    public void InsertAtPosition(int pos, String name, double grade) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            insertAtStart(name, grade);
            return;
        }
        Node newNode = new Node(name, grade);
        Node current = head;
        Node prev = null;
        int index = 1;
        while (index < pos && current != null) {
            prev = current;
            current = current.next;
            index++;
        }
        if (index == pos) {
            prev.next = newNode;
            newNode.next = current;
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void DeleteAtPosition(int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deletingAtStart();
            return;
        }
        Node current = head;
        Node prev = null;
        int index = 1;
        while (index < pos && current != null) {
            prev = current;
            current = current.next;
            index++;
        }
        if (index == pos && current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void DeleteAfterANode(Node prevNode) {
        if (prevNode != null && prevNode.next != null) {
            Node nodeToDelete = prevNode.next;
            prevNode.next = nodeToDelete.next;
            nodeToDelete.next = null;
            return;
        }
        System.out.println("Invalid node");
    }

    public void searchNode(double grade) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (grade == current.grade) {
                System.out.println(grade + "is found at position: " + index +
                        " or it is at the node " + current + "of the linked list");
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println(grade + " Does not exist.");
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.name + " : " + current.grade);
            current = current.next;
        }
        System.out.println();
    }
    static class Stack {
        public int capacity;
        public int size;
        private SinglyLinkedList stackList;

        public Stack(int capacity) {
            stackList = new SinglyLinkedList();
            this.capacity = capacity;
            this.size = 0;
        }
        public boolean isEmpty() {
            return stackList.head == null;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void push(String name, double grade) {
            if (isFull()) {
                throw new IllegalStateException("Stack is full.");
            }
            stackList.insertAtStart(name, grade);
            size++;
        }

        public String pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty.");
            }
            Node headNode = stackList.head;
            stackList.deletingAtStart();
            size--;
            return headNode.name;
        }

        public String peekName() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty.");
            }
            return stackList.head.name;
        }
        public double peekGrade(){
            if(isFull()){
                throw new NoSuchElementException("Stack is empty.");
            }
            return stackList.head.grade;
        }

        public void displayStack() {
            Node currentNode = stackList.head;
            while (currentNode != null) {
                System.out.println("Name: " + currentNode.name + ", Grade: " + currentNode.grade);
                if (currentNode == stackList.head) {
                    System.out.println( currentNode.name + ", " + currentNode.grade);
                } else if (currentNode.next == null) {
                    System.out.println( currentNode.name + ", " + currentNode.grade);
                }
                currentNode = currentNode.next;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("\"SingleLinkedList: \"");
        SinglyLinkedList list= new SinglyLinkedList();
        list.append("Abebe", 3.6);
        list.append("Kidst", 3.7);
        list.append("Kal", 3.5);
        list.append("Kebede", 3.8);
        list.insertAtStart("Netsanet", 3.6);
        list.insertAtStart("Lema", 3.4);
        list.InsertAtPosition(2,"Hana",3.67);
        //list.deletingAtStart();
        //list.DeleteAtPosition(3);
        list.searchNode(3.6);
        //list.DeleteAfterANode(list.head);
        list.display();
        System.out.println("\"Stack with SingleLinkedList\"");
        Stack stack= new Stack(100);
        stack.push("Abeba", 3.6);
        stack.push("Kidus", 3.7);
        stack.pop();
        stack.push("Mahlet",3.5);
        stack.peekName();
        stack.peekGrade();
        stack.displayStack();

    }
}
//    public void insertAfter(Node prevNode, char newData){
//        Node newNode = new Node(newData);
//        newNode.next = prevNode.next;
//        prevNode.next = newNode;      the more improved one is the following
//        if (prevNode != null){
//            Node newNode = new Node(newData);
//            if(prevNode.next == null){
//                newNode.next = null;
//                prevNode.next= newNode;
//            }else{
//                newNode.next = prevNode.next;
//                prevNode.next = newNode;
//            }
//        }
//    }







