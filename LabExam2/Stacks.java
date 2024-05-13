package LabExam2;

public class Stacks {
        int top;
        int[] numArray;
        int[] numarr;
        int size;
        Stacks ( int capacity) {
            top= -1;
            numarr= new int[capacity] ;
            size =0;
        }
        public int size(){

            return size;
        }
        //1) push method
        public void push(int value){
            if (isFull()){
                System.out.println("the stack is full!");
            }
            numarr[++top]=value;
            size++;
        }
        void pop(){
            if (isEmpty()) {
                System.out.println("stack is empty");
            }else{
                int data=numarr[top--];
                size--;
                System.out.println(data);
            }
        }
        public int peek(){
            if(top>=0){
                return numarr[top];
            }
            return -1;
        }
        public boolean isEmpty(){
            return size==0;

        }
        public boolean isFull(){
            return size==numarr.length;
        }
        public static void main (String[] args){
            Stacks numStack=new Stacks(5);
            System.out.println(numStack);
            numStack.push(11);
            numStack.push(22);
            numStack.push(33);
            numStack.push(44);
            numStack.pop();
            numStack.pop();
            System.out.println(numStack.size());
            for (int i = 0; i< numStack.size; i++){
                System.out.println(numStack.numarr[i]);
            }
        }

}

