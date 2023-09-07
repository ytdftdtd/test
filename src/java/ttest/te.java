package java.ttest;
import java.util.Scanner;
import java.util.Random;
public class te {
	public static void main(String[] args) {
		final int MAX_FAIL_CNT = 7;
		final int THE_NUMBER_OF_ALPHABETS = 26;
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		boolean isCont = true;
		String[] strs = {
                "what bus do i take to get to the zoo?",
                "take your time, please",
                "would you please charge the battery?",
                "what's the weather like?",
                "how much is it?",
                "that's what i'm saying",
                "how about going to the movies?",
                "is there a hotel in this area?",
                "make him do this",
                "can you set the table?",
                "i didn't mean any offense.",
                "did you clean up in here?",
                "would you like to help me clean up?",
                "i wan going to say that",
                "have you heard of it?",
                "there's nothing to be afraid of.",
                "how many times do i have to tell you?",
                "is it okay to stay late?",
                "why are you dressed up?",
                "actually something has come up.",
                "i'm screwed up.",
                "i don't know for sure",
                "why are you flirting with me"
        };
		do {
			char[] alphabets = new char[THE_NUMBER_OF_ALPHABETS];
			
			for(int i = 0; i < THE_NUMBER_OF_ALPHABETS; i++) {
				alphabets[i] = (char)(i + 'a');
			}
			
			int index = rnd.nextInt(strs.length);
			String question = strs[index];
			
			char[] answer = question.toCharArray();
			char[] under_bar_question = question.toCharArray();
			
			for(int i = 0; i < under_bar_question.length; i++) {
				if(Character.isLetter(under_bar_question[i])) {
					under_bar_question[i] = '_';
				}
			}
			int cnt = 0;
			while(isCont) {
				System.out.println("\n" + cnt + "번 틀렸습니다.");
				for(char ch: under_bar_question) {
					System.out.print(ch);
				}
				
				System.out.print("\n소문자 알파벳을 입력해주세요 :");
				char alphabet = sc.next().charAt(0);
				if(Character.isLowerCase(alphabet)) {
					int location = alphabet - 'a';
					if(alphabets[location] == ' ') {
						System.out.println("이미 사용된 알파벳입니다. 다시 입력해주세요.");
						continue;
					}
					else {
						alphabets[location] = ' ';
						
						boolean hasAlphabet = false;
						for(int i = 0; i < answer.length; i++) {
							if(answer[i] == alphabet) {
								under_bar_question[i] = alphabet;
								hasAlphabet = true;
							}
						}
						if(!hasAlphabet) {
							cnt++;
							if(cnt >= MAX_FAIL_CNT) {
								System.out.println(MAX_FAIL_CNT + "번 패배해 졌습니다.");
								break;
							}
						}
						else {
							boolean isSuccess = true;
							for(char ch: under_bar_question) {
								if(ch == '_') {
									isSuccess = false;
									break;
								}
							}
							if(isSuccess) {
								System.out.println(question);
								System.out.println("문제를 맞췄습니다.");
								break;
							}
						}
					}
				}
				else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
			}
			System.out.println("계속하시겠습니까(y/n) : ");
			isCont = sc.next().charAt(0) == 'y' ? true : false;
		}while(isCont);
		sc.close();
		
	}
}
