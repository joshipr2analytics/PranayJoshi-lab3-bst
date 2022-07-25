package com.greatlearning.q2;
import java.util.*;

class FindSumPair{
    static class Node {
        int nodeData;
        Node leftNode, rightNode;
    }
    static Node NewNode(int nodeData){
        Node temp= new Node();
        temp.nodeData= nodeData;
        temp.leftNode=null;
        temp.rightNode=null;
        return temp;

    }
    public Node insert(Node root, int key) {
        if(root == null){
            return NewNode(key);
        }
        if(key < root.nodeData){
            root.leftNode= insert(root.leftNode,key);
        }else{
            root.rightNode= insert(root.rightNode, key);
        }
        return root;
    }
    public boolean findpairUtil(Node root, int sum, HashSet<Integer> set){
        if(root==null){
            return false;
        }
        if(findpairUtil(root.leftNode, sum, set)){
            return true;
        }
        if(set.contains(sum - root.nodeData)){
            System.out.println("Pair is Foound ("+(sum-root.nodeData)+","+root.nodeData+")");
            return true;
        }
        else{
            set.add(root.nodeData);
        }
        return findpairUtil(root.rightNode, sum, set);

    }
    public void findPairWithGivenSum(Node root, int sum){
        HashSet<Integer> set = new HashSet<Integer>();
        if(!findpairUtil(root, sum, set)){
            System.out.println("Pair doest not exist"+ "\n");
        }
    }
    public static void main(String[] args){
        Node root =null;
        FindSumPair fsp= new FindSumPair();
        root= fsp.insert(root,40);
        root= fsp.insert(root,20);
        root= fsp.insert(root,60);
        root= fsp.insert(root,10);
        root= fsp.insert(root,30);
        root= fsp.insert(root,50);
        root= fsp.insert(root,70);

        int sum = 130;
        fsp.findPairWithGivenSum(root, sum);
    }
}