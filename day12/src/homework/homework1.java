package homework;

public class homework1 {

	public static void main(String[] args) {
		//��һС��
		String s = "ABCDEabcd123456!@#$%^";
		int sum1=0; //ͳ�ƴ�д��ĸ�ĸ���
		int sum2=0; //ͳ��Сд��ĸ�ĸ���
		int sum3=0; //ͳ�����ֵĸ���
		int sum4=0; //ͳ�������ַ��ĸ���
		
		char[] arr = s.toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			int temp = arr[i];
			if(temp>=97&&temp<=122) {
				sum2++;
			}else if(temp>=65&&temp<=90) {
				sum1++;
			}else if(temp>=48&&temp<=57) {
				sum3++;
			}else {
				sum4++;
			}
		}
		System.out.println("�ַ����й��д�д��ĸ"+sum1+"��");
		System.out.println("�ַ����й���Сд��ĸ"+sum2+"��");
		System.out.println("�ַ����й�������"+sum3+"��");
		System.out.println("�ַ����й��������ַ�"+sum4+"��");
		

		
		
	}

}
