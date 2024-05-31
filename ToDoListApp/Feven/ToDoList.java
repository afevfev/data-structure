package Feven;
class Task{
    private String title;
    private String description;
    private boolean completed;
    public Task(String title, String description){
        this.title=title;
        this.description=description;
        this.completed=false;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void markCompleted(){
        completed = true;
    }
}

public class ToDoList {
    private Node head;
    class Node{
        private Task task;
        private Node next;
        public Node(Task task){
            this.task=task;
            this.next=null;
        }
    }
    public void addToDo(Task task){
        Node newNode = new Node(task);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void markToAsCompleted(String title){
        Node current = head;
        while( current != null){
            if(current.task.getTitle().equals(title)){
                current.task.markCompleted();
                System.out.println("Task mark as completed");

                return;
            }current= current.next;
        }
        System.out.println("Task is not found!");

    }
    public void viewToDoList(){
        if(head == null){
            System.out.println("Task not found!");
        }else {
            System.out.println("tasks:");
            Node current = head;
            while(current != null){
                Task task =current.task;
                System.out.println("Title: "+ task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println((task.isCompleted()?"task completed":"Task is not completed"));
                System.out.println();
                current=current.next;
            }
        }
    }
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Task task1=new Task("Animal","Living thing");
        Task task2 = new Task("Butterfly","Can fly");
        Task task3 = new Task("History", "A Subject");
        Task task4 = new Task("Rock", "Non living thing");
        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);
        toDoList.addToDo(task4);
        toDoList.markToAsCompleted("Butterfly");
        System.out.println(task1.getTitle());
        System.out.println(task2.getDescription());
        task4.markCompleted();
        toDoList.viewToDoList();
        System.out.println(task1.getDescription());
        System.out.println(task3.isCompleted());
        System.out.println(task4.isCompleted());
    }
}
