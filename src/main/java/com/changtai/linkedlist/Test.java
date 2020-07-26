package com.changtai.linkedlist;

public class Test<E> {

    public static void main(String[] args) {
        Test<Character> test = new Test();
        Character character_a = 'a';
        Character character_b = 'b';
        Character character_x = 'x';
        Character character_y = 'y';
        Character character_z = 'z';
        Character character_d = 'd';
        Character character_e = 'e';
        Character character_f = 'f';

        //第一个单向链表a->b->x->y->z
        LinkedList<Character> linkedList1 = new LinkedList<Character>();
        linkedList1.add(character_a);
        linkedList1.add(character_b);
        linkedList1.add(character_x);
        linkedList1.add(character_y);
        linkedList1.add(character_z);

        //第二个单向链表d->e->f->x->y->z
        LinkedList<Character> linkedList2 = new LinkedList<Character>();
        linkedList2.add(character_d);
        linkedList2.add(character_e);
        linkedList2.add(character_f);
        linkedList2.add(character_x);
        linkedList2.add(character_y);
        linkedList2.add(character_z);

        test.findIntersection(linkedList1,linkedList2);
    }

    private void findIntersection(LinkedList<E> linkedList1, LinkedList<E> linkedList2){

        System.out.println(linkedList1.size);
        System.out.println(linkedList2.size);

        //比较两个链表的元素的个数，多的放到longLinkedList，少的放到shortLinkedList
        LinkedList<E> longLinkedList = null;
        LinkedList<E> shortLinkedList = null;
        if(linkedList1.size < linkedList2.size){
            shortLinkedList = linkedList1;
            longLinkedList = linkedList2;
        }

        //长链表先向后移动longLinkedList.size-shortLinkedList.size，拿到node
        Node<E> node1 =  longLinkedList.first;
        Node<E> node2 =  shortLinkedList.first;
        E item = null;
        for(int i=0; i<longLinkedList.size-shortLinkedList.size; i++){
            node1 = node1.next;
        }

        //这个时候短链表与向后移动后的长链表是一样长的，同时进行遍历
        for(int i=0; i<shortLinkedList.size; i++){
            if(node1.item.equals(node2.item)){
                item = node1.item;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        //如果有相交的元素，两个链表就是合并了
        if(item != null){
            System.out.println("两个链表合并了，合并的元素是：" + item);
        }else{
            System.out.println("两个链表没有合并");
        }
    }
}
