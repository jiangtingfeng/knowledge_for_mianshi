package com.tree;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:38 2020/6/30
 */
public class BuildTree<T> implements Test {

    @Data
    public static class Node {
        private Node lNode;
        private Node rNode;
        private Object data;
        public Node(Object data) {
            this.data=data;
        }
        //构造一个新结点，该结点以lNode结点为其左孩子，rNode结点为其右孩子
        public Node(Node lNode,Node rNode,Object data) {
            this.lNode=lNode;
            this.rNode=rNode;
            this.data=data;
        }
    }
    //用一个根结点来表示二叉树
    private Node root;
    public BuildTree(Object data) {
        this.root=new Node(data);
    }
    //添加结点
    public Node addNode (Node parentNode,Object data,boolean isLeft) {
        //父节点为空
        if (parentNode == null) {
            throw new RuntimeException("父节点为空，无法添加子节点");
        }
        if (isLeft&&parentNode.lNode!=null){
            throw new RuntimeException("左子节点已经存在，添加失败");
        }
        if(!isLeft&&parentNode.rNode!=null) {
            throw new RuntimeException("右子节点已经存在，添加失败");
        }
        Node newNode=new Node(data);
        if(isLeft) {
            parentNode.lNode=newNode;
        }else {
            parentNode.rNode=newNode;
        }
        return newNode;
    }


    //前序遍历
    public List<Node> preOrder(){
        return preOrderTraverse(root);
    }
    public List<Node>preOrderTraverse(Node node){
        List<Node>list=new ArrayList<Node>();
        list.add(node);
        if(node.lNode!=null) {
            list.addAll(preOrderTraverse(node.lNode));
        }
        if(node.rNode!=null) {
            list.addAll(preOrderTraverse(node.rNode));
        }
        return list;
    }

    //中序遍历
    public List<Node> inOrder() {
        return inOrderTraverse(root);
    }
    public List<Node> inOrderTraverse(Node node) {
        List<Node>list=new ArrayList<Node>();
        if(node.lNode!=null) {
            list.addAll(inOrderTraverse(node.lNode));
        }
        list.add(node);
        if(node.rNode!=null) {
            list.addAll(inOrderTraverse(node.rNode));
        }
        return list;
    }

    //后序遍历
    public List<Node>postOrder(){
        return postOrderTraverse(root);
    }

    public List<Node>postOrderTraverse(Node node){
        List<Node>list=new ArrayList<Node>();
        if(node.lNode!=null) {
            list.addAll(postOrderTraverse(node.lNode));
        }
        if(node.rNode!=null) {
            list.addAll(postOrderTraverse(node.rNode));
        }
        list.add(node);
        return list;
    }

    public static void main(String[] args) {
        BuildTree<String> tree =new BuildTree<String>("根节点");
        Node t11=tree.addNode(tree.root, "左结点", true);
        Node t12=tree.addNode(tree.root, "右结点", false);
        Node t21=tree.addNode(t11, "左结点的左结点", true);
        Node t22=tree.addNode(t11, "左结点的右结点", false);

        mirror(tree.root);

        List<Node>node1=new ArrayList<Node>();
        node1=tree.preOrder();
        System.out.println("前序遍历的结果是：");
        for (Node node : node1) {
            System.out.println(node.data);
        }

        List<Node>nodes=new ArrayList<Node>();
        nodes=tree.inOrder();
        System.out.println("中序遍历的结果是：");
        for(Node i:nodes) {
            System.out.println(i.data);
        }

        List<Node>node2=new ArrayList<Node>();
        node2=tree.postOrder();
        System.out.println("后序遍历的结果是：");
        for(Node i:node2) {
            System.out.println(i.data);
        }


        ClassLoader classLoader = tree.getClass().getClassLoader();
        Proxy.newProxyInstance(classLoader, tree.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });


    }

    /**
     * 求BST镜像翻转的递归实现
     * 对二叉树树进行镜像翻转
     * 递归实现
     * 入参树根
     * 交换左右子树
     * 递归执行
     * @param root
     */
    private static void mirror(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.getLNode();
        root.setLNode(root.getRNode());
        root.setRNode(temp);
        mirror(root.getLNode());
        mirror(root.getRNode());
    }

    /**
     *@Description: TODO
     *@Author: jiangtingfeng
     * 非递归实现
     *  使用队列进行实现
     *@Date: 2020/6/30
     */



}
