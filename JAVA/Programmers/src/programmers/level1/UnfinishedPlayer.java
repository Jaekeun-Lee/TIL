package programmers.level1;

import java.util.Arrays;

public class UnfinishedPlayer {

	public static String identify(String[] participant, String[] completion) {

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!(participant[i].equals(completion[i]))) {
				return participant[i];
			}
		}
		return participant[participant.length - 1];
	}

	public static void main(String[] args) {
		String[] participant = { "allen", "leo", "eden", "nikola", "vinko", "vinko", "filipa" };
		String[] completion = { "nikola", "leo", "filipa", "eden", "vinko", "vinko" };

		System.out.println(UnfinishedPlayer.identify(participant, completion));
	}
}
