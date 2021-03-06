package sb.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, 
 * such that only one letter can be changed at a time and 
 * each intermediate word must exist in the dictionary. 
 * For example, given:
 * 
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 * 
 * Using breath-first search to find the shortest path
 * 
 * see http://www.programcreek.com/2012/12/leetcode-word-ladder/
 * @author alan
 *
 * http://web.stanford.edu/class/archive/cs/cs106b/cs106b.1134/handouts/15-Assignment2.pdf
 * 
 * For word ladders, the breadth-first strategy starts by examining those ladders that are
 * one step away from the original word, which means that only one letter has been
 * changed. If any of these single-step changes reach the destination word, you�re done. If
 * not, you can then move on to check all ladders that are two steps away from the original,
 * which means that two letters have been changed. In computer science, each step in such
 * a process is called a hop.
 * The breadth-first algorithm is typically implemented by using a queue to store partial
 * ladders that represent possibilities to explore. The ladders are enqueued in order of
 * increasing length. The first elements enqueued are all the one-hop ladders, followed by
 * the two-hop ladders, and so on. Because queues guarantee first-in/first-out processing,
 * these partial word ladders will be dequeued in order of increasing length.
 * To get the process started, you simply add a ladder consisting of only the start word to
 * the queue. From then on, the algorithm operates by dequeueing the ladder from the front
 * of the queue and determining whether it ends at the goal. If it does, you have a complete
 * ladder, which must be minimal. If not, you take that partial ladder and extend it to reach
 * words that are one additional hop away, and enqueue those extended ladders, where they
 * will be examined later. If you exhaust the queue of possibilities without having found a
 * completed ladder, you can conclude that no ladder exists.
 */
public class WordLadder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] dictionary = new String[] {"hot","dot","dog","lot","log"};
		Set<String> wordDict = new HashSet<String>(Arrays.asList(dictionary));
		int len = findLadderLength("hit", "cog", wordDict);
		System.out.println("length=" + len);
	}

	private static int findLadderLength(String start, String end, Set<String> dict) {
		int steps = 0;
		LinkedList<WordNode> queue = new LinkedList<>();
		WordNode w = new WordNode(start, 1);
		System.out.println("adding to queue:" + w);
		queue.add(w);
		dict.add(end);
		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			if (end.equals(top.word)) {
				return top.numSteps;
			}
			char[] array = top.word.toCharArray();			
			for (int i=0; i < array.length; i++) {
				char temp = array[i];
				for (char c='a'; c <= 'z'; c++) {
					if (c!=array[i]) {
						array[i] = c;
					}
					String newWord = String.valueOf(array);
					if (dict.contains(newWord)) {
						// Found the newWord in dictionary, possible path
						WordNode node = new WordNode(newWord, top.numSteps+1);
						queue.add(node);
						System.out.println("adding to queue:" + node);
						dict.remove(newWord);
					}
					// reset the word back
					array[i] = temp;
				}
			}
		}
		return steps;
	}
	
	static class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	    
	    public String toString() {
	    	return word +"|" + numSteps;
	    }
	}	
}
