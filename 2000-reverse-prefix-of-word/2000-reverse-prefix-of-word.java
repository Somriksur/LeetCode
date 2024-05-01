
package subset;

public class ReverseAWord {
	
	
	public static  void reverseSwap(char[] charword,int end) {
		int start=0;
		while(start<=end) {
			char c=charword[start];
			charword[start]=charword[end];
			charword[end]=c;
			start++;
			end--;
		}
		return;
	}
	
	public static String reversePrefix(String word,char ch) {
		int i=0;
		char[] charword=word.toCharArray();
		for(char c:charword) {
			if(c==ch) {
				reverseSwap(charword,i);
				break;
			}
			i++;
		}
		StringBuilder sev=new StringBuilder();
		for(char c:charword)
			sev.append(c);
		return new String(sev);
	}
public static void main(String[] args) {
	System.out.println(reversePrefix(new String("abcd"),'z'));
}
}