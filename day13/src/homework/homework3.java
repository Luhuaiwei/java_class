package homework;

public class homework3 {

	public static void main(String[] args) {
		//��s�������еĲ�����sb���ֲ����״̬
		String s = "���븸�ײ�����Ѷ�������, ��������ǵ������ı�Ӱ";	
		StringBuilder sb = new StringBuilder(s);		
		
		//����һ�������������������������м������ҡ�
		//�Ա�ȷ�������ѭ����������ش���
		int sum=0;
		while(s.contains("��")) {
			int index = s.indexOf("��");
			sb.insert(index+(sum*3), "\"");
			sb.insert(index+2+(sum*3), "\"");
			s = s.substring(index+1);
			sum++;
		}
		
		System.out.println(sb);
		System.out.println(s);
		
	}

}
