package com.leetcode.methods.handler;

import com.leetcode.methods.listnode.KthNodeFromListEnd;
import com.leetcode.methods.listnode.MyLinkedList;
import com.leetcode.methods.listnode.ReverseList;
import com.leetcode.methods.tools.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author KoenigSEA
 */
@Component
@Configuration
public class ListNodeHandler implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(ListNodeHandler.class);

    @Value("${listnode.single}")
    private String singleExample;

    public void showExample() {
        System.out.println("Example Linked List is: [" + singleExample + "]");
    }

    public void reverseListCheck() {
        ListNode node = ListNode.stringToListNode(singleExample);
        ListNode nodeAnother = ListNode.stringToListNode(singleExample);
        ListNode resultOne = ReverseList.reverseList(node);
        ListNode resultTwo = ReverseList.reverseListRecursive(nodeAnother);
        ListNode.prettyPrintLinkedList(resultOne);
        ListNode.prettyPrintLinkedList(resultTwo);
    }

    public void kthNodeFromListEndCheck() {
        ListNode node = ListNode.stringToListNode(singleExample);
        int result = KthNodeFromListEnd.kthToLast(node, 3);
        System.out.println("Get 3rd value from end of example list: "+result);
    }

    public void myLinkedListCheck() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }

    @Override
    public void run(String... args) {
        showExample();
        logger.info("reverseListCheck()...");
        reverseListCheck();
        logger.info("reverseListCheck()..OK");
        logger.info("kthNodeFromListEndCheck()...");
        kthNodeFromListEndCheck();
        logger.info("kthNodeFromListEndCheck()..OK");
        logger.info("myLinkedListCheck()...");
        myLinkedListCheck();
        logger.info("myLinkedListCheck()..OK");
    }
}
