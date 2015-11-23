/*
需求：抽取进制转换的特点，转换为一个函数，使其能把十进制的数转换为二进制、八进制、以及十六进制
思路：
1、使用查表法来进行进制转换，所以需要定义数组存储不同进制的字符{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}
2、需要使用容器来存储转换完成之后对应进制的表示，所以定义一个数组来存储，使用存储数量最多的二进制的存储容易，因为其也可存储八进制与十六进制。
3、定义一个变量来存储&运算之后所得的数字，该数字即为想要转换的禁制的一位。
4、&运算，转2禁制 &1；转八进制 &7，转十六禁制 &15，结果存入 临时变量。
5、无符号右移offset位（1、3、4）
6、循环4、5直到num变成0。
*/


class JinZhiZhuanHuanDemo
{
	public static void main(String[] args)
	{
		toOct(-237);
	}
	
	/*
	转二禁制
	*/
	public static void toBin(int num)
	{
		transform(num,1,1);
	}
	
	
	/*
	转八禁制
	*/
	public static void toOct(int num)
	{
		transform(num,7,3);
	}
	
	
	
	/*
	转十六禁制
	*/
	
	public static void toHex(int num)
	{
		transform(num,15,4);
	}
	
	public static void transform(int num,int base,int offset)
	{
		if(num == 0)
			return;
		
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] cc = new char[32];
		int pos = cc.length;
		while(num!=0)
		{
			int temp;
			temp = num & base;
			num = num >>> offset;
			cc[--pos]=chs[temp];
		}
		
		for(int x=pos;x<cc.length;x++)
		{
			System.out.print(cc[x]);
		}
	}
}
