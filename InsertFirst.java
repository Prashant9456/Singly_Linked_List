public class InsertFirst {
    private InsertFirst.ListNode head;
    private static class ListNode{
        private int data;
        private InsertFirst.ListNode next;
        public ListNode(int data){
            this.data=data;
            this.next=null;

        }
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        InsertFirst.ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }
    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if (head==null){
            head=newNode;
            return;
        }
        ListNode current=head;
        while (current.next!=null){
            current =current.next;
        }
    }
    public void insert(int position, int value){
        ListNode node=new ListNode(value);
        if(position==1){
            node.next=head;
            head=node;
        }
        else{
            ListNode previous=head;
            int count=1;
            while(count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }
    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode temp= head;
        head= head.next;
        temp.next=null;
        return temp;
    }
    public ListNode deleteLast(){
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode previous=null;
        while (current.next!=null){
            previous= current;
            current=current.next;
        }
        previous.next=null;
        return current;
    }


    public void deletePosition(int position){
        if(position == 1){
            head = head.next;
        }
        else{
            ListNode previous =head;
            int count = 1;
            while(count<position-1){
                previous = previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=current.next;

        }


    }
    public ListNode getMiddleNode(){
        if (head == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr !=null && fastPtr.next !=null){
            slowPtr = slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n){
        if(head ==null){
            return null;

        }
        if (n<=0){
            throw new IllegalArgumentException("Invalid value:n="+n);
        }
        ListNode mainPtr =head;
        ListNode refPtr =head;
        int count =0;
        while(count<n){
            if(refPtr ==null){
                throw new IllegalArgumentException(n+"is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr !=null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }



    public void removeDuplicates(){
        if (head==null){
            return;
        }
        ListNode current = head;
        while (current !=null && current.next !=null){
            if(current.data == current.next.data){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
    }



    public void display(){
        InsertFirst.ListNode current = head;
        while (current !=null){
            System.out.print(current.data +"->");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[]args){
        InsertFirst sll=new InsertFirst();
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(4);
        sll.insertLast(5);
        sll.insertLast(25);

        sll.deleteFirst();
        sll.deleteFirst();
        System.out.println(sll.deleteLast().data);
        System.out.println(sll.deleteLast().data);
        sll.insert(1, 3);
        sll.insert(2, 3);
        sll.insert(1, 2);
        sll.insert(2, 2);
        //sll.display();
        //sll.deletePosition(1);
        //sll.deletePosition(3);
        //sll.deletePosition(3);
        ListNode middleNode=sll.getMiddleNode();
        //System.out.println("Middle Node Is-"+middleNode.data);
        sll.display();
        //System.out.println("Nth Node From The End="+sll.getNthNodeFromEnd(4));
        sll.removeDuplicates();
        sll.display();

    }
}
