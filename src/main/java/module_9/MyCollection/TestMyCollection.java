package module_9.MyCollection;

public class TestMyCollection {
    public static void main(String[] args) {
        System.out.println("/*****************************************  ArrayList  *****************************************/");
        MyList<Integer> myArrayList = new MyArrayList<Integer>(10);

        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(126);
        myArrayList.add(23);
        System.out.println(myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("myArrayList.get(2) = " + myArrayList.get(2));
        System.out.println("myArrayList.get(0) = " + myArrayList.get(0));

        System.out.println("myArrayList.remove(3) = " + myArrayList.remove(3));
        System.out.println("myArrayList.remove(1) = " + myArrayList.remove(1));
        System.out.println(myArrayList);

        System.out.println("clear()");
        myArrayList.clear();

        System.out.println(myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("/*****************************************  LinkedList  *****************************************/");
        MyList<Integer> myList = new MyLinkedList<Integer>();

        myList.add(65);
        myList.add(45);
        myList.add(2);
        myList.add(13);
        System.out.println("myList = " + myList);
        System.out.println("myList.size() = " + myList.size());

        System.out.println("myList.get(2) = " + myList.get(2));
        System.out.println("myList.get(0) = " + myList.get(0));

        System.out.println("myList.remove(3) = " + myList.remove(3));
        System.out.println("myList.remove(1) = " + myList.remove(1));
        System.out.println("myList = " + myList);

        System.out.println("clear()");
        myList.clear();

        System.out.println("myList = " + myList);
        System.out.println("myList.size() = " + myList.size());

        System.out.println("/*****************************************  Queue  *****************************************/");
        MyStack<String> myQueue = new MyLinkedList<String>();

        myQueue.add("Alex");
        myQueue.add("Oleksandr");
        myQueue.add("Max");
        myQueue.add("Anna");
        System.out.println("myQueue = " + myQueue);
        System.out.println("myQueue.size = " + myQueue.size());

        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue = " + myQueue);

        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue = " + myQueue);

        System.out.println("clear()");
        myQueue.clear();
        System.out.println("myQueue = " + myQueue);

        System.out.println("/*****************************************  Stack  *****************************************/");
        MyStack<String> myStack = new MyLinkedList<String>();
        myStack.push("Ann");
        myStack.push("Andrii");
        myStack.push("Oleksandr");
        myStack.push("Mykola");
        myStack.push("Roman");
        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack = " + myStack);

        System.out.println("clear()");
        myStack.clear();
        System.out.println("myStack = " + myStack);
    }
}