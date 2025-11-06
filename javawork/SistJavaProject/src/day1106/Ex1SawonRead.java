package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex1SawonRead {
	
	public static void sawonRead() {
		
		String filename="C:\\sist1017\\work\\file\\sawon.txt";
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(filename);
			br=new BufferedReader(fr);
			int num=1;

			
			System.out.println("**\t\t사원 급여\t\t**");
			System.out.println("=========================================================================");
			System.out.println("번호\t사원명\t기본급\t가족수\t초과근무시간\t가족수당\t시간수당\t총합계");
			System.out.println("=========================================================================");
			
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;

				///split
//				String [] sawonInfo=s.split(",");
//				System.out.println(++num+"\t"+sawonInfo[0]+"\t"+sawonInfo[1]+"\t"+sawonInfo[2]+"\t"+sawonInfo[3]);
				///token
				StringTokenizer st=new StringTokenizer(s, ",");
				String name=st.nextToken();
				int gibonpay=Integer.parseInt(st.nextToken());
				int famsu=Integer.parseInt(st.nextToken());
				int timesu=Integer.parseInt(st.nextToken());
				
				int famSudang=famsu*30000;
				int timeSudang=timesu*20000;
				int totalPay=gibonpay+famSudang+timeSudang;
				
				
				System.out.println(num+++"\t"+name+"\t"+gibonpay+"원\t"+
				famsu+"명\t"+timesu+"시간\t"+famSudang+"원\t"+timeSudang+"원\t"+totalPay+"원");
				
				

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		sawonRead();
		
	}

}
