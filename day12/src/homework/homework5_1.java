package homework;

import java.util.Scanner;

public class homework5_1 {

	public static void main(String[] args) {
		//��ά����
		//��ά����ľ�̬��ʼ��
		char[][] arrs1 = new char[][] {{},{}};
		//��ά����Ķ�̬��ʼ��
		char[][] arrs2 = new char[2][3];
		arrs2[0][0]= 'a';
		//��ά���鶯̬��ʼ��ʱ�����Բ�����ڶ���
		//�����������JVM����Ϊ�ڶ��㿪���ڴ�ռ䣬����ֵ��ʱ���ٷ����ڴ�
		char[][] arrs3 = new char[2][];
		//Object��
		//��Ҫ������
		//hashCode() ���ݵ�ֵַ����Ĺ�ϣ��ֵ
		//toString() ���ظö�����ַ�����ʾ��һ�㶼��Ҫ��д
		//equals() ͨ����ַ�Ƚϵ�ǰ������ָ������һ����Ҫ��дʹ��Ƚ�ֵ�Ĵ�С
		//== �Ƚϻ����������͵�ֵ���Ƚ������������͵ĵ�ַ�Ƿ���ȡ�
		//һ����дequalsҲ����дhashCode��֤equals��ȵ�ʱ��hashCodeҲ���
		//getClass() ���ض������
		Student stu = new Student();
		Student stu2= new Student();
		Student stu3= new Student();
	
		stu.setAge(11);
		stu3.setAge(11);
		
		boolean flg1 = stu3.equals(stu2);
		boolean flg2 = stu3.equals(stu);

		System.out.println(flg1);
		System.out.println(flg2);
		
		//Scanner�ࣺ��ȡһ���������һ��������ȡ��������
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		//String��
		//String����ͨ��ȫ���򲿷ֵ��ֽڻ��ַ������Լ���������
		char[] arr = new char[3];
		String s = new String(arr);
		//***���õ��жϷ���***
		String s1 = "string";
		String s2 = "string2";
		//�Ƚ��ַ��������Ƿ����
		boolean flg3 = s1.equals(s2);
		//���Դ�Сд�رȽ��ַ��������Ƿ����
		boolean flg4 = s1.equalsIgnoreCase(s2);
		//�жϴ��ַ������Ƿ����ĳС�ַ���
		boolean flg5 = s1.contains(s2);
		//�ж��ַ����Ƿ���ĳ���ַ���ͷ
		boolean flg6 = s1.startsWith(s2);
		//�ж��ַ����Ƿ�Ϊ��
		boolean flg7 = s1.isEmpty();
		
		//***���õĻ�ȡ����***
		//��ȡָ������λ�õ��ַ�
		char c = s1.charAt(0);
		//����ָ���ַ���һ�γ��ֵ�����
		int index = s1.indexOf(c);
		//indexOf()�ж�����ʽ���ܹ�����ָ���ַ��ַ�����ĳ�������ڵ��״�����
		//����lastIndexOf()������ͬ�ϣ�ֻ�������ҳ����һ��������
		int index2 = s1.lastIndexOf(c);
		//��ָ��������ȡ�ַ�����Ĭ�Ͻ�ȡ��ĩβ
		String s3 = s2.substring(index);
		
		//***�й��ַ������õ�ת������***
		//���ַ���ת�����ֽڡ��ַ�����
		byte[] bt = s1.getBytes();
		char[] ct = s1.toCharArray();
		//����������ת�����ַ���
		//ʹ��valueOf()���Խ�������������ת�����ַ���
		String s4 = String.valueOf(ct);
		//���ַ���ת�ɴ�д��Сд
		String s5 = s4.toUpperCase();
		//�ַ���ƴ��
		String s6 = s5.concat(s4);//concat�����+�����ȱ�ݣ��㲻��concat���ڵ�����
		
		//����
		//�滻,��A���a
		String s7 = s6.replace('a', 'A');
		//�и�,����
		String[] ss = s7.split(s7, ' ');//�����������ô��
		//��������
		String s9 = s7.trim();
		int i = s9.compareTo(s7);
	
	}

}
