package dataStructs.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //加入按照编号的顺序
        /*singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);*/


        //显示
        System.out.println("原链表:");
        singleLinkedList.list();

        /*reversetList(singleLinkedList.getHead());
        System.out.println("反转后:");
        singleLinkedList.list();*/

        System.out.println("逆序打印(没有改变链表本身结构):");
        reversePrint(singleLinkedList.getHead());

        //测试修改节点的代码
        /*HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);*/


        //显示
        /*System.out.println("修改后:");
        singleLinkedList.list();


        //删除
        singleLinkedList.del(1);

        System.out.println("删除后:");
        singleLinkedList.list();


        System.out.println(getSize(singleLinkedList.getHead()));

        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);

        System.out.println(res);*/

    }

    //使用栈逆序打印单链表
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;//空链表
        }

        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }

        //将栈中的节点进行打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }


    //将单链表反转
    public static void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转
        if(head.next==null || head.next.next==null){
            return;
        }

        //定义一个辅助的指针，帮助遍历原来的链表
        HeroNode cur = head.next;

        HeroNode next = null; //指向当前节点的下一个节点

        HeroNode reverseHead = new HeroNode(0,"","");

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的最前端。
        while (cur != null){
            next = cur.next; //先暂时保存当前节点的下一个节点

            //以下这两步就是将遍历到的节点保存到新链表的最前端
            cur.next = reverseHead.next;//让cur节点指向reverseHead的下一个节点，这一步就是将遍历到的节点始终保存在新链表的最前端
            reverseHead.next = cur;//然后让reverseHead指向当前节点
            //


            cur=next;
        }

        head.next = reverseHead.next;
    }


    //查找单链表中的倒数第k个结点
    public static HeroNode findLastIndexNode(HeroNode head,int k){
        if(head.next == null){
            return null;
        }

        int size = getSize(head);

        if(k<=0||k>size){
            return null;
        }


        HeroNode temp = head.next;


        for(int i = 0; i < size-k; i++){
            temp = temp.next;
        }

        return  temp;

    }

    //获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    public static int getSize(HeroNode head){
        if(head.next == null){
            return 0;
        }

        HeroNode temp = head.next;

        int count = 0;

        while (temp!=null){
            count++;
            temp = temp.next;
        }

        return count;


    }
}

//定义SingleLinkedList管理英雄
class SingleLinkedList{
    //先初始化一个头节点,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    //添加节点到单向链表
    //不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //next为空，是链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }

        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }


    //按照顺序添加
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此仍然通过辅助变量来帮助找到添加的位置。
        //因为单链表，因此找的temp是位于添加位置的前一个节点，否则不能插入。
        HeroNode temp = head;

        boolean flag = false; //标识添加的编号是否存在
        while (true){
            if(temp.next == null){//说明temp已经在链表的最后
                break;
            }

            if(temp.next.no>heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){//说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }

            temp = temp.next;//后移
        }

        //判断flag的值
        if(flag){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    //修改节点的信息，根据no编号修改，no不能改
    //说明
    //1.根据newHeroNode的No来修改
    public void update(HeroNode newHeroNode){
        //判断是否空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.next;

        boolean flag = false;//表示是否找到该节点
        while (true){
            if(temp==null){
                break;//已经遍历完
            }

            if(temp.no == newHeroNode.no){
                //找到
                flag = true;
                break;
            }

            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {//没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
        }
    }



    //删除节点
    //思路
    //1.head不能动，因此需要一个temp辅助节点，找到待删除节点的前一个节点。
    //2.说明在比较时，时temp.next.no和需要删除的节点的no比较。
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;//标识是否找到待删除节点的前一个节点

        while (true){
            if(temp.next == null){//已经在链表的最后
                break;
            }

            if (temp.next.no==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的%d节点不存在\n",no);
        }

    }


    //遍历链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;

        while (true){
            //判断是否到最后
            if(temp == null){
                break;
            }
            //输出节点信息;
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个HeroNode对象就是一个节点。
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }



}
