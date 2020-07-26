package com.changtai.linkedlist;

/**
 * 单向链表节点
 *
 * @author zhaoct
 * @date 2020-07-25 17:07
 */
public class Node<E> {

    E item;
    Node<E> next;

    Node(E element, Node<E> next) {
        this.item = element;
        this.next = next;
    }
}
