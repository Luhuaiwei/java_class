package homework;

import java.util.LinkedList;

public class Question {

	public static void main(String[] args) {
		LinkedList<String> link=new LinkedList<String>();
		link.add("111");
		link.add("222");
		link.add("333");
		System.out.println(linked_queue(link));//此处结果为[111,222,333]
		System.out.println(link.size());//此处结果为0,为什么是0啊


	}
	private static LinkedList<String> linked_queue(LinkedList<String> link){
		LinkedList<String> linklist=new LinkedList<String>();
		LinkedList<String> linktemp=link;
	
		while(!(linktemp.isEmpty()))
		{
		linklist.add(linktemp.removeFirst());
	
		}
		return linklist;

	}

}
