package practice_package;

public class ToGetTextTest 
{
	public static void main(String[] args) {
		
	
	String text4="OTP with Ref no.4170 sent to 898XXXX763 please verify to complete your transaction  *OTP :523172";
			char chh[]=text4.toCharArray();
	String st3 = " ";
	
	int count1=0;
	for(int i=chh.length-1;i>=0;i--)
	{
		if(chh[i]>='0'&&chh[i]<='9')
		{
			if(count1<6)
			{
				st3=st3+chh[i];
			    count1++;
			}
			else {
				
			}
		}
	}
	System.out.println(st3);
	StringBuilder st4 = new StringBuilder(st3);
	st4.reverse();
	System.out.println(st4);
	
	}
	
	
	/*char ch3[]=text4.toCharArray();
	char ch4[]=new char[6];
	int j=0;
	for(int i=0;i<ch3.length;i++)
	{
		if(ch3[i]>='0'&&ch3[i]<='9')
		{
			ch4[j]=(ch3[i]);
			j++;
		}
	}
	String str1 = new String(ch4);
	System.out.println(str1);*/
}
